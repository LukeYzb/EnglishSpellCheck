package manager.controller;

import manager.domain.Teacher;
import manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService=new TeacherService();
    private Scanner sc = new Scanner(System.in);
//    开启老师管理系统，展示菜单
    public void start() {
//        Scanner sc = new Scanner(System.in);//放在开头
        l:
        while (true){
            System.out.println("欢迎使用老师管理功能!");
            System.out.println("1：添加老师");
            System.out.println("2：删除老师");
            System.out.println("3：修改老师");
            System.out.println("4：查看老师");
            System.out.println("5：退出");
            System.out.print("请输入要选择的操作（1~5）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
                        addTeacher();
                        break lo;
                    case "2":
                        deleteTeacherById();
                        break lo;
                    case "3":
                        updateTeacher();
                        break lo;
                    case "4":
                        findAllTeacher();
                        break lo;
                    case "5":
                        System.out.println("退出老师管理，成功！");
//                        退出当前正在运行的JVM虚拟机
                        break l;
                    default:
                        System.out.print("您的输入有误，请重新输入。");
                        break lo1;
                }
            }
        }
    }

    public void updateTeacher() {
        String updateId=inputTeacherId();
        if(updateId!=null){
            Teacher newteacher=inputTeacherInfo(updateId);
            teacherService.updateTeacher(updateId,newteacher);
            System.out.println("修改成功！");
        }
    }

    public void deleteTeacherById() {
        String delId=inputTeacherId();
        if(delId!=null){
            //            根据ID删除老师
            teacherService.deleteTeacherById(delId);
            System.out.println("删除成功！");
        }
    }

    public void findAllTeacher() {
        Teacher[] teachers=teacherService.findAllTeacher();
//        判断数组是否为空
        if(teachers==null){
            System.out.println("查无信息，请添加后重试。");
            return;
        }
//        遍历数组打印老师信息
        System.out.println("工号\t\t姓名\t年龄\t\t生日");
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher=teachers[i];
            if(teacher!=null){
                System.out.println(teacher.getId()+"\t\t"+teacher.getName()+"\t"+teacher.getAge()+"\t\t"+teacher.getBirthday());
            }
        }
    }

    public void addTeacher() {
//        局部变量id
        String addId=null;
        l:
        while (true){
            System.out.println("请输入老师的ID：");
            addId=sc.next();
//            判断ID是否存在
            l1:
            while (true){
                boolean exists = teacherService.isExists(addId);
                if(exists){//exists为负,则执行
                    System.out.println("ID已存在，退出请输入0，不退出请重新输入ID：");
                    int exit;
                    exit=sc.nextInt();
                    if(exit==0){
                        System.out.println("退出成功！");
                        break l;
                    }else {
                        addId=Integer.toString(exit);
                    }
                }else {
                    Teacher teacher=inputTeacherInfo(addId);
//        将老师对象传给TeacherService中的addTeacher方法
                    boolean result=teacherService.addTeacher(teacher);
//        根据返回的bool结果显示添加是否成功
                    if(result){
                        System.out.println("添加成功。");
                    }else {
                        System.out.println("添加失败。");
                    }
                    break l;
                }
            }
        }
    }

//    录入老师ID
    public String inputTeacherId(){
        String Id=null;
        l:
        while (true){
            System.out.println("请输入老师的ID：");
            Id=sc.next();
//            判断ID是否存在
            l1:
            while (true){
                boolean exists = teacherService.isExists(Id);
                if(!exists){//exists为负,则执行
                    System.out.println("ID不存在，退出请输入0，不退出请重新输入ID：");
                    int exit;
                    exit=sc.nextInt();
                    if(exit==0){
                        Id=null;
                        System.out.println("退出成功！");
                        break l;
                    }else {
                        Id= String.valueOf(exit);
                    }
                }else {
                    break l;
                }
            }
        }
        return Id;
    }

    public Teacher inputTeacherInfo(String id){
        //            根据ID修改老师
        System.out.println("请输入老师姓名：");
        String name = sc.next();
        System.out.println("请输入老师年龄：");
        String age = sc.next();
        System.out.println("请输入老师生日：");
        String birthday = sc.next();
//        将键盘录入信息封装为老师对象
        Teacher newteacher = new Teacher();
        newteacher.setId(id);
        newteacher.setName(name);
        newteacher.setAge(age);
        newteacher.setBirthday(birthday);
        return newteacher;
    }
}
