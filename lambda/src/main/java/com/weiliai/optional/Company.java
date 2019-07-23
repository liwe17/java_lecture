package com.weiliai.optional;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
@Data
@NoArgsConstructor
public class Company {

    private String name;

    private List<Employee> employees;

}
