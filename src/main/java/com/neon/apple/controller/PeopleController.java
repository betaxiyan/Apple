/*
 * 文件名：PeopleController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月5日
 */

package com.neon.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.neon.apple.entity.People;
import com.neon.apple.repository.PeopleRespository;


/**
 * peopleController控制器
 * @author xiyan
 * @version 2017年7月5日
 * @see PeopleController
 * @since
 */
@RestController
public class PeopleController {
    
    @Autowired
    private PeopleRespository pr1;
    
    @GetMapping("/index")
    public String toIndex() {
        return "index";
        
    }
    /**
     * Description: <br>
     * 添加一个people
     * @param id
     * @param name*/
    @GetMapping("/add")
    public People add(@RequestParam(value="id")Integer id,
                      @RequestParam(value="name")String name) {
        People p1 = new People();
        p1.setId(id);
        p1.setAge(15);
        p1.setSex("男");
        p1.setName(name);
        return pr1.save(p1);
        
    }
    /**
     * Description: <br>
     * 数据库中插入一个People
     * @param p1
     * @return 
     * @see 
     */
    @GetMapping("/insert")
    public People insert(People p1) {
        return pr1.save(p1);
        
    }
    /**
     * Description: <br>
     * 选择全部people，并返回list
     * @return 
     * @see 
     */
    @GetMapping("selectAll")
    public List<People> selectAll(){
        return pr1.findAll();
    }
    /**
     * Description: <br>
     * 根据id删除
     */
    @GetMapping("/delete")
    public void delete(@RequestParam("id")Integer id){
        pr1.delete(id);
    }
    /**
     * Description: <br>
     * 根据id修改
     * @return 
     */
    @GetMapping("/update")
    public People update(People p1){
        return pr1.save(p1);
    }
}
