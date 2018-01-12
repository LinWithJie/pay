package com.jenkins.demo.controller;


import com.jenkins.demo.domain.Girl;
import com.jenkins.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author created by BangZhuLi
 * @date 2018/1/10
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService service;

    @GetMapping("/getById")
    public Girl getById(Integer id) {
        return service.findById(id);
    }

    @GetMapping("/getAll")
    public List<Girl> getAll() {
        return service.findAll();
    }

    @PostMapping("/save")
    public Object save(@RequestBody @Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        System.out.println("fkjenwiubfeiuewbfeiuewbi");
        return service.save(girl);
    }

    @PutMapping("/update")
    public Object update(@RequestBody @Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        return service.update(girl);
    }

    @DeleteMapping("/delete")
    public void delete(Integer id) {
        service.deleteById(id);
    }

}
