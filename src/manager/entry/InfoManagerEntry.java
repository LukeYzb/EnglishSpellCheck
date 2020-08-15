package manager.entry;

import manager.controller.OtherStudentController;
import manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l:
        while (true){
            System.out.println("欢迎使用管理系统!");
            System.out.println("1：学生管理");
            System.out.println("2：老师管理");
            System.out.println("3：退出系统");
            System.out.print("请输入要选择的操作（1~3）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
//                        开启学生管理系统
                        OtherStudentController studentController=new OtherStudentController();
                        studentController.start();
                        break lo;
                    case "2":
//                        开启老师管理系统
                        TeacherController teacherController=new TeacherController();
                        teacherController.start();
                        break lo;
                    case "3":
                        System.out.println("退出成功，欢迎下次使用！");
//                        退出当前正在运行的JVM虚拟机
                        System.exit(0);
                    default:
                        System.out.print("您的输入有误，请重新输入。");
                        break lo1;
                }
            }
        }
    }
}
