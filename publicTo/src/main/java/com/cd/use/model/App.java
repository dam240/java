package com.cd.use.model;

import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
    	A a=(A) prox("cs/test.txt");
    
      System.out.println(a.test());
    }
    
    
    static Object prox(String name) throws Exception{
    	//test t=new test();
    	  ByteBuffer buffer =ByteBuffer.allocate(1*1024);
  		FileChannel  fileChannel=
  		FileChannel.open(Paths.get(name), StandardOpenOption.READ);
  	    fileChannel.read(buffer);
  		   buffer.flip();
  		 byte [] b= buffer.array();
  		 String filename= new String(b);
  	     Class c=Class.forName(filename.trim());
  	     Object  o=c.newInstance();
        Ins s= new Ins(o);
        System.out.println(c.getName());
      Class [] bd= c.getInterfaces();
    	ClassLoader loader=o.getClass().getClassLoader();
      return Proxy.newProxyInstance(loader,new Class[] {bd[0]},s);
    	
    }
}
