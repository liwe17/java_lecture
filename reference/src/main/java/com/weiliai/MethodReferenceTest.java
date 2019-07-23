package com.weiliai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 30);
        Student student3 = new Student("wangwu", 20);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        //1.静态方法引用-类名::静态方法名

        //传统的排序 JDK1.8
        Collections.sort(students,(item,item2) ->Student.compareStudentByName(item,item2));
        Collections.sort(students,(item,item2) ->Student.compareStudentByScore(item,item2));
        students.sort((item,item2) ->Student.compareStudentByName(item,item2));
        students.sort((item,item2) ->Student.compareStudentByScore(item,item2));
        //静态方法引用
        Collections.sort(students,Student::compareStudentByName);
        Collections.sort(students,Student::compareStudentByScore);
        students.sort(Student::compareStudentByName);
        students.sort(Student::compareStudentByScore);

        //2.实例方法引用-实例名::实例方法名
        //传统的排序 JDK1.8
        StudentComparator studentComparator = new StudentComparator();
        Collections.sort(students,(item,item2) ->studentComparator.compareStudentByName(item,item2));
        Collections.sort(students,(item,item2) ->studentComparator.compareStudentByScore(item,item2));
        students.sort((item,item2) ->studentComparator.compareStudentByName(item,item2));
        students.sort((item,item2) ->studentComparator.compareStudentByScore(item,item2));
        //实例方法引用
        Collections.sort(students,studentComparator::compareStudentByScore);
        Collections.sort(students,studentComparator::compareStudentByName);
        students.sort(studentComparator::compareStudentByScore);
        students.sort(studentComparator::compareStudentByName);

        //3.类名-实例方法名-类名::实例方法名
        Collections.sort(students,Student::compareScore);
        Collections.sort(students,Student::compareName);
        students.sort(Student::compareScore);
        students.sort(Student::compareName);

        //4.构造方法引用-类名::new


    }

}
