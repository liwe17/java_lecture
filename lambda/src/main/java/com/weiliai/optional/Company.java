package com.weiliai.optional;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Dog Li
 * @Date: 2019/7/18
 */
@Data
@NoArgsConstructor
public class Company {

    private String name;

    private List<Employee> employees;

}
