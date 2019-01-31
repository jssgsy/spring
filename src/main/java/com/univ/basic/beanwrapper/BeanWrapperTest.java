package com.univ.basic.beanwrapper;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @author univ
 * @date 2019/1/31 4:19 PM
 * @description 演示spring的BeanWrapper
 * BeanWrapper:用来设置和获取bean的属性值，可无限嵌套，核心是BeanWrapper接口及其实现类BeanWrapperImpl
 *
 * 注意：一般不会直接使用BeanWrapper
 *  The BeanWrapper usually is not used by application code directly but is used by the DataBinder and the BeanFactory
 */
public class BeanWrapperTest {

    @Test
    public void test1() {
        // 将原始对象包装(wrapper)起来
        BeanWrapper company = new BeanWrapperImpl(new Company());

        // 使用包装对象给name属性设置值
        company.setPropertyValue("name", "Some Company Inc.");
        // ... can also be done like this:
        /*PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);*/

        // 取属性的值
        System.out.println(company.getPropertyValue("name"));


        // 设置和获取嵌套属性的值
        Employee employee = new Employee();
        employee.setSalary(3.14f);
        BeanWrapper employeeWrapper = new BeanWrapperImpl(employee);
        employeeWrapper.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", employeeWrapper.getWrappedInstance());

        // 取嵌套属性的值
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(salary);
    }
}

// 以下代码均直接拷贝自官方文档
class Company {

    private String name;
    private Employee managingDirector;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return this.managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }
}

class Employee {

    private String name;
    private float salary;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
