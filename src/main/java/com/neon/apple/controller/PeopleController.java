/*
 * 文件名：PeopleController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月5日
 */

package com.neon.apple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.neon.apple.entity.People;
import com.neon.apple.entity.Result;
import com.neon.apple.repository.PeopleRespository;
import com.neon.apple.utils.ResultUtils;


/**
 * peopleController控制器
 * @author xiyan
 * @version 2017年7月5日
 * @see PeopleController
 * @since
 */
@Controller
public class PeopleController {
    
    private static final Logger log = LoggerFactory.getLogger(PeopleController.class);

    
    @Autowired
    private PeopleRespository pr1;
    
    @GetMapping("/index")
    @ResponseBody
    public String toIndex() {
        return "index";
        
    }
    /**
     * 添加一个people
     */
    @GetMapping("/add")
    @ResponseBody 
    public Result<People> add(@Valid People p1,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtils.error(p1,bindingResult.getFieldError().getDefaultMessage());
        }    
        p1.setAge(15);
        p1.setSex("男");
        return ResultUtils.success(pr1.save(p1));
        
    }
    /**
     * Description: <br>
     * 数据库中插入一个People
     * @param p1
     * @return 
     * @see 
     */
    @GetMapping("/insert")
    @ResponseBody
    public People insert(People p1) {
        return pr1.save(p1);
        
    }
    /**
     * Description: <br>
     * 选择全部people，并返回list
     * @return 
     * @see 
     */
    @GetMapping("/selectAll")
    @ResponseBody
    public List<People> selectAll(){
        return pr1.findAll();
    }
    /**
     * Description: <br>
     * 根据id删除
     */
    @GetMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("id")Integer id){
        pr1.delete(id);
    }
    /**
     * Description: <br>
     * 根据id修改
     * @return 
     */
    @GetMapping("/update")
    @ResponseBody
    @Transactional
    public People update(People p1){
       
        return pr1.save(p1);
    }
    
    @GetMapping("/age")
    @ResponseBody
    public void age(@RequestParam("id")Integer id) throws Exception {
        
        this.getAge(id);
    
    }
    
    public void getAge(Integer id) throws Exception {
        People people = pr1.findOne(id);
        Integer age = people.getAge();
        if (age<16) {
            throw new Exception("未满16岁！");
        }
    }
    
}
