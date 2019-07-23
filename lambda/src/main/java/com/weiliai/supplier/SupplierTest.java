package com.weiliai.supplier;

import java.util.function.Supplier;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Student> supplier = ()->new Student();
        System.out.println(supplier.get().getName());

        System.out.println("=========================");
        Supplier<Student> supplier2 = Student::new;
    }

}
