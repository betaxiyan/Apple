/*
 * 文件名：PeopleRespository.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月5日
 */

package com.neon.apple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neon.apple.entity.People;

public interface PeopleRespository extends JpaRepository<People, Integer> {
    
}
