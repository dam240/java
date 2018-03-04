package com.cd.use.model;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ins implements InvocationHandler{
	
	private Object name;
	
	

	public Ins(Object object) {
		super();
		this.name = object;
	}



	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		//System.out.println(arg2.length);
		/*for(int i=0;i<arg2.length;i++) {
			System.out.println(arg2[i].getClass().getName());
		}*/
	    /*ByteBuffer buffer =ByteBuffer.allocate(1*1024);
		FileChannel  fileChannel=
				FileChannel.open(Paths.get(name), StandardOpenOption.READ);
		
	       fileChannel.read(buffer);
		   buffer.flip();
		 byte [] b= buffer.array();
		 String filename= new String(b);
		  System.out.println(filename+"--------");
		
		  Class c=Class.forName(filename.trim());*/
		  //System.out.println(c.getName());
		  
		  
		//System.out.println("--->"+arg0.getClass().getName());

		return arg1.invoke(name, arg2);
	}

}
