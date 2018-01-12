package com.jenkins.demo.dao;

import com.jenkins.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author created by BangZhuLi
 * @date 2018/1/10
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl,Integer>{

}
