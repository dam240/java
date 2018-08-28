package com.cd.http;

import java.util.concurrent.Callable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class stringCall implements Callable<String>{

	private String  url;     
	
	public stringCall(String url){
		this.url=url;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		
		//System.out.println(url+"----");

		OkHttpClient ok	=testmain.https();
		try{
		 Request build = new Request.Builder()
		            .url("http://"+url)
		            .build();
		 Response	 response = ok.newCall(build)
			        .execute();
			String  txt=response.body().string();
			if(txt.contains("<title>")){
			int be		=txt.lastIndexOf("<title>");
			int end=	txt.indexOf("</title>");

			String 	title =txt.subSequence(be, end).toString();
			System.out.println(title);
			return title.replace("<title>", "");
			}
		//	System.out.println(txt);
		}
		catch (Exception e) {
			// TODO: handle exception
			
			 Request build = new Request.Builder()
			            .url("https://"+url)
			            .build();
			 Response	 response = ok.newCall(build)
				        .execute();
				String  txt=response.body().toString();
				if(txt.contains("<title>")){

				int be		=txt.lastIndexOf("<title>");
				int end=	txt.indexOf("</title>");
			String 	title =txt.subSequence(be, end).toString();
				
						System.out.println(title);
						return title.replace("<title>", "");

				}
		}
		 
		return null;
	}

}
