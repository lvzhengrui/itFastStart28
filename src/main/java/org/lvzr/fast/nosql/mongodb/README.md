
###��������
http://www.jb51.net/article/48217.htm


###��������
mongod.exe --dbpath=E:\��Դ��Ŀ\nosql\mongo\db 
pause


###����������
mongo

###��������
�л����򴴽�test���ݿ�
use test

�õ���ǰdb�����оۼ�����
db.getCollectionNames();

��ʾ�������ݿ�
show dbs

Help�鿴������ʾ
help
db.help();
db.yourColl.help();
db.youColl.find().help();
rs.help();


ɾ����ǰʹ�����ݿ�
db.dropDatabase();

��ָ�������Ͽ�¡���ݿ�
db.cloneDatabase(��127.0.0.1��); ��ָ�������ϵ����ݿ�����ݿ�¡����ǰ���ݿ�

db.copyDatabase("mydb", "temp", "127.0.0.1");��������mydb�����ݸ��Ƶ�temp���ݿ���

db.repairDatabase();

db.getName();
db; db��getName������һ����Ч���������Բ�ѯ��ǰʹ�õ����ݿ�


����һ���ۼ����ϣ�table��
db.createCollection(��collName��, {size: 20, capped: 5, max: 100});//�����ɹ�����ʾ{��ok��:1}
//�жϼ����Ƿ�Ϊ������db.collName.isCapped();

��ѯuserInfo���ϵ�age = 22�ļ�¼
db.userInfo.find({"age": 22});

�г��������м�¼
db.userInfo.find({});



-------------------------------------------------------------------------------------------------------
�磺������봴��һ����myTest�������ݿ⣬������use myTest���֮�����һЩ�������磺db.createCollection('user')��,
�����Ϳ��Դ���һ�����С�myTest�������ݿ⡣


###һ�����ݿⳣ������
1��Help�鿴������ʾ


���ƴ��� ��������:

help
db.help();
db.yourColl.help();
db.youColl.find().help();
rs.help();

2���л�/�������ݿ�

���ƴ��� ��������:

use yourDB; ������һ������(table)��ʱ����Զ�������ǰ���ݿ�

3����ѯ�������ݿ�

���ƴ��� ��������:

show dbs;

4��ɾ����ǰʹ�����ݿ�

���ƴ��� ��������:

db.dropDatabase();

5����ָ�������Ͽ�¡���ݿ�

���ƴ��� ��������:

db.cloneDatabase(��127.0.0.1��); ��ָ�������ϵ����ݿ�����ݿ�¡����ǰ���ݿ�

6����ָ���Ļ����ϸ���ָ�����ݿ����ݵ�ĳ�����ݿ�

���ƴ��� ��������:

db.copyDatabase("mydb", "temp", "127.0.0.1");��������mydb�����ݸ��Ƶ�temp���ݿ���

7���޸���ǰ���ݿ�

���ƴ��� ��������:

db.repairDatabase();

8���鿴��ǰʹ�õ����ݿ�

���ƴ��� ��������:

db.getName();
db; db��getName������һ����Ч���������Բ�ѯ��ǰʹ�õ����ݿ�

9����ʾ��ǰdb״̬

���ƴ��� ��������:

db.stats();

10����ǰdb�汾

���ƴ��� ��������:

db.version();

11���鿴��ǰdb�����ӻ�����ַ

���ƴ��� ��������:

db.getMongo();



###����Collection�ۼ�����
1������һ���ۼ����ϣ�table��


���ƴ��� ��������:

db.createCollection(��collName��, {size: 20, capped: 5, max: 100});//�����ɹ�����ʾ{��ok��:1}
//�жϼ����Ƿ�Ϊ������db.collName.isCapped();

2���õ�ָ�����Ƶľۼ����ϣ�table��

���ƴ��� ��������:

db.getCollection("account");

3���õ���ǰdb�����оۼ�����

���ƴ��� ��������:

db.getCollectionNames();

4����ʾ��ǰdb���оۼ�������״̬

���ƴ��� ��������:

db.printCollectionStats();



###�����û���� 
1�����һ���û�

���ƴ��� ��������:

db.addUser("name");
db.addUser("userName", "pwd123", true); ����û����������롢�Ƿ�ֻ��

2�����ݿ���֤����ȫģʽ

