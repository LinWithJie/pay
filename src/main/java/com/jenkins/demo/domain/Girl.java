package com.jenkins.demo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author created by BangZhuLi
 * @date 2018/1/10
 */
@Data
@ToString
@Entity
public class Girl implements Serializable{

    private static final long serialVersionUID = 7923370172131413546L;
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String cup;

    @Min(value = 18,message = "未成年人不能进入")
    @Max(value = 100,message = "太老了你")
    private Integer age;
}
