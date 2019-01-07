package com.univ.ioc;

import java.util.Properties;

/** 
 * author univ
 * date 2016年1月21日 上午9:16:14
 * @version v1.0
 * description:
 */

/**
 * 用于演示Properties类型属性的注入
 */
public class MyProperties {

	private String name;
	private Properties pros1;
	private Properties pros2;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Properties getPros1() {
		return pros1;
	}
	public void setPros1(Properties pros1) {
		this.pros1 = pros1;
	}
	public Properties getPros2() {
		return pros2;
	}
	public void setPros2(Properties pros2) {
		this.pros2 = pros2;
	}
	
	
}

