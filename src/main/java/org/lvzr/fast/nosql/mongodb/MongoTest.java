package org.lvzr.fast.nosql.mongodb;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.mongodb.util.JSON;

public class MongoTest {
    public static void main(String[] args) {
        try {
            //创建Mongo数据库连接
            MongoClient client = new MongoClient("127.0.0.1",27017);
            //查询所有的数据库名
            List<String> databaseNames = client.getDatabaseNames();
            for(String name:databaseNames){
                System.out.println(name);
            }
            //获得一个数据库连接
            DB db = client.getDB("xxlong_db");
            //查询该数据库所有的集合名
            Set<String> collectionNames = db.getCollectionNames();
            for(String name:collectionNames){
                System.out.println(name);
            }

            //创建一个teacher集合
            //DBObject dbo = new BasicDBObject();
            //DBCollection  teacher_collection = db.createCollection("teacher3", dbo);
            DBCollection  teacher_collection = db.getCollection("teacher3");
            //向teacher集合中添加数据
            /*第一种方法，是使用BasicDBObject
             * { "_id" : ObjectId("55dbc9c744ae76d6d3f31483"), "name" : "xxlong", "age" : 100, "student" : [ "stu1", "stu2" ],
　　　　　　　　　　"course": { "book" : "java" }}
               { "_id" : ObjectId("55dbc9c744ae76d6d3f31484")}
               { "_id" : ObjectId("55dbc9c744ae76d6d3f31485") }*/
            DBObject dbo1 = new BasicDBObject();
            dbo1.put("name", "xxlong");
            dbo1.put("age", 100);
            List<String> list = new ArrayList<String>();
            list.add("stu1");
            list.add("stu2");
            dbo1.put("student",list);
            DBObject dbo2 = new BasicDBObject();
            dbo2.put("book", "java");
            dbo1.put("course",dbo2);
            teacher_collection.insert(dbo1);
            DBObject db3 = new BasicDBObject();
            DBObject db4 = new BasicDBObject();
            //批量插入
            List<DBObject> listdbo= new ArrayList<DBObject>();
            listdbo.add(db3);
            listdbo.add(db4);
            teacher_collection.insert(listdbo);
            
            /*第二种方法是使用BasicDBObjectBuilder对象
            { "_id" : ObjectId("55dbee0544ae8180d0302af3"), "name" : "xxlong2", "age" : "101", "student" : [ "stu1", "stu2" ],
　　　　　　　　 "course" : { "book" : "spring" } }
             */
            BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("name", "xxlong2").add("age", "101");
            List<String> list2 = new ArrayList<String>();
            list.add("stu1");
            list.add("stu2");
            documentBuilder.add("student", list2);
            BasicDBObjectBuilder documentBuilder2 = BasicDBObjectBuilder.start().add("book","spring");
            documentBuilder.add("course", documentBuilder2.get());
            teacher_collection.insert(documentBuilder.get());
            
            /*第三种方法是使用Map对象
             { "_id" : ObjectId("55dbeebe44aeb01826bd4c93"), "student" : [ "stu1", "stu2" ], "name" : "xxlong3", "course" : 
　　　　　　　　　　{ "book" : "c++" }, "age" : 103 }
             */
            Map<String, Object>  map1 =new HashMap<String, Object>();
            map1.put("name", "xxlong3");
            map1.put("age", 103);
            List<String> list3 = new ArrayList<String>();
            list.add("stu1");
            list.add("stu2");
            map1.put("student", list3);
            Map<String, String> map2 =new HashMap<String, String>();
            map2.put("book", "c++");
            map1.put("course", map2);
            teacher_collection.insert(new BasicDBObject(map1));
            
            /*第四种方法，也就是最简单的，即直接插入JSON格式数据
             { "_id" : ObjectId("55dbf03844ae34d97f3864ee"), "name" : "xxlong4", "age" : 104, "student" : [ "stu1", "stu2" ],
　　　　　　　　 "course" : { "book" : "c++" }}
             */
            String json =  "{ 'name' : 'xxlong4', 'age' : 104,'student' : [ 'stu1', 'stu2' ], 'course' : { 'book' :'c++' } }";
            DBObject dbObject =(DBObject)JSON.parse(json);
            teacher_collection.insert(dbObject);
            
            
            //删除第一个document
            DBObject dbo_delfirst = teacher_collection.findOne();
            teacher_collection.remove(dbo_delfirst);
            
            //删除指定的document
            DBObject dbo_specify = new BasicDBObject();
            //指定的_id
            dbo_specify.put("_id", new ObjectId("55dbf10444ae23aca6d08c57"));
            
            //指定name和age都要符合才能删除
            dbo_specify.put("name", "xxlong4");
            dbo_specify.put("age",100);
            teacher_collection.remove(dbo_specify);
            
            //指定值在数组中
            List<String> list4 = new ArrayList<String>();
            list.add("xxlong4");
            list.add("xxlong2");
            DBObject dbo_array = new BasicDBObject("$in",list4);
            DBObject dbo_in = new BasicDBObject();
            dbo_in.put("name", dbo_array);
            teacher_collection.remove(dbo_in);
            
            //指定score值的大小范围为60-70之间{score:{$get:60,$lte:70}}
            DBObject dbo_scoreRange = new BasicDBObject();
            dbo_scoreRange.put("$gte", 60);
            dbo_scoreRange.put("$lte", 70);
            DBObject dbo_range = new BasicDBObject("score",dbo_scoreRange);
            teacher_collection.remove(dbo_range);
            
            //删除所有的值
            DBCursor cur = teacher_collection.find();
            while(cur.hasNext()){
                teacher_collection.remove(cur.next());
            }
            
            //更新document
            DBObject dbo_new = new BasicDBObject();
            dbo_new.put("name", "xxlong2");
            dbo_new.put("age",105 );
            dbo_new.put("score", 100);
            teacher_collection.update(new BasicDBObject().append("name", "xxlong"), dbo_new);
            
            //使用$inc使score值增加10,$set也一样
            DBObject dbo_newinc = new BasicDBObject();
            dbo_newinc.put("$inc", new BasicDBObject().append("score", 10));
            teacher_collection.update(new BasicDBObject().append("name", "xxlong2"), dbo_newinc);
            
            
            //为集合增加或更新属性score
            DBObject db5 = new BasicDBObject();
            db5.put("$set",new BasicDBObject("score",100) );
            teacher_collection.update(new BasicDBObject(), db5, true, true);
            
            
            //查询teacher集合中的第一个document
            DBObject dbo_first = teacher_collection.findOne();
            
            //查询teacher集合中的全部document
            DBCursor cur2 = teacher_collection.find();
            while(cur2.hasNext()){
                DBObject obj = cur2.next();
                System.out.println(obj.get("name"));
            }
            
            //获得teacher集合中score为100的document
            DBObject dbo_find = new BasicDBObject().append("score", 100);
            DBCursor cur_find = teacher_collection.find(dbo_find);
            while(cur_find.hasNext()){
                System.out.println(cur_find.next());
            }
            System.out.println(cur_find.count());        
            //转为json字符串
            System.out.println(JSON.serialize(cur_find));
            
            
            //保存图片,在xxlong_db下生成了bucket.chunks和bucket.files
            GridFS gfs_bucket = new GridFS(db,"bucket");
            GridFSInputFile gfsFile1 = gfs_bucket.createFile( new File("/home/xxlong/p23422660.jpg"));
            GridFSInputFile gfsFile2 = gfs_bucket.createFile( new File("/home/xxlong/110.png"));
            gfsFile1.setFilename("p23422660.jpg");
            gfsFile2.setFilename("110.png");
            gfsFile1.save();
            gfsFile2.save();
            
            //读取图片信息并保存
            /*{ 
             * "filename" : "xxlong_photo" , 
             * "aliases" :  null  , 
             * "chunkSize" : 261120 ,
             *  "uploadDate" : { "$date" : "2015-08-25T05:50:41.881Z"} , 
             * "length" : 183271 , 
             * "_id" : { "$oid" : "55dc023144ae5da46fb72505"},
             *   "contentType" :  null  , 
             *   "md5" : "1dde2037829359f4e1a6706e9cd4c265"}*/
            GridFSDBFile imageForOutput = gfs_bucket.findOne("p23422660.jpg");
            System.out.println(imageForOutput);
            
            //保存图片
            imageForOutput.writeTo("/home/xxlong/myInstall/new.jpg");
            
            //保存所有图片
            List<GridFSDBFile> imgageForOutput_list=gfs_bucket.find(new BasicDBObject()) ;
            for(GridFSDBFile imageForOutput1:imgageForOutput_list){
                imageForOutput1.writeTo("/home/xxlong/myInstall/"+imageForOutput1.getFilename());
            }                
            
            //读取所有图片信息，输出所有保存在bucket命名空间下的图片信息
            DBCursor cur_bucket = gfs_bucket.getFileList();
            while(cur_bucket.hasNext()){
                DBObject dbo = cur_bucket.next();
                System.out.println(dbo);
            }
            
            //删除图片
            gfs_bucket.remove("p23422660.jpg");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}    

