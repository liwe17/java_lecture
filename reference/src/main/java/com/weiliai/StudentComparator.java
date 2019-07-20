package com.weiliai;

/**
 * @author: Dog Li
 * @Date: 2019/7/20
 */
public class StudentComparator {

    public  int compareStudentByScore(Student student1,Student student2){
        return student1.getScore()-student2.getScore();
    }

    public  int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

}
