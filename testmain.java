package com.cd.http;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import net.spy.memcached.MemcachedClient;

import java.net.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class testmain {
	public static ExecutorService exs=Executors.newFixedThreadPool(10);
	public static 	MemcachedClient mcc =null;
	public static void main(String[] args) {
		
	    try {
        	mcc= new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	  new   httpget("http://120.78.136.218", exs).run("http", 1);;
	  
	    
	    
		
	/*	CopyOnWriteArrayList<String>list=new CopyOnWriteArrayList();
		CopyOnWriteArrayList<String>list2=new CopyOnWriteArrayList();
		OkHttpClient mHttpClient = https();
        try {
        	mcc= new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	new 	Thread(()->{
	String	http="https://www.hao123.com";
	String hs="www.hao123.com";
		 Request build = new Request.Builder()
		            .url(http)
		            .build();
		    Response response;
			try {
				response = mHttpClient.newCall(build)
				        .execute();
				String  txt=response.body().string();
			 ///   System.out.println(txt);
			    System.out.println();
			    System.out.println();
			    System.out.println();
			   String [] sp   =txt.split("https");
			    List<String > li=Arrays.asList(sp);
			    for(String str:li){
			    	System.out.println(str);
			    	System.out.println();
			    	System.out.println();
			   String  [] s =	str.split("/");
	
			    //	System.out.println("-------------------------");
			    	if( s.length>2)
			    	if(s[2].contains("cn")||s[2].contains("com")){
			    		System.out.println("------------1-------------");
					  	System.out.println(s[2]);
					  	System.out.println("-----------2--------------");
					  	if(!s[2].equals(hs)){
					       if(list.size()==0)
					  		list.add(s[2]);
					       else{
					    	   if(!list.contains(s[2])){
								  	System.out.println("-----------3--------------");
					    			   list.add(s[2]);
					    	   }
					    	   
					       }
					       
					  	}
					  	
			    	}
			   
			    }
	

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("======================");
       int  size=list.size();
		for(int i=0;i<size;i++){
			String str=list.get(i);
	    	System.out.println(str);
	    	if(str.contains("\"")){
	    		String sd= str.split("\"")[0];
	    	    		if(sd.contains("&")){
	    			list2.add( sd.split("&")[0]);
	    		}else{
	    			list2.add( sd);

	    		}
	    
		    	System.out.println(str.split("\"")[0]+"=======2344===============");

	    	}else if(str.contains("\\")){
	    		list2.add( str.replace("\\", ""));
		    	System.out.println( str.replace("\\", "")+"=======2344===============");
	    	}else{
	    		list2.add(str);
	    	}
		}
		
		  size=list2.size();
	    	System.out.println("=============22=========");
	    	list.clear();
	    	for(int i=0;i<size;i++){
			String str=list2.get(i);
			Future<String> f=	exs.submit(new stringCall(str));
		try {
			String b	=f.get();
			if(!b.contains("403")&&!b.contains("500")&&!b.contains("404")
					&&!b.contains("501")&&!b.contains("502")&&!b.contains("503")&&!b.contains("504"))
	    	if(b!=null)
			mcc.add(str, 1000*1000*100, b);
	    	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	System.out.println(str);
		}
	         mcc.shutdown();
	
	}).start();*/
		
		
		
		
		
		
	}
	public static OkHttpClient https(){
	return	new OkHttpClient().newBuilder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
     
        .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())//配置
        .hostnameVerifier(SSLSocketClient.getHostnameVerifier())//配置
        .build();
	}
}
