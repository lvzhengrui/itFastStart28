

###Java对mongodb进行正则查询
https://zhidao.baidu.com/question/1575753989910107820.html


###MongoDB在系统中的使用
http://www.cnblogs.com/bfchuan/p/4090249.html


###常用命令
http://www.jb51.net/article/48217.htm


###启动命令
mongod.exe --dbpath=E:\开源项目\nosql\mongo\db 
pause


###进入命令行
mongo

###基本命令
切换到或创建test数据库
use test

得到当前db的所有聚集集合
db.getCollectionNames();

显示所有数据库
show dbs

Help查看命令提示
help
db.help();
db.yourColl.help();
db.youColl.find().help();
rs.help();


删除当前使用数据库
db.dropDatabase();

从指定主机上克隆数据库
db.cloneDatabase(“127.0.0.1”); 将指定机器上的数据库的数据克隆到当前数据库

db.copyDatabase("mydb", "temp", "127.0.0.1");将本机的mydb的数据复制到temp数据库中

db.repairDatabase();

db.getName();
db; db和getName方法是一样的效果，都可以查询当前使用的数据库


创建一个聚集集合（table）
db.createCollection(“collName”, {size: 20, capped: 5, max: 100});//创建成功会显示{“ok”:1}
//判断集合是否为定容量db.collName.isCapped();

查询userInfo集合的age = 22的记录
db.userInfo.find({"age": 22});

列出集合所有记录
db.userInfo.find({});


-------------------------------------------------------------------------------------------------------
###命令行方式mongofiles
http://www.linuxidc.com/Linux/2013-06/85779.htm
http://www.tuicool.com/articles/7BnQJz

mongofiles命令行下向Mongodb数据库中插入文件数据。

mongofiles  -host 127.0.0.1:27017 -d  mydb  put  文件名

向数据库mydb中插入一个文件，其中put为命令，表示向Mongodb中上传文件，get、delete分别表示取得文件和删除文件。

执行 db.fs.files.find()即可看到GridFS中的文件列表.

mongo自带有一个实现mongofliles，基本操作如下：

列出所有文件：
mongofiles list

上传一个文件：
mongofiles put xxx.txt

下载一个文件：
mongofiles get xxx.txt

查找文件：
mongofiles search xxx //会查找所有文件名中包含“xxx”的文件
mongofiles list xxx //会查找所有文件名以“xxx”为前缀的文件
参数说明：
–d 指定数据库 ，默认是fs，Mongofiles list –d testGridfs
-u –p 指定用户名，密码
-h 指定主机
-port 指定主机端口
-c 指定集合名，默认是fs
-t 指定文件的MIME类型，默认会忽略



-------------------------------------------------------------------------------------------------------
如：如果你想创建一个“myTest”的数据库，先运行use myTest命令，之后就做一些操作（如：db.createCollection('user')）,
这样就可以创建一个名叫“myTest”的数据库。


###一、数据库常用命令
1、Help查看命令提示


复制代码 代码如下:

help
db.help();
db.yourColl.help();
db.youColl.find().help();
rs.help();

2、切换/创建数据库

复制代码 代码如下:

use yourDB; 当创建一个集合(table)的时候会自动创建当前数据库

3、查询所有数据库

复制代码 代码如下:

show dbs;

4、删除当前使用数据库

复制代码 代码如下:

db.dropDatabase();

5、从指定主机上克隆数据库

复制代码 代码如下:

db.cloneDatabase(“127.0.0.1”); 将指定机器上的数据库的数据克隆到当前数据库

6、从指定的机器上复制指定数据库数据到某个数据库

复制代码 代码如下:

db.copyDatabase("mydb", "temp", "127.0.0.1");将本机的mydb的数据复制到temp数据库中

7、修复当前数据库

复制代码 代码如下:

db.repairDatabase();

8、查看当前使用的数据库

复制代码 代码如下:

db.getName();
db; db和getName方法是一样的效果，都可以查询当前使用的数据库

9、显示当前db状态

复制代码 代码如下:

db.stats();

10、当前db版本

复制代码 代码如下:

db.version();

11、查看当前db的链接机器地址

复制代码 代码如下:

db.getMongo();



###二、Collection聚集集合
1、创建一个聚集集合（table）


复制代码 代码如下:

db.createCollection(“collName”, {size: 20, capped: 5, max: 100});//创建成功会显示{“ok”:1}
//判断集合是否为定容量db.collName.isCapped();

2、得到指定名称的聚集集合（table）

复制代码 代码如下:

db.getCollection("account");

3、得到当前db的所有聚集集合

复制代码 代码如下:

db.getCollectionNames();

4、显示当前db所有聚集索引的状态

复制代码 代码如下:

db.printCollectionStats();



###三、用户相关 
1、添加一个用户

复制代码 代码如下:

db.addUser("name");
db.addUser("userName", "pwd123", true); 添加用户、设置密码、是否只读

2、数据库认证、安全模式

复制代码 代码如下:

db.auth("userName", "123123");

3、显示当前所有用户

复制代码 代码如下:

