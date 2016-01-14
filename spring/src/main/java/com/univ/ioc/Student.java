package com.univ.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String name;
	private int age;	
	
	/*
	 * 使用@Autowired可以省去此字段的setter方法和配置文件bean定义中的property属性
	 */
	@Autowired
	private Teacher teacher;
	
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
	/*public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}*/
}
