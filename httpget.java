package com.cd.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class httpget {
    private 	CopyOnWriteArrayList<String>list=new CopyOnWriteArrayList();
     private	CopyOnWriteArrayList<String>list2=new CopyOnWriteArrayList();
	 private String  url;
     private  Executor er;
	public httpget( String  url,Executor er){
		this.url=url;
		this.er=er;
	}
	
	
	public void run(String  txt,int index){
		 new Thread(()->{
			String  res  =resltu();
			  if(res==null)
				  return;
			  String [] sp   =res.split(txt);
			  List<String > li=Arrays.asList(sp);
			  sp=null;
			  //	System.out.println(res);

			  for(String str:li){
				  	//System.out.println("----------www3--------------");

				   String  [] s =	str.split("/");
				  
			    	if( s.length>2)
			    	  	if(s[2].contains("cn")||s[2].contains("com")||s[2].contains("net")){
				    		System.out.println("------------1-------------");
						  	System.out.println(s[2]);
						  	System.out.println("-----------2--------------");
						  	if(!s[2].equals(index==1?url.replace("http://", ""):url.replace("https://", ""))){
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
		  	    
		  		//    	System.out.println(str.split("\"")[0]+"=======2344===============");

		  	    	}else if(str.contains("\\")){
		  	    		list2.add( str.replace("\\", ""));
		  		    //	System.out.println( str.replace("\\", "")+"=======2344===============");
		  	    	}else{
		  	    		list2.add(str);
		  	    	}
		  		}
		  		 
			  

				  size=list2.size();
			    //	System.out.println("=============22=========");
			    	list.clear();
			    	for(int i=0;i<size;i++){
					String str=list2.get(i);
					String  resd=(String) testmain.mcc.get(str);
					if(resd==null){
					Future<String> f=	((ExecutorService) er).submit(new stringCall(str));
				try {
					String b	=f.get();
				/*	if(!b.contains("403")&&!b.contains("500")&&!b.contains("404")
							&&!b.contains("501")&&!b.contains("502")&&!b.contains("503")&&!b.contains("504"))*/
			    	if(b!=null){
			    		testmain.mcc.add(str, 1000*1000*100, b);
			  		  	System.out.println( str+"==11===="+b);
					  	  new   httpget("http://"+str, er).run(txt, index);;

			    	}

			    	
			    	
			    	
			    	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    	System.out.println(str);
			    	
				}else{
			    	System.out.println(str+"========================222222222");

				}
					
			    	}
		  }).start();;
		
		
		
	}
	
	
	public  String resltu(){
		OkHttpClient mHttpClient =testmain.https();
		 Request build = new Request.Builder()
		            .url(url)
		            .build();
		    Response response;
		    try {
				response = mHttpClient.newCall(build) .execute();
				String  txt=response.body().string();
				return  txt;
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    return null;
	}
	
	
}
