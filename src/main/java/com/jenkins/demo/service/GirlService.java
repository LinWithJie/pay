package com.jenkins.demo.service;


import com.jenkins.demo.dao.GirlRepository;
import com.jenkins.demo.domain.Girl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author created by BangZhuLi
 * @date 2018/1/10
 */
@Service
@Slf4j
public class GirlService {

    @Autowired
    private GirlRepository repository;

    public Girl findById(Integer id) {
        return repository.findOne(id);
    }

    public List<Girl> findAll(){
        return repository.findAll();
    }

    public Girl save(Girl girl) {

        return repository.save(girl);
    }

    public Girl update(Girl girl) {
        return save(girl);
    }

    public void delete(Girl girl) {
        repository.delete(girl);
    }

    public void deleteById(Integer id) {
        repository.delete(id);
    }
}
