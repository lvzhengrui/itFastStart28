




###�鿴����
bin/solr -help     
        ���Կ���solr����Щ������� start, stop, restart, status, healthcheck, create, create_core, create_collection, delete, version
        
###����start
bin/solr start  -help    �鿴start����
bin/solr start        ����������
bin/solr start -f           ǰ̨����
bin/solr start -p 8984        ָ���˿�����
bin/solr start -cloud        �����ֲ�ʽ�汾
bin/solr start -e cloud -noprompt         -e��ʾҪ����һ�����е����ӣ�����������cloud��cloud�����������SolrCloud��ʽ������
bin/solr restart          ������Ŀ



###create
����ǵ�����Ҫ����core������Ƿֲ�ʽ��Ҫ����collection

bin/solr create -help     �鿴create����
bin/solr create -c abc

        abc��core��collection�����֣�ȡ����solr�ǵ����滹��cloud�汾��ˢ��http://localhost:8983/solr �����Կ���core selector�ж���һ��abc
        abcĿ¼��λ�ô�����solr.solr.home��Ĭ����solr��server/solrĿ¼��Ŀ¼��


###post�ύ������������
bin/post -c abc docs/
        ����Ϊabc��core��collection�ύ���ݣ�����Դ��docs/Ŀ¼��

###ɾ��
bin/solr delete -c abc     ɾ��һ��core��collection

###ɾ������
bin/post -c abc  -d "<delete><id>/home/matthewi/software/solr-5.4.1/docs/solr-morphlines-core/allclasses-noframe.html</id></delete>"
����ִ��������������Կ��������������������һ����numFound��

bin/post -c abc -d "<delete><query>*:*</query></delete>"
ɾ����������

###ֹͣsolr
bin/solr stop -all

###״̬
bin/solr status


-------------------------------------------------------------------------
###Elasticsearch��Solr�ıȽ�*
http://blog.csdn.net/xvshu/article/details/50749809
�������Ķ��������ݽ�������ʱ��Solr���졣
��ʵʱ��������ʱ, Solr�����io��������ѯ���ܽϲ�, Elasticsearch�������Ե����ơ�
***���������������ӣ�Solr������Ч�ʻ��ø��ͣ���Elasticsearchȴû�����Եı仯��**
����������Solr�ļܹ����ʺ�ʵʱ������Ӧ�á�

���߰�װ���ܼ򵥣�
Solr ���� Zookeeper ���зֲ�ʽ������ Elasticsearch ������зֲ�ʽЭ��������;
Solr ֧�ָ����ʽ�����ݣ��� Elasticsearch ��֧��json�ļ���ʽ��
Solr �ٷ��ṩ�Ĺ��ܸ��࣬�� Elasticsearch �����ע���ں��Ĺ��ܣ��߼����ܶ��е���������ṩ��
Solr �ڴ�ͳ������Ӧ���б��ֺ��� Elasticsearch�����ڴ���ʵʱ����Ӧ��ʱЧ�����Ե��� Elasticsearch��
Solr �Ǵ�ͳ����Ӧ�õ���������������� Elasticsearch �����������˵�ʵʱ����Ӧ�á�


###Solr����ȱ��
�ŵ�
	Solr��һ�����󡢸�������û��������͹�����������
	֧����Ӷ��ָ�ʽ���������磺HTML��PDF��΢�� Office ϵ�������ʽ�Լ� JSON��XML��CSV �ȴ��ı���ʽ��
	Solr�Ƚϳ��졢�ȶ���
	�����ǽ�������ͬʱ�����������ٶȸ��졣
ȱ��
	**��������ʱ������Ч���½���ʵʱ��������Ч�ʲ��ߡ�**


###Elasticsearch����ȱ��**:
�ŵ�
	Elasticsearch�Ƿֲ�ʽ�ġ�����Ҫ����������ַ���ʵʱ�ģ���������Push replication����
	Elasticsearch ��ȫ֧�� Apache Lucene �Ľӽ�ʵʱ��������
	������⻧��multitenancy������Ҫ�������ã���Solr����Ҫ����ĸ߼����á�
	Elasticsearch ���� Gateway �ĸ��ʹ���걸�ݸ��Ӽ򵥡�
	���ڵ���ɶԵȵ�����ṹ��ĳЩ�ڵ���ֹ���ʱ���Զ����������ڵ��������й�����
ȱ��
	ֻ��һ�������ߣ���ǰElasticsearch GitHub��֯�Ѿ���ֻ��ˣ��Ѿ������൱��Ծ��ά���ߣ�
	�������Զ������ʺϵ�ǰ�µ�Index Warmup API��




--------------------------------------------------------------------------
solr��java�е�ʹ��
http://blog.csdn.net/u012385190/article/details/53115546


ѧϰsolr�Ļ���֪ʶ��http://blog.csdn.net/u012385190/article/details/51682380 
�ο��ĵ���http://www.doc88.com/p-6763747939865.html

SolrJ�ǲ���Solr��Java�ͻ��ˣ����ṩ�����ӡ��޸ġ�ɾ������ѯSolr������JAVA�ӿڡ�SolrJ��� Solr�ṩ��Rest ��HTTP�ӿڽ����˷�װ�� 
SolrJ�ײ���ͨ��ʹ��httpClient�еķ��������Solr�Ĳ�����


