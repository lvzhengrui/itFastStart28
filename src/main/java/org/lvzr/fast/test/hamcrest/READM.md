

###hamcrest
hamcrest������Ч����junit�Ĳ�����������һЩ��ͨ�����������в���.

Hamcrest ��һ�����ԵĿ�ܣ����ṩ��һ��ͨ�õ�ƥ��� Matcher�����ʹ����Щƥ�������Ĺ��򣬳���Ա���Ը��Ӿ�ȷ�ı���Լ�
�Ĳ���˼�룬ָ�������趨�Ĳ������������磬��ʱ����Ĳ������ݷ�Χ̫�� ȷ�����������ɸ��̶���ȷ��ֵ����ʱ�ᵼ�²��Էǳ�
��������Ϊ�������Ĳ�������ֻҪ�����б仯���Ϳ��ܵ��²���ʧ�ܣ����� assertEquals( x, 10 ); ֻ���ж� x �Ƿ���� 10����� 
x ������ 10�� ����ʧ�ܣ�����ʱ��ָ���Ĳ������ݷ�Χ�ֲ���̫��ȷ����ʱ�п��ܻ����ĳЩ���ûᵼ�²��Բ�ͨ�������ݣ���Ȼ��
ͨ���������Ĳ��ԣ������ͻή�Ͳ��Եļ� ֵ�� Hamcrest �ĳ��֣�������Ա��д���������ṩ��һ�׹���ͷ�����ʹ������Ը��Ӿ�
ȷ�ı�����Ա�������Ĳ��Ե���Ϊ��


###hamcrest���õ�ƥ����:
����
anything - ����ƥ��,����㲻���Ĳ����µĶ�����ʲô�����õ�
describedAs - ���һ�����Ƶ�ʧ�ܱ���װ����
is - �Ľ��ɶ���װ���� - ���� ��Sugar��

�߼�
allOf - �������ƥ������ƥ���ƥ��, short circuits (���Ѷ���һ����,�����Ƕ�·,�о�����,��û�з���)(�� Java &&)
anyOf - ����κ�ƥ����ƥ���ƥ��, short circuits (�� Java ||)
not - �����װ��ƥ������ƥ����ʱƥ��,��֮��Ȼ

����
equalTo - ���Զ������ʹ��Object.equals����
hasToString - ����Object.toString����
instanceOf, isCompatibleType - ��������
notNullValue, nullValue - ����null
sameInstance - ���Զ���ʵ��
Beans
hasProperty - ����JavaBeans����

����
array - ����һ������Ԫ��test an array��s elements against an array of matchers
hasEntry, hasKey, hasValue - ����һ��Map����һ��ʵ��,������ֵ
hasItem, hasItems - ����һ�����ϰ���һ��Ԫ��
hasItemInArray - ����һ���������һ��Ԫ��

����
closeTo - ���Ը���ֵ�ӽ�������ֵ
greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - ���Դ���

�ı�
equalToIgnoringCase - �����ַ�����Ⱥ��Դ�Сд
equalToIgnoringWhiteSpace - �����ַ������Կհ�
containsString, endsWith, startsWith - �����ַ���ƥ��









