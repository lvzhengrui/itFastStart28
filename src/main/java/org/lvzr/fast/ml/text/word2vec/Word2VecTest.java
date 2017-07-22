package org.lvzr.fast.ml.text.word2vec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import com.alibaba.fastjson.JSONObject;
 
import org.lvzr.fast.ml.text.word2vec.Learn;
import org.lvzr.fast.ml.text.word2vec.Word2VEC;

import org.lvzr.fast.ml.text.word2vec.love.IOUtil;
import org.lvzr.fast.ml.text.word2vec.love.StringUtil;

public class Word2VecTest {
	
    private static final File sportCorpusFile = new File("corpus/result.txt");

    public static void main(String[] args) throws IOException {
        File[] files = new File("corpus/sport/").listFiles();
        
        //构建语料
        try (FileOutputStream fos = new FileOutputStream(sportCorpusFile)) {
            for (File file : files) {
                if (file.canRead() && file.getName().endsWith(".txt")) {
                    parserFile(fos, file);
                }
            }
        }
        
        //进行分词训练
        Learn lean = new Learn() ;
        lean.learnFile(sportCorpusFile) ;
        lean.saveModel(new File("model/vector.mod")) ;
         
        //加载测试
        Word2VEC w2v = new Word2VEC() ;
        w2v.loadJavaModel("model/vector.mod") ;
        //loadGoogleModel(String path)
        System.out.println(w2v.distance("姚明")); ;

    }
 
    private static void parserFile(FileOutputStream fos, File file) 
    		throws FileNotFoundException, IOException {
        //TODO Auto-generated method stub
        try (BufferedReader br = IOUtil.getReader(file.getAbsolutePath(), IOUtil.UTF8)) {
            String temp = null;
            JSONObject parse = null;
            while ((temp = br.readLine()) != null) {
                parse = JSONObject.parseObject(temp);
                paserStr(fos, parse.getString("title"));
                paserStr(fos, StringUtil.rmHtmlTag(parse.getString("content")));
            }
        }
    }

    private static void paserStr(FileOutputStream fos, String title) throws IOException {
    	//TODO 
        List<Term> parse2 = null;//ToAnalysis.parse(title);
        StringBuilder sb = new StringBuilder() ;
        for (Term term : parse2) {
            sb.append(term.getName()) ;
            sb.append(" ");
        }
        fos.write(sb.toString().getBytes()) ;
        fos.write("\n".getBytes()) ;
    }
}

