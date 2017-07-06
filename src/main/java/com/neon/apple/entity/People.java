/*
 * 文件名：people.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月5日
 */

package com.neon.apple.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * 人的实体类
 * 〈功能详细描述〉
 * @author xiyan
 * @version 2017年7月5日
 * @see People
 * @since
 */
@Entity
public class People {
    @NotNull(message="姓名不能为空！")
    private String name;
    private Integer age;
    private String sex;
    @Id
    private Integer id;
    
    
    @Override
    public String toString() {
        return "People [name=" + name + ", age=" + age + ", sex=" + sex + ", id=" + id + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
}
