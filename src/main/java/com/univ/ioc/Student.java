package com.univ.ioc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Student implements InitializingBean {
	private String name;
	private int age;	
	
	/*
	 * 使用@Autowired可以省去此字段的setter方法和配置文件bean定义中的property属性.默认byType
	 */
	@Autowired
	private Teacher teacher;

    public Student() {
        System.out.println("Student的无参构造函数");
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Teacher getTeacher() {
		return teacher;
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Student#afterPropertiesSet, this:" + this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    /*public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}*/
}
