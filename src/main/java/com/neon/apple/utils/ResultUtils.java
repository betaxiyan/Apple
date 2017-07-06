/*
 * 文件名：ResultUtils.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月6日
 */

package com.neon.apple.utils;

import com.neon.apple.entity.Result;

public class ResultUtils {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(object);
       
        return result;
    }
    public static Result error(Object object,String message) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage(message);
        result.setData(object);
        return result;
    }
    
    
   
}
