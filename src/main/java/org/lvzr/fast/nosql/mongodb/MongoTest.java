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
            //����Mongo���ݿ�����
            MongoClient client = new MongoClient("127.0.0.1",27017);
            //��ѯ���е����ݿ���
            List<String> databaseNames = client.getDatabaseNames();
            for(String name:databaseNames){
                System.out.println(name);
            }
            //���һ�����ݿ�����
            DB db = client.getDB("xxlong_db");
            //��ѯ�����ݿ����еļ�����
            Set<String> collectionNames = db.getCollectionNames();
            for(String name:collectionNames){
                System.out.println(name);
            }

            //����һ��teacher����
            //DBObject dbo = new BasicDBObject();
            //DBCollection  teacher_collection = db.createCollection("teacher3", dbo);
            DBCollection  teacher_collection = db.getCollection("teacher3");
            //��teacher�������������
            /*��һ�ַ�������ʹ��BasicDBObject
             * { "_id" : ObjectId("55dbc9c744ae76d6d3f31483"), "name" : "xxlong", "age" : 100, "student" : [ "stu1", "stu2" ],
��������������������"course": { "book" : "java" }}
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
            //��������
            List<DBObject> listdbo= new ArrayList<DBObject>();
            listdbo.add(db3);
            listdbo.add(db4);
            teacher_collection.insert(listdbo);
            
            /*�ڶ��ַ�����ʹ��BasicDBObjectBuilder����
            { "_id" : ObjectId("55dbee0544ae8180d0302af3"), "name" : "xxlong2", "age" : "101", "student" : [ "stu1", "stu2" ],
���������������� "course" : { "book" : "spring" } }
             */
            BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("name", "xxlong2").add("age", "101");
            List<String> list2 = new ArrayList<String>();
            list.add("stu1");
            list.add("stu2");
            documentBuilder.add("student", list2);
            BasicDBObjectBuilder documentBuilder2 = BasicDBObjectBuilder.start().add("book","spring");
            documentBuilder.add("course", documentBuilder2.get());
            teacher_collection.insert(documentBuilder.get());
            
            /*�����ַ�����ʹ��Map����
             { "_id" : ObjectId("55dbeebe44aeb01826bd4c93"), "student" : [ "stu1", "stu2" ], "name" : "xxlong3", "course" : 
��������������������{ "book" : "c++" }, "age" : 103 }
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
            
            /*�����ַ�����Ҳ������򵥵ģ���ֱ�Ӳ���JSON��ʽ����
             { "_id" : ObjectId("55dbf03844ae34d97f3864ee"), "name" : "xxlong4", "age" : 104, "student" : [ "stu1", "stu2" ],
���������������� "course" : { "book" : "c++" }}
             */
            String json =  "{ 'name' : 'xxlong4', 'age' : 104,'student' : [ 'stu1', 'stu2' ], 'course' : { 'book' :'c++' } }";
            DBObject dbObject =(DBObject)JSON.parse(json);
            teacher_collection.insert(dbObject);
            
            
            //ɾ����һ��document
            DBObject dbo_delfirst = teacher_collection.findOne();
            teacher_collection.remove(dbo_delfirst);
            
            //ɾ��ָ����document
            DBObject dbo_specify = new BasicDBObject();
            //ָ����_id
            dbo_specify.put("_id", new ObjectId("55dbf10444ae23aca6d08c57"));
            
            //ָ��name��age��Ҫ���ϲ���ɾ��
            dbo_specify.put("name", "xxlong4");
            dbo_specify.put("age",100);
            teacher_collection.remove(dbo_specify);
            
            //ָ��ֵ��������
            List<String> list4 = new ArrayList<String>();
            list.add("xxlong4");
            list.add("xxlong2");
            DBObject dbo_array = new BasicDBObject("$in",list4);
            DBObject dbo_in = new BasicDBObject();
            dbo_in.put("name", dbo_array);
            teacher_collection.remove(dbo_in);
            
            //ָ��scoreֵ�Ĵ�С��ΧΪ60-70֮��{score:{$get:60,$lte:70}}
            DBObject dbo_scoreRange = new BasicDBObject();
            dbo_scoreRange.put("$gte", 60);
            dbo_scoreRange.put("$lte", 70);
            DBObject dbo_range = new BasicDBObject("score",dbo_scoreRange);
            teacher_collection.remove(dbo_range);
            
            //ɾ�����е�ֵ
            DBCursor cur = teacher_collection.find();
            while(cur.hasNext()){
                teacher_collection.remove(cur.next());
            }
            
            //����document
            DBObject dbo_new = new BasicDBObject();
            dbo_new.put("name", "xxlong2");
            dbo_new.put("age",105 );
            dbo_new.put("score", 100);
            teacher_collection.update(new BasicDBObject().append("name", "xxlong"), dbo_new);
            
            //ʹ��$incʹscoreֵ����10,$setҲһ��
            DBObject dbo_newinc = new BasicDBObject();
            dbo_newinc.put("$inc", new BasicDBObject().append("score", 10));
            teacher_collection.update(new BasicDBObject().append("name", "xxlong2"), dbo_newinc);
            
            
            //Ϊ�������ӻ��������score
            DBObject db5 = new BasicDBObject();
            db5.put("$set",new BasicDBObject("score",100) );
            teacher_collection.update(new BasicDBObject(), db5, true, true);
            
            
            //��ѯteacher�����еĵ�һ��document
            DBObject dbo_first = teacher_collection.findOne();
            
            //��ѯteacher�����е�ȫ��document
            DBCursor cur2 = teacher_collection.find();
            while(cur2.hasNext()){
                DBObject obj = cur2.next();
                System.out.println(obj.get("name"));
            }
            
            //���teacher������scoreΪ100��document
            DBObject dbo_find = new BasicDBObject().append("score", 100);
            DBCursor cur_find = teacher_collection.find(dbo_find);
            while(cur_find.hasNext()){
                System.out.println(cur_find.next());
            }
            System.out.println(cur_find.count());        
            //תΪjson�ַ���
            System.out.println(JSON.serialize(cur_find));
            
            
            //����ͼƬ,��xxlong_db��������bucket.chunks��bucket.files
            GridFS gfs_bucket = new GridFS(db,"bucket");
            GridFSInputFile gfsFile1 = gfs_bucket.createFile( new File("/home/xxlong/p23422660.jpg"));
            GridFSInputFile gfsFile2 = gfs_bucket.createFile( new File("/home/xxlong/110.png"));
            gfsFile1.setFilename("p23422660.jpg");
            gfsFile2.setFilename("110.png");
            gfsFile1.save();
            gfsFile2.save();
            
            //��ȡͼƬ��Ϣ������
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
            
            //����ͼƬ
            imageForOutput.writeTo("/home/xxlong/myInstall/new.jpg");
            
            //��������ͼƬ
            List<GridFSDBFile> imgageForOutput_list=gfs_bucket.find(new BasicDBObject()) ;
            for(GridFSDBFile imageForOutput1:imgageForOutput_list){
                imageForOutput1.writeTo("/home/xxlong/myInstall/"+imageForOutput1.getFilename());
            }                
            
            //��ȡ����ͼƬ��Ϣ��������б�����bucket�����ռ��µ�ͼƬ��Ϣ
            DBCursor cur_bucket = gfs_bucket.getFileList();
            while(cur_bucket.hasNext()){
                DBObject dbo = cur_bucket.next();
                System.out.println(dbo);
            }
            
            //ɾ��ͼƬ
            gfs_bucket.remove("p23422660.jpg");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}    

