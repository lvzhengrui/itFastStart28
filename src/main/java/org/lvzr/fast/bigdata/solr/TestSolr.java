package org.lvzr.fast.bigdata.solr;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;


public class SolrJTest {
     //ָ��solr�������ĵ�ַ  
     private final static String SOLR_URL = "http://localhost:8080/solr/";  

     /**
      * ����SolrServer����
      * 
      * �ö�������������ʹ�ã������̰߳�ȫ��  
      * 1��CommonsHttpSolrServer������web������ʹ�õģ�ͨ��http����� 
      * 2�� EmbeddedSolrServer����Ƕʽ�ģ�����solr��jar���Ϳ���ʹ����  
      * 3��solr 4.0֮���������˲��ٶ���������CommonsHttpSolrServer��������ΪHttpSolrClient
      * 
      * @return
      */
     public HttpSolrClient createSolrServer(){
         HttpSolrClient solr = null;
         solr = new HttpSolrClient(SOLR_URL);
         return solr;
     }


     /**
      * ������������ĵ�
     * @throws IOException 
     * @throws SolrServerException 
      */
     public void addDoc() throws SolrServerException, IOException{
        //����һƪ�ĵ�  
         SolrInputDocument document = new SolrInputDocument();  
         //��doc������ֶ�,�ڿͻ��������ӵ��ֶα����ڷ�������й�����  
         document.addField("id", "8");  
         document.addField("name", "������");  
         document.addField("description", "һ���ҳ�ţ�Ƶľ��¼�");  
         //���һ��solr����˵�����ȥ�ύ  ,ѡ������ĳһ��solr core
        HttpSolrClient solr = new HttpSolrClient(SOLR_URL + "my_core");
        solr.add(document);
        solr.commit();
        solr.close();
     }


     /** 
      * ����id��������ɾ���ĵ� 
      */
     public void deleteDocumentById() throws Exception {  
         //ѡ������ĳһ��solr core
         HttpSolrClient server = new HttpSolrClient(SOLR_URL+"my_core");  
         //ɾ���ĵ�  
         server.deleteById("8");  
         //ɾ�����е�����
         //solr.deleteByQuery("*:*");
         //�ύ�޸�  
         server.commit();  
         server.close();
     }  

     /**
      * ��ѯ
     * @throws Exception 
      */
     public void querySolr() throws Exception{
         HttpSolrClient solrServer = new HttpSolrClient(SOLR_URL+"my_core/");  
         SolrQuery query = new SolrQuery();  
         //��������solr��ѯ����
         //query.set("q", "*:*");// ����q  ��ѯ����   
         query.set("q","���ǳ�");//��ز�ѯ������ĳ������ĳ���ֶκ����ܡ��ǡ���������  �����ѯ���� ��������������������ѯ

         //����fq, ��query���ӹ��˲�ѯ����  
         query.addFilterQuery("id:[0 TO 9]");//idΪ0-4  

         //��query���Ӳ�����������  
         //query.addFilterQuery("description:��Ա");  //description�ֶ��к��С���Ա�����ֵ�����

         //����df,��query����Ĭ��������  
         query.set("df", "name");  

         //����sort,���÷��ؽ�����������  
         query.setSort("id",SolrQuery.ORDER.desc);

         //���÷�ҳ����  
         query.setStart(0);  
         query.setRows(10);//ÿһҳ����ֵ  

         //����hl,���ø���  
         query.setHighlight(true);  
         //���ø������ֶ�  
         query.addHighlightField("name");  
         //���ø�������ʽ  
         query.setHighlightSimplePre("<font color='red'>");  
         query.setHighlightSimplePost("</font>"); 

         //��ȡ��ѯ���
         QueryResponse response = solrServer.query(query);  
         //���ֽ����ȡ���õ��ĵ����ϻ���ʵ�����

         //��ѯ�õ��ĵ��ļ���  
         SolrDocumentList solrDocumentList = response.getResults();  
         System.out.println("ͨ���ĵ����ϻ�ȡ��ѯ�Ľ��"); 
         System.out.println("��ѯ�������������" + solrDocumentList.getNumFound());  
         //�����б�  
         for (SolrDocument doc : solrDocumentList) {
             System.out.println("id:"+doc.get("id")+"   name:"+doc.get("name")+"    description:"+doc.get("description"));
         } 

         //�õ�ʵ�����
         List<Person> tmpLists = response.getBeans(Person.class);
         if(tmpLists!=null && tmpLists.size()>0){
             System.out.println("ͨ���ĵ����ϻ�ȡ��ѯ�Ľ��"); 
             for(Person per:tmpLists){
                 System.out.println("id:"+per.getId()+"   name:"+per.getName()+"    description:"+per.getDescription());
             }
         }
     }

     public static void main(String[] args) throws Exception {
         SolrJTest solr = new SolrJTest();
         //solr.createSolrServer();
         solr.addDoc();
         solr.deleteDocumentById();
         solr.querySolr();
    }
}
