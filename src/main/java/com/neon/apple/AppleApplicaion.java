/*
 * 文件名：AppleApplicaion.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月5日
 */

package com.neon.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author xiyan
 * @version 2017年7月5日
 * @see AppleApplicaion
 * @since
 */
@RestController
@SpringBootApplication
public class AppleApplicaion {
  
    
    /**
     * Description: <br>
     * Implement: <br> 
     * @return 
     * @see 
     */
    
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
        
    }
    
    /**
     * Description: <br>
     * Implement: <br>
     * @param args 
     * @see 
     */
    public static void main(String[] args){
        SpringApplication.run(AppleApplicaion.class,args);
    }

}