show users;

4、删除用户

复制代码 代码如下:

db.removeUser("userName");



###四、聚集集合查询 
1、查询所有记录

复制代码 代码如下:

db.userInfo.find();
相当于：select* from userInfo;

默认每页显示20条记录，当显示不下的情况下，可以用it迭代命令查询下一页数据。注意：键入it命令不能带“；”
但是你可以设置每页显示数据的大小，用DBQuery.shellBatchSize= 50;这样每页就显示50条记录了。
2、查询去掉后的当前聚集集合中的某列的重复数据

复制代码 代码如下:

db.userInfo.distinct("name");
会过滤掉name中的相同数据
相当于：select distict name from userInfo;

3、查询age = 22的记录

复制代码 代码如下:

db.userInfo.find({"age": 22});
相当于： select * from userInfo where age = 22;

4、查询age > 22的记录

复制代码 代码如下:

db.userInfo.find({age: {$gt: 22}});
相当于：select * from userInfo where age >22;

5、查询age < 22的记录

复制代码 代码如下:

db.userInfo.find({age: {$lt: 22}});
相当于：select * from userInfo where age <22;

6、查询age >= 25的记录

复制代码 代码如下:

db.userInfo.find({age: {$gte: 25}});
相当于：select * from userInfo where age >= 25;

7、查询age <= 25的记录

复制代码 代码如下:

db.userInfo.find({age: {$lte: 25}});

8、查询age >= 23 并且 age <= 26

复制代码 代码如下:

db.userInfo.find({age: {$gte: 23, $lte: 26}});

9、查询name中包含 mongo的数据

复制代码 代码如下:

db.userInfo.find({name: /mongo/});
//相当于%%
[code]select * from userInfo where name like ‘%mongo%';

10、查询name中以mongo开头的

复制代码 代码如下:

db.userInfo.find({name: /^mongo/});
select * from userInfo where name like ‘mongo%';

11、查询指定列name、age数据

复制代码 代码如下:

db.userInfo.find({}, {name: 1, age: 1});
相当于：select name, age from userInfo;

当然name也可以用true或false,当用ture的情况下河name:1效果一样，如果用false就是排除name，显示name以外的列信息。
12、查询指定列name、age数据, age > 25

复制代码 代码如下:

db.userInfo.find({age: {$gt: 25}}, {name: 1, age: 1});
相当于：select name, age from userInfo where age >25;

13、按照年龄排序

复制代码 代码如下:

升序：db.userInfo.find().sort({age: 1});
降序：db.userInfo.find().sort({age: -1});

14、查询name = zhangsan, age = 22的数据

复制代码 代码如下:

db.userInfo.find({name: 'zhangsan', age: 22});
相当于：select * from userInfo where name = ‘zhangsan' and age = ‘22';

15、查询前5条数据

复制代码 代码如下:

db.userInfo.find().limit(5);
相当于：selecttop 5 * from userInfo;

16、查询10条以后的数据

复制代码 代码如下:

db.userInfo.find().skip(10);
相当于：select * from userInfo where id not in (
selecttop 10 * from userInfo
);

17、查询在5-10之间的数据

复制代码 代码如下:

db.userInfo.find().limit(10).skip(5);

可用于分页，limit是pageSize，skip是第几页*pageSize
18、or与 查询

复制代码 代码如下:

db.userInfo.find({$or: [{age: 22}, {age: 25}]});
相当于：select * from userInfo where age = 22 or age = 25;

19、查询第一条数据

复制代码 代码如下:

db.userInfo.findOne();
相当于：selecttop 1 * from userInfo;
db.userInfo.find().limit(1);

20、查询某个结果集的记录条数

复制代码 代码如下:

db.userInfo.find({age: {$gte: 25}}).count();
相当于：select count(*) from userInfo where age >= 20;

21、按照某列进行排序

复制代码 代码如下:

db.userInfo.find({sex: {$exists: true}}).count();
相当于：select count(sex) from userInfo;



###五、索引
1、创建索引

复制代码 代码如下:

db.userInfo.ensureIndex({name: 1});
db.userInfo.ensureIndex({name: 1, ts: -1});

2、查询当前聚集集合所有索引

复制代码 代码如下:

db.userInfo.getIndexes();

3、查看总索引记录大小

复制代码 代码如下:

db.userInfo.totalIndexSize();

4、读取当前集合的所有index信息

复制代码 代码如下:

db.users.reIndex();

5、删除指定索引

复制代码 代码如下:

db.users.dropIndex("name_1");

6、删除所有索引索引

复制代码 代码如下:

db.users.dropIndexes();



###六、修改、添加、删除集合数据
1、添加

复制代码 代码如下:

