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
 * @date 2018/1/15  16:02
 */
@Entity
@Data
@ToString
public class Boy implements Serializable {

    private static final long serialVersionUID = -7632988468820341562L;

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    //身高，单位（cm）
    @NotNull
    private Integer height;

    @Min(value = 18,message = "未成年人不能进入")
    @Max(value = 100,message = "太老了你")
    private Integer age;

}
