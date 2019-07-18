package com.weiliai.supplier;

import java.util.function.Supplier;

/**
 * @author: Dog Li
 * @Date: 2019/7/18
 */
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Student> supplier = ()->new Student();
        System.out.println(supplier.get().getName());

        System.out.println("=========================");
        Supplier<Student> supplier2 = Student::new;
    }

}