db.users.save({name: ‘zhangsan', age: 25, sex: true});

添加的数据的数据列，没有固定，根据添加的数据为准
2、修改

复制代码 代码如下:

db.users.update({age: 25}, {$set: {name: 'changeName'}}, false, true);
相当于：update users set name = ‘changeName' where age = 25;
db.users.update({name: 'Lisi'}, {$inc: {age: 50}}, false, true);
相当于：update users set age = age + 50 where name = ‘Lisi';
db.users.update({name: 'Lisi'}, {$inc: {age: 50}, $set: {name: 'hoho'}}, false, true);
相当于：update users set age = age + 50, name = ‘hoho' where name = ‘Lisi';

3、删除

复制代码 代码如下:

db.users.remove({age: 132});

4、查询修改删除

复制代码 代码如下:

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

update 或 remove 其中一个是必须的参数; 其他参数可选。
参数    详解     默认值 
query    查询过滤条件    {} 
sort    如果多个文档符合查询过滤条件，将以该参数指定的排列方式选择出排在首位的对象，该对象将被操作    {} 
remove    若为true，被选中对象将在返回前被删除    N/A 
update    一个 修改器对象
N/A 
new    若为true，将返回修改后的对象而不是原始对象。在删除操作中，该参数被忽略。    false 
fields    参见Retrieving a Subset of Fields (1.5.0+) 
All fields 
upsert    创建新对象若查询结果为空。 示例 (1.5.4+) 
false 


###七、语句块操作 
1、简单Hello World

复制代码 代码如下:

print("Hello World!");

这种写法调用了print函数，和直接写入"Hello World!"的效果是一样的；
2、将一个对象转换成json

复制代码 代码如下:

tojson(new Object());
tojson(new Object('a'));

3、循环添加数据

复制代码 代码如下:

> for (var i = 0; i < 30; i++) {
... db.users.save({name: "u_" + i, age: 22 + i, sex: i % 2});
... };

这样就循环添加了30条数据，同样也可以省略括号的写法

复制代码 代码如下:

> for (var i = 0; i < 30; i++) db.users.save({name: "u_" + i, age: 22 + i, sex: i % 2});

也是可以的，当你用db.users.find()查询的时候，显示多条数据而无法一页显示的情况下，可以用it查看下一页的信息；
4、find 游标查询

复制代码 代码如下:

>var cursor = db.users.find();
> while (cursor.hasNext()) { 
    printjson(cursor.next()); 
}

这样就查询所有的users信息，同样可以这样写

复制代码 代码如下:

var cursor = db.users.find();
while (cursor.hasNext()) { printjson(cursor.next); }

同样可以省略{}号
5、forEach迭代循环

复制代码 代码如下:

db.users.find().forEach(printjson);

forEach中必须传递一个函数来处理每条迭代的数据信息
6、将find游标当数组处理

复制代码 代码如下:

var cursor = db.users.find();
cursor[4];

取得下标索引为4的那条数据
既然可以当做数组处理，那么就可以获得它的长度：cursor.length();或者cursor.count();
那样我们也可以用循环显示数据

复制代码 代码如下:

for (var i = 0, len = c.length(); i < len; i++) printjson(c[i]);

7、将find游标转换成数组

复制代码 代码如下:

> var arr = db.users.find().toArray();
> printjson(arr[2]);

用toArray方法将其转换为数组
8、定制我们自己的查询结果
只显示age <= 28的并且只显示age这列数据

复制代码 代码如下:

db.users.find({age: {$lte: 28}}, {age: 1}).forEach(printjson);
db.users.find({age: {$lte: 28}}, {age: true}).forEach(printjson);

排除age的列

复制代码 代码如下:

db.users.find({age: {$lte: 28}}, {age: false}).forEach(printjson);

9、forEach传递函数显示信息

复制代码 代码如下:

db.things.find({x:4}).forEach(function(x) {print(tojson(x));});


###八、其他 
1、查询之前的错误信息


复制代码 代码如下:

db.getPrevError();

2、清除错误记录

复制代码 代码如下:

db.resetError();

查看聚集集合基本信息
1、查看帮助  db.yourColl.help();
2、查询当前集合的数据条数  db.yourColl.count();
3、查看数据空间大小 db.userInfo.dataSize();
4、得到当前聚集集合所在的db db.userInfo.getDB();
5、得到当前聚集的状态 db.userInfo.stats();
6、得到聚集集合总大小 db.userInfo.totalSize();
7、聚集集合储存空间大小 db.userInfo.storageSize();
8、Shard版本信息  db.userInfo.getShardVersion()
9、聚集集合重命名 db.userInfo.renameCollection("users"); 将userInfo重命名为users
10、删除当前聚集集合 db.userInfo.drop();


show dbs:显示数据库列表 
show collections：显示当前数据库中的集合（类似关系数据库中的表） 
show users：显示用户 
use <db name>：切换当前数据库，这和MS-SQL里面的意思一样 
db.help()：显示数据库操作命令，里面有很多的命令 
db.foo.help()：显示集合操作命令，同样有很多的命令，foo指的是当前数据库下，一个叫foo的集合，并非真正意义上的命令 
db.foo.find()：对于当前数据库中的foo集合进行数据查找（由于没有条件，会列出所有数据） 
db.foo.find( { a : 1 } )：对于当前数据库中的foo集合进行查找，条件是数据中有一个属性叫a，且a的值为1

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
        



       
 












