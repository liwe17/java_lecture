package com.weiliai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private String name;

    private int score;


    public static int compareStudentByScore(Student student1,Student student2){
        return student1.getScore()-student2.getScore();
    }

    public static int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public  int compareScore(Student student){
        return this.getScore()-student.getScore();
    }

    public  int compareName(Student student){
        return this.getName().compareToIgnoreCase(student.getName());
    }


}
