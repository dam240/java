package com.cd.da51.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App  
{
    public static void main( String[] args )
    {
    
    		SpringApplication.run(App.class, args);
    		try {  
                System.in.read();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
    
    }

	
    
   
	
}