���ƴ��� ��������:

db.auth("userName", "123123");

3����ʾ��ǰ�����û�

���ƴ��� ��������:

show users;

4��ɾ���û�

���ƴ��� ��������:

db.removeUser("userName");



###�ġ��ۼ����ϲ�ѯ 
1����ѯ���м�¼

���ƴ��� ��������:

db.userInfo.find();
�൱�ڣ�select* from userInfo;

Ĭ��ÿҳ��ʾ20����¼������ʾ���µ�����£�������it���������ѯ��һҳ���ݡ�ע�⣺����it����ܴ�������
�������������ÿҳ��ʾ���ݵĴ�С����DBQuery.shellBatchSize= 50;����ÿҳ����ʾ50����¼�ˡ�
2����ѯȥ����ĵ�ǰ�ۼ������е�ĳ�е��ظ�����

���ƴ��� ��������:

db.userInfo.distinct("name");
����˵�name�е���ͬ����
�൱�ڣ�select distict name from userInfo;

3����ѯage = 22�ļ�¼

���ƴ��� ��������:

db.userInfo.find({"age": 22});
�൱�ڣ� select * from userInfo where age = 22;

4����ѯage > 22�ļ�¼

���ƴ��� ��������:

db.userInfo.find({age: {$gt: 22}});
�൱�ڣ�select * from userInfo where age >22;

5����ѯage < 22�ļ�¼

���ƴ��� ��������:

db.userInfo.find({age: {$lt: 22}});
�൱�ڣ�select * from userInfo where age <22;

6����ѯage >= 25�ļ�¼

���ƴ��� ��������:

db.userInfo.find({age: {$gte: 25}});
�൱�ڣ�select * from userInfo where age >= 25;

7����ѯage <= 25�ļ�¼

���ƴ��� ��������:

db.userInfo.find({age: {$lte: 25}});

8����ѯage >= 23 ���� age <= 26

���ƴ��� ��������:

db.userInfo.find({age: {$gte: 23, $lte: 26}});

9����ѯname�а��� mongo������

���ƴ��� ��������:

db.userInfo.find({name: /mongo/});
//�൱��%%
[code]select * from userInfo where name like ��%mongo%';

10����ѯname����mongo��ͷ��

���ƴ��� ��������:

db.userInfo.find({name: /^mongo/});
select * from userInfo where name like ��mongo%';

11����ѯָ����name��age����

���ƴ��� ��������:

db.userInfo.find({}, {name: 1, age: 1});
�൱�ڣ�select name, age from userInfo;

��ȻnameҲ������true��false,����ture������º�name:1Ч��һ���������false�����ų�name����ʾname���������Ϣ��
12����ѯָ����name��age����, age > 25

���ƴ��� ��������:

db.userInfo.find({age: {$gt: 25}}, {name: 1, age: 1});
�൱�ڣ�select name, age from userInfo where age >25;

13��������������

���ƴ��� ��������:

����db.userInfo.find().sort({age: 1});
����db.userInfo.find().sort({age: -1});

14����ѯname = zhangsan, age = 22������

���ƴ��� ��������:

db.userInfo.find({name: 'zhangsan', age: 22});
�൱�ڣ�select * from userInfo where name = ��zhangsan' and age = ��22';

15����ѯǰ5������

���ƴ��� ��������:

db.userInfo.find().limit(5);
�൱�ڣ�selecttop 5 * from userInfo;

16����ѯ10���Ժ������

���ƴ��� ��������:

db.userInfo.find().skip(10);
�൱�ڣ�select * from userInfo where id not in (
selecttop 10 * from userInfo
);

17����ѯ��5-10֮�������

���ƴ��� ��������:

db.userInfo.find().limit(10).skip(5);

�����ڷ�ҳ��limit��pageSize��skip�ǵڼ�ҳ*pageSize
18��or�� ��ѯ

���ƴ��� ��������:

db.userInfo.find({$or: [{age: 22}, {age: 25}]});
�൱�ڣ�select * from userInfo where age = 22 or age = 25;

19����ѯ��һ������

���ƴ��� ��������:

db.userInfo.findOne();
�൱�ڣ�selecttop 1 * from userInfo;
db.userInfo.find().limit(1);

20����ѯĳ��������ļ�¼����

