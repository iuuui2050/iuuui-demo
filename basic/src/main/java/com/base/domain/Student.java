package com.base.domain;

/**
 * @author iuuui
 * @time 2024/03/16 1738
 */
public class Student {

    private Long id;

    private String name;

    private Integer age;

    private String describe;

    static {
        System.err.println("Student类的初始化执行了");
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
