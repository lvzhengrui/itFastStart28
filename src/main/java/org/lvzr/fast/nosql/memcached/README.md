###����

telnet 127.0.0.1 11211

memcached.exe -d install ��װmemcached����
memcached -d start ����memcached����

memcached -d uninstall ж��memcached��
memcached -d restart ����memcached����
memcached -d stop|shutdown �ر��������е�memcached����
memcached -p �����Ķ˿�
memcached -l ���ӵ�IP��ַ, Ĭ���Ǳ���
memcached -u �Ե�������� (������root���е�ʱ����Ч
memcached -m ����ڴ�ʹ�ã���λMB��Ĭ��64M
memcached -M �ڴ�ľ�ʱ���ش��󣬶�����ɾ��
memcached -c ���ͬʱ��������Ĭ����102
memcached -f ���С�������ӣ�Ĭ����1.2
memcached -n ��С����ռ䣬key+value+flagsĬ����4
memcached -h ��ʾ����
  
netstat -an
  


###memcached���
һ�� ����
Memcached��danga.com����ӪLiveJournal�ļ����Ŷӣ�������һ�׷ֲ�ʽ�ڴ���󻺴�ϵͳ�������ڶ�̬ϵͳ�м������ݿ⸺�أ��������ܡ�

���� ���ó���

1. �ֲ�ʽӦ�á�����memcached������ڷֲ�ʽ��ϵͳ�����������ʺϴ��͵ķֲ�ʽϵͳ��

2. ���ݿ�ǰ�λ��档���ݿⳣ������վϵͳ��ƿ�������ݿ�Ĵ󲢷������ʣ����������վ�ڴ��������Ȼ����Ҳ����ʹ��hibernate�Ļ�����ơ���memcached�ǻ��ڷֲ�ʽ�ģ����ɶ�������վӦ�ñ������Ը��ʺϴ�����վ����Ӧ�õĲ�֡�

3. �����������ݹ����������������ǽ���վ�ĵ�¼ϵͳ����ѯϵͳ���Ϊ����Ӧ�ã����ڲ�ͬ�ķ������ϣ������м�Ⱥ�������ʱ���û���¼�󣬵�¼��Ϣ��δӵ�¼ϵͳ������ͬ������ѯϵͳ�������أ���ʱ�����Ǳ����ʹ��memcached����¼ϵͳ����¼��Ϣ������������ѯϵͳ����Ի�õ�¼��Ϣ�������ȡ������Ϣһ����

���� �����ó���

��Щ����Ҫ���ֲ����ģ�����Ҫ����ģ����߸ɴ��ģС��ֻ��һ̨��������Ӧ�ã�memcached��������κκô����෴��������ϵͳЧ�ʣ���Ϊ��������ͬ����Ҫ��Դ

�ġ� ��װ
�������windows�����İ�װ��
1. ����memcache��windows�ȶ��棬��ѹ��ĳ�������棬������c:\memcached
2. ��cmd������ 'c:\memcached\memcached.exe -d install' ��װ
3. �����룺 'c:\memcached\memcached.exe -d start' ������
�Ժ�memcached����Ϊwindows��һ������ÿ�ο���ʱ�Զ��������������������Ѿ���װ����ˡ�


