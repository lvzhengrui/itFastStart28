package org.lvzr.fast.bigdata.elasticsearch;

import java.util.*;
import java.util.Map.Entry;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

public class TestEs {

	private TransportClient client;

	public TestEs() {
		this.client = new TransportClient().addTransportAddress(
				new InetSocketTransportAddress("127.0.0.1", 9300));
	}
 
	/**
	 * 生成一个索引。这里用Map来保存json数据，然后插入到index为“twitter”的索引里面
	 * ,其document为“tweet”，id为“1”
	 */
	public void generateIndex() {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("user", "kimchy");
		json.put("postDate", new Date());
		json.put("message", "trying out Elastic Search");
		IndexResponse response = this.client.prepareIndex("twitter", "tweet", "1")
			.setSource(json).execute().actionGet();
	}

	/**
	 * 查询
	 */
	public void getIndex() {
		GetResponse response = client.prepareGet("twitter", "tweet", "1")
			.execute().actionGet();
		Map<String, Object> rpMap = response.getSource();
		if (rpMap == null) {
			System.out.println("empty");
			return;
		}
		Iterator<Entry<String, Object>> rpItor = rpMap.entrySet().iterator();
		while (rpItor.hasNext()) {
			Entry<String, Object> rpEnt = rpItor.next();
			System.out.println(rpEnt.getKey() + " : " + rpEnt.getValue());
		}
	}

	/**
	 * 搜索
	 */
	public void searchIndex() {
		QueryBuilder qb = QueryBuilders.termQuery("user", "kimchy");
		
		// 100 hits per shard will
		// be returned for each
		// scroll
		SearchResponse scrollResp = client.prepareSearch("twitter")
			.setSearchType(SearchType.SCAN)
			.setScroll(new TimeValue(60000))
			.setQuery(qb)
			.setSize(100)
			.execute().actionGet(); 
		
		// Scroll until no hits are returned
		while (true) {
			scrollResp = client.prepareSearchScroll(scrollResp.getScrollId())
				.setScroll(new TimeValue(60000))
				.execute().actionGet();
			
			for (SearchHit hit : scrollResp.getHits()) {
				Iterator<Entry<String, Object>> rpItor = hit.getSource().entrySet().iterator();
				while (rpItor.hasNext()) {
					Entry<String, Object> rpEnt = rpItor.next();
					System.out.println(rpEnt.getKey() + " : " + rpEnt.getValue());
				}
			}
			// Break condition: No hits are returned
			if (scrollResp.getHits().hits().length == 0) {
				break;
			}
		}
	}

	/**
	 * 删除
	 */
	public void deleteIndex() {
		DeleteResponse response = client.prepareDelete("twitter", "tweet", "1")
			.execute().actionGet();
	}

	/**
	 * 关闭
	 */
	public void closeClient() {
		client.close();
	}

}