���ƴ��� ��������:

db.userInfo.find({age: {$gte: 25}}).count();
�൱�ڣ�select count(*) from userInfo where age >= 20;

21������ĳ�н�������

���ƴ��� ��������:

db.userInfo.find({sex: {$exists: true}}).count();
�൱�ڣ�select count(sex) from userInfo;



###�塢����
1����������

���ƴ��� ��������:

db.userInfo.ensureIndex({name: 1});
db.userInfo.ensureIndex({name: 1, ts: -1});

2����ѯ��ǰ�ۼ�������������

���ƴ��� ��������:

db.userInfo.getIndexes();

3���鿴��������¼��С

���ƴ��� ��������:

db.userInfo.totalIndexSize();

4����ȡ��ǰ���ϵ�����index��Ϣ

���ƴ��� ��������:

db.users.reIndex();

5��ɾ��ָ������

���ƴ��� ��������:

db.users.dropIndex("name_1");

6��ɾ��������������

���ƴ��� ��������:

db.users.dropIndexes();



###�����޸ġ���ӡ�ɾ����������
1�����

���ƴ��� ��������:

db.users.save({name: ��zhangsan', age: 25, sex: true});

��ӵ����ݵ������У�û�й̶���������ӵ�����Ϊ׼
2���޸�

���ƴ��� ��������:

db.users.update({age: 25}, {$set: {name: 'changeName'}}, false, true);
�൱�ڣ�update users set name = ��changeName' where age = 25;
db.users.update({name: 'Lisi'}, {$inc: {age: 50}}, false, true);
�൱�ڣ�update users set age = age + 50 where name = ��Lisi';
db.users.update({name: 'Lisi'}, {$inc: {age: 50}, $set: {name: 'hoho'}}, false, true);
�൱�ڣ�update users set age = age + 50, name = ��hoho' where name = ��Lisi';

3��ɾ��

���ƴ��� ��������:

db.users.remove({age: 132});

4����ѯ�޸�ɾ��

���ƴ��� ��������:

db.users.findAndModify({
    query: {age: {$gte: 25}}, 
    sort: {age: -1}, 
    update: {$set: {name: 'a2'}, $inc: {age: 2}},
    remove: true
});
db.runCommand({ findandmodify : "users", 
    query: {age: {$gte: 25}}, 
    sort: {age: -1}, 
    update: {$set: {name: 'a2'}, $inc: {age: 2}},
    remove: true
});

update �� remove ����һ���Ǳ���Ĳ���; ����������ѡ��
����    ���     Ĭ��ֵ 
query    ��ѯ��������    {} 
sort    �������ĵ����ϲ�ѯ�������������Ըò���ָ�������з�ʽѡ���������λ�Ķ��󣬸ö��󽫱�����    {} 
remove    ��Ϊtrue����ѡ�ж����ڷ���ǰ��ɾ��    N/A 
update    һ�� �޸�������
N/A 
new    ��Ϊtrue���������޸ĺ�Ķ��������ԭʼ������ɾ�������У��ò��������ԡ�    false 
fields    �μ�Retrieving a Subset of Fields (1.5.0+) 
All fields 
upsert    �����¶�������ѯ���Ϊ�ա� ʾ�� (1.5.4+) 
false 


###�ߡ�������� 
1����Hello World

���ƴ��� ��������:

print("Hello World!");

����д��������print��������ֱ��д��"Hello World!"��Ч����һ���ģ�
2����һ������ת����json

���ƴ��� ��������:

tojson(new Object());
tojson(new Object('a'));

3��ѭ���������

���ƴ��� ��������:

> for (var i = 0; i < 30; i++) {
... db.users.save({name: "u_" + i, age: 22 + i, sex: i % 2});
... };

������ѭ�������30�����ݣ�ͬ��Ҳ����ʡ�����ŵ�д��

���ƴ��� ��������:

> for (var i = 0; i < 30; i++) db.users.save({name: "u_" + i, age: 22 + i, sex: i % 2});

Ҳ�ǿ��Եģ�������db.users.find()��ѯ��ʱ����ʾ�������ݶ��޷�һҳ��ʾ������£�������it�鿴��һҳ����Ϣ��
4��find �α��ѯ

���ƴ��� ��������:

>var cursor = db.users.find();
> while (cursor.hasNext()) { 
    printjson(cursor.next()); 
}

�����Ͳ�ѯ���е�users��Ϣ��ͬ����������д

���ƴ��� ��������:

var cursor = db.users.find();
while (cursor.hasNext()) { printjson(cursor.next); }

ͬ������ʡ��{}��
5��forEach����ѭ��

���ƴ��� ��������:

db.users.find().forEach(printjson);

forEach�б��봫��һ������������ÿ��������������Ϣ
6����find�α굱���鴦��

���ƴ��� ��������:

var cursor = db.users.find();
cursor[4];

ȡ���±�����Ϊ4����������
��Ȼ���Ե������鴦����ô�Ϳ��Ի�����ĳ��ȣ�cursor.length();����cursor.count();
��������Ҳ������ѭ����ʾ����

���ƴ��� ��������:

for (var i = 0, len = c.length(); i < len; i++) printjson(c[i]);

7����find�α�ת��������

���ƴ��� ��������:

> var arr = db.users.find().toArray();
> printjson(arr[2]);

��toArray��������ת��Ϊ����
8�����������Լ��Ĳ�ѯ���
ֻ��ʾage <= 28�Ĳ���ֻ��ʾage��������

���ƴ��� ��������:

db.users.find({age: {$lte: 28}}, {age: 1}).forEach(printjson);
db.users.find({age: {$lte: 28}}, {age: true}).forEach(printjson);

�ų�age����

���ƴ��� ��������:

db.users.find({age: {$lte: 28}}, {age: false}).forEach(printjson);

9��forEach���ݺ�����ʾ��Ϣ

���ƴ��� ��������:

db.things.find({x:4}).forEach(function(x) {print(tojson(x));});


###�ˡ����� 
1����ѯ֮ǰ�Ĵ�����Ϣ


���ƴ��� ��������:

db.getPrevError();

2����������¼

���ƴ��� ��������:

db.resetError();

�鿴�ۼ����ϻ�����Ϣ
1���鿴����  db.yourColl.help();
2����ѯ��ǰ���ϵ���������  db.yourColl.count();
3���鿴���ݿռ��С db.userInfo.dataSize();
4���õ���ǰ�ۼ��������ڵ�db db.userInfo.getDB();
5���õ���ǰ�ۼ���״̬ db.userInfo.stats();
6���õ��ۼ������ܴ�С db.userInfo.totalSize();
7���ۼ����ϴ���ռ��С db.userInfo.storageSize();
8��Shard�汾��Ϣ  db.userInfo.getShardVersion()
9���ۼ����������� db.userInfo.renameCollection("users"); ��userInfo������Ϊusers
10��ɾ����ǰ�ۼ����� db.userInfo.drop();


show dbs:��ʾ���ݿ��б� 
show collections����ʾ��ǰ���ݿ��еļ��ϣ����ƹ�ϵ���ݿ��еı� 
show users����ʾ�û� 
use <db name>���л���ǰ���ݿ⣬���MS-SQL�������˼һ�� 
db.help()����ʾ���ݿ������������кܶ������ 
db.foo.help()����ʾ���ϲ������ͬ���кܶ�����fooָ���ǵ�ǰ���ݿ��£�һ����foo�ļ��ϣ��������������ϵ����� 
db.foo.find()�����ڵ�ǰ���ݿ��е�foo���Ͻ������ݲ��ң�����û�����������г��������ݣ� 
db.foo.find( { a : 1 } )�����ڵ�ǰ���ݿ��е�foo���Ͻ��в��ң���������������һ�����Խ�a����a��ֵΪ1

---------------------------------------------------------------------------------------------------------
DB methods:
		db.adminCommand(nameOrDocument) - switches to 'admin' db, and runs command [ just calls db.runCommand(...) ]
        db.auth(username, password)
        db.cloneDatabase(fromhost)
        db.commandHelp(name) returns the help for the command
        db.copyDatabase(fromdb, todb, fromhost)
        db.createCollection(name, { size : ..., capped : ..., max : ... } )
        db.createView(name, viewOn, [ { $operator: {...}}, ... ], { viewOptions } )
        db.createUser(userDocument)
        db.currentOp() displays currently executing operations in the db
        db.dropDatabase()
        db.eval() - deprecated
        db.fsyncLock() flush data to disk and lock server for backups
        db.fsyncUnlock() unlocks server following a db.fsyncLock()
        db.getCollection(cname) same as db['cname'] or db.cname
        db.getCollectionInfos([filter]) - returns a list that contains the names and options of the db's collections
        db.getCollectionNames()
        db.getLastError() - just returns the err msg string
        db.getLastErrorObj() - return full status object
        db.getLogComponents()
        db.getMongo() get the server connection object
        db.getMongo().setSlaveOk() allow queries on a replication slave server
        db.getName()
        db.getPrevError()
        db.getProfilingLevel() - deprecated
        db.getProfilingStatus() - returns if profiling is on and slow threshold
        db.getReplicationInfo()
        db.getSiblingDB(name) get the db at the same server as this one
        db.getWriteConcern() - returns the write concern used for any operations on this db, inherited from server object if set
        db.hostInfo() get details about the server's host
        db.isMaster() check replica primary status
        db.killOp(opid) kills the current operation in the db
        db.listCommands() lists all the db commands
        db.loadServerScripts() loads all the scripts in db.system.js
        db.logout()
        db.printCollectionStats()
        db.printReplicationInfo()
        db.printShardingStatus()
        db.printSlaveReplicationInfo()
        db.dropUser(username)
        db.repairDatabase()
        db.resetError()
        db.runCommand(cmdObj) run a database command.  if cmdObj is a string, turns it into { cmdObj : 1 }
        db.serverStatus()
        db.setLogLevel(level,<component>)
        db.setProfilingLevel(level,<slowms>) 0=off 1=slow 2=all
        db.setWriteConcern( <write concern doc> ) - sets the write concern for writes to the db
        db.unsetWriteConcern( <write concern doc> ) - unsets the write concern for writes to the db
        db.setVerboseShell(flag) display extra information in shell output
        db.shutdownServer()
        db.stats()
        db.version() current version of the server

----------------------------------------------------------------------------------------
DBCollection help
        db.yourCol1.find().help() - show DBCursor help
        db.yourCol1.bulkWrite( operations, <optional params> ) - bulk execute write operations, optional parameters are: w, wtimeout, j
        db.yourCol1.count( query = {}, <optional params> ) - count the number of documents that matches the query, optional parameters are: limit, skip, hint, maxTimeMS
        db.yourCol1.copyTo(newColl) - duplicates collection by copying all documents to newColl; no indexes are copied.
        db.yourCol1.convertToCapped(maxBytes) - calls {convertToCapped:'yourCol1', size:maxBytes}} command
        db.yourCol1.createIndex(keypattern[,options])
        db.yourCol1.createIndexes([keypatterns], <options>)
        db.yourCol1.dataSize()
        db.yourCol1.deleteOne( filter, <optional params> ) - delete first matching document, optional parameters are: w, wtimeout, j
        db.yourCol1.deleteMany( filter, <optional params> ) - delete all matching documents, optional parameters are: w, wtimeout, j
        db.yourCol1.distinct( key, query, <optional params> ) - e.g. db.yourCol1.distinct( 'x' ), optional parameters are: maxTimeMS
        db.yourCol1.drop() drop the collection
        db.yourCol1.dropIndex(index) - e.g. db.yourCol1.dropIndex( "indexName" ) or db.yourCol1.dropIndex( { "indexKey" : 1 } )
        db.yourCol1.dropIndexes()
        db.yourCol1.ensureIndex(keypattern[,options]) - DEPRECATED, use createIndex() instead
        db.yourCol1.explain().help() - show explain help
        db.yourCol1.reIndex()
        db.yourCol1.find([query],[fields]) - query is an optional query filter. fields is optional set of fields to return.
                                                      e.g. db.yourCol1.find( {x:77} , {name:1, x:1} )
        db.yourCol1.find(...).count()
        db.yourCol1.find(...).limit(n)
        db.yourCol1.find(...).skip(n)
        db.yourCol1.find(...).sort(...)
        db.yourCol1.findOne([query], [fields], [options], [readConcern])
        db.yourCol1.findOneAndDelete( filter, <optional params> ) - delete first matching document, optional parameters are: projection, sort, maxTimeMS
        db.yourCol1.findOneAndReplace( filter, replacement, <optional params> ) - replace first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
        db.yourCol1.findOneAndUpdate( filter, update, <optional params> ) - update first matching document, optional parameters are: projection, sort, maxTimeMS, upsert, returnNewDocument
        db.yourCol1.getDB() get DB object associated with collection
        db.yourCol1.getPlanCache() get query plan cache associated with collection
        db.yourCol1.getIndexes()
        db.yourCol1.group( { key : ..., initial: ..., reduce : ...[, cond: ...] } )
        db.yourCol1.insert(obj)
        db.yourCol1.insertOne( obj, <optional params> ) - insert a document, optional parameters are: w, wtimeout, j
        db.yourCol1.insertMany( [objects], <optional params> ) - insert multiple documents, optional parameters are: w, wtimeout, j
        db.yourCol1.mapReduce( mapFunction , reduceFunction , <optional params> )
        db.yourCol1.aggregate( [pipeline], <optional params> ) - performs an aggregation on a collection; returns a cursor
        db.yourCol1.remove(query)
        db.yourCol1.replaceOne( filter, replacement, <optional params> ) - replace the first matching document, optional parameters are: upsert, w, wtimeout, j
        db.yourCol1.renameCollection( newName , <dropTarget> ) renames the collection.
        db.yourCol1.runCommand( name , <options> ) runs a db command with the given name where the first param is the collection name
        db.yourCol1.save(obj)
        db.yourCol1.stats({scale: N, indexDetails: true/false, indexDetailsKey: <index key>, indexDetailsName: <index name>})
        db.yourCol1.storageSize() - includes free space allocated to this collection
        db.yourCol1.totalIndexSize() - size in bytes of all the indexes
        db.yourCol1.totalSize() - storage allocated for all data and indexes
        db.yourCol1.update( query, object[, upsert_bool, multi_bool] ) - instead of two flags, you can pass an object with fields: upsert, multi
        db.yourCol1.updateOne( filter, update, <optional params> ) - update the first matching document, optional parameters are: upsert, w, wtimeout, j
        db.yourCol1.updateMany( filter, update, <optional params> ) - update all matching documents, optional parameters are: upsert, w, wtimeout, j
        db.yourCol1.validate( <full> ) - SLOW
        db.yourCol1.getShardVersion() - only for use with sharding
        db.yourCol1.getShardDistribution() - prints statistics about data distribution in the cluster
        db.yourCol1.getSplitKeysForChunks( <maxChunkSize> ) - calculates split points over all chunks and returns splitter function
        db.yourCol1.getWriteConcern() - returns the write concern used for any operations on this collection, inherited from server/db if set
        db.yourCol1.setWriteConcern( <write concern doc> ) - sets the write concern for writes to the collection
        db.yourCol1.unsetWriteConcern( <write concern doc> ) - unsets the write concern for writes to the collection
        db.yourCol1.latencyStats() - display operation latency histograms for this collection
        
---------------------------------------------------------------------------------------------

find(<predicate>, <projection>) modifiers
        .sort({...})
        .limit(<n>)
        .skip(<n>)
        .batchSize(<n>) - sets the number of docs to return per getMore
        .collation({...})
        .hint({...})
        .readConcern(<level>)
        .readPref(<mode>, <tagset>)
        .count(<applySkipLimit>) - total # of objects matching query. by default ignores skip,limit
        .size() - total # of objects cursor would return, honors skip,limit
        .explain(<verbosity>) - accepted verbosities are {'queryPlanner', 'executionStats', 'allPlansExecution'}
        .min({...})
        .max({...})
        .maxScan(<n>)
        .maxTimeMS(<n>)
        .comment(<comment>)
        .snapshot()
        .tailable(<isAwaitData>)
        .noCursorTimeout()
        .allowPartialResults()
        .returnKey()
        .showRecordId() - adds a $recordId field to each returned object

Cursor methods
        .toArray() - iterates through docs and returns an array of the results
        .forEach(<func>)
        .map(<func>)
        .hasNext()
        .next()
        .close()
        .objsLeftInBatch() - returns count of docs left in current batch (when exhausted, a new getMore will be issued)
        .itcount() - iterates through documents and counts them
        .getQueryPlan() - get query plans associated with shape. To get more info on query plans, call getQueryPlan().help().
        .pretty() - pretty print each document, possibly over multiple lines
        



       
 












