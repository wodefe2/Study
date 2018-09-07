package com.hll.sb20.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Author helili
 * @Create_Date 2018/8/9
 */
@Data
public class Student {
    @Id
    private String studentId;
    private String name;
    private String score;
    private Integer age;
    private String isMarried;
    private String a;
    private String b;
}
