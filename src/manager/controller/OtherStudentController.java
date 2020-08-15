package manager.controller;

import manager.domain.Student;
import manager.service.StudentService;

import java.util.Scanner;

public class OtherStudentController {
    private StudentService studentService=new StudentService();
    private Scanner sc = new Scanner(System.in);
//    开启学生管理系统，展示菜单
    public void start() {
//        Scanner sc = new Scanner(System.in);//放在开头
        l:
        while (true){
            System.out.println("欢迎使用学生管理功能!");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查看学生");
            System.out.println("5：退出");
            System.out.print("请输入要选择的操作（1~5）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
                        addStudent();
                        break lo;
                    case "2":
                        deleteStudentById();
                        break lo;
                    case "3":
                        updateStudent();
                        break lo;
                    case "4":
                        findAllStudent();
                        break lo;
                    case "5":
                        System.out.println("退出学生管理，成功！");
//                        退出当前正在运行的JVM虚拟机
                        break l;
                    default:
                        System.out.print("您的输入有误，请重新输入。");
                        break lo1;
                }
            }
        }
    }

    public void updateStudent() {
        String updateId=inputStudentId();
        if(updateId!=null){
            Student newstudent=inputStudentInfo(updateId);
            studentService.updateStudent(updateId,newstudent);
            System.out.println("修改成功！");
        }
    }

    public void deleteStudentById() {
        String delId=inputStudentId();
        if(delId!=null){
            //            根据ID删除学生
            studentService.deleteStudentById(delId);
            System.out.println("删除成功！");
        }
    }

    public void findAllStudent() {
        Student[] students=studentService.findAllStudent();
//        判断数组是否为空
        if(students==null){
            System.out.println("查无信息，请添加后重试。");
            return;
        }
//        遍历数组打印学生信息
        System.out.println("学号\t\t姓名\t年龄\t\t生日");
        for (int i = 0; i < students.length; i++) {
            Student student=students[i];
            if(student!=null){
                System.out.println(student.getId()+"\t\t"+student.getName()+"\t"+student.getAge()+"\t\t"+student.getBirthday());
            }
        }
    }

    public void addStudent() {
//        局部变量id
        String addId=null;
        l:
        while (true){
            System.out.println("请输入学生的ID：");
            addId=sc.next();
//            判断ID是否存在
            l1:
            while (true){
                boolean exists = studentService.isExists(addId);
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
                    Student student=inputStudentInfo(addId);
//        将学生对象传给StudentService中的addStudent方法
                    boolean result=studentService.addStudent(student);
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

//    录入学生ID
    public String inputStudentId(){
        String Id=null;
        l:
        while (true){
            System.out.println("请输入学生的ID：");
            Id=sc.next();
//            判断ID是否存在
            l1:
            while (true){
                boolean exists = studentService.isExists(Id);
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

    public Student inputStudentInfo(String id){
        //            根据ID修改学生
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();
//        将键盘录入信息封装为学生对象
        Student newstudent = new Student(id,name,age,birthday);
        //开闭原则：对扩展内容开放，对修改内容关闭
//        newstudent.setId(id);
//        newstudent.setName(name);
//        newstudent.setAge(age);
//        newstudent.setBirthday(birthday);
        return newstudent;
    }
}
