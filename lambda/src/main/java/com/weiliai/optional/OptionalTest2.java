package com.weiliai.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: Dog Li
 * @Date: 2019/7/18
 */
public class OptionalTest2 {

    public static void main(String[] args) {

        //初始化数据
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company");

        List<Employee> employees = Arrays.asList(employee, employee2);
        company.setEmployees(employees);

        List<Employee> list = company.getEmployees();

        //传统方法
        /*if(null!=list){
            return list;
        }else{
            return new ArrayList<Employee>();
        }*/

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(company1 -> company1.getEmployees()).orElse(Collections.emptyList()));
    }

}
