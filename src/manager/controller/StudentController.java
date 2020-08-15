package manager.controller;

import manager.domain.Student;

import java.util.Scanner;

public class StudentController extends BaseStudentController {
    private Scanner sc=new Scanner(System.in);
    @Override
    public Student inputStudentInfo(String id){
        //            根据ID修改学生
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();
//        将键盘录入信息封装为学生对象
        Student newstudent = new Student();
        //开闭原则：对扩展内容开放，对修改内容关闭
        newstudent.setId(id);
        newstudent.setName(name);
        newstudent.setAge(age);
        newstudent.setBirthday(birthday);
        return newstudent;
    }
}
