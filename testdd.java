package com.cd.http;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class testdd {
	
	
public static void main(String[] args) {
	try {
		MemcachedClient	mcc= new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		//mcc.add("daa", 1000*590*1000, "2222");

	Object  txt=mcc.get("wapsite.baidu.com");
		//mcc.statsItems();
	System.out.println(txt.toString());
    mcc.shutdown();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}



}
