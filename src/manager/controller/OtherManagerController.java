package manager.controller;

import manager.domain.Customer;
import manager.service.ManagerService;

import java.util.Scanner;

public class OtherManagerController implements BaseManagerController{
    private ManagerService managerService=new ManagerService();
    private Scanner sc = new Scanner(System.in);
//    开启老师管理系统，展示菜单
    public void start() {
//        Scanner sc = new Scanner(System.in);//放在开头
        l:
        while (true){
            System.out.println("欢迎使用管理功能!");
//            System.out.println("1：添加老师");
//            System.out.println("2：删除老师");
//            System.out.println("3：修改老师");
//            System.out.println("4：查看老师");
//            System.out.println("5：退出");
            System.out.println("1：管理用户");
            System.out.println("2：管理水果");
            System.out.println("3：退出");
            System.out.print("请输入要选择的操作（1~3）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
                        manageCustomer();
                        break lo;
                    case "2":
                        manageFruit();
                        break lo;
                    case "3":
                        System.out.println("退出管理系统，成功！");
//                        退出当前正在运行的JVM虚拟机
                        break l;
                    default:
                        System.out.print("您的输入有误，请重新输入。");
                        break lo1;
                }
            }
        }
    }

    @Override
    public void manageCustomer() {
        l:
        while (true) {
            System.out.println("欢迎使用顾客管理功能!");
            System.out.println("1：注册新用户");
            System.out.println("2：编辑现用户");
            System.out.println("3：退出");
            System.out.print("请输入要选择的操作（1~3）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
                        addCustomer();
                        break lo;
                    case "2":
                        manageCustomer();
                        break lo;
                    case "3":
                        System.out.println("退出管理系统，成功！");
//                        退出当前正在运行的JVM虚拟机
                        break l;
                    default:
                        System.out.print("您的输入有误，请重新输入。");
                        break lo1;
                }
            }
        }
    }

    @Override
    public void manageFruit() {
        l:
        while (true) {
            System.out.println("欢迎使用水果管理功能!");
            System.out.println("1：添加水果");
            System.out.println("2：修改水果数据");
            System.out.println("3：退出");
            System.out.print("请输入要选择的操作（1~3）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
                        addFruit();
                        break lo;
                    case "2":
                        changeFruits();
                        break lo;
                    case "3":
                        System.out.println("退出管理系统，成功！");
//                        退出当前正在运行的JVM虚拟机
                        break l;
                    default:
                        System.out.print("您的输入有误，请重新输入。");
                        break lo1;
                }
            }
        }
    }

    private void changeFruits() {
    }

    private void addFruit() {
    }

    public void addCustomer() {
//        局部变量id
        String addId=null;
        l:
        while (true){
            System.out.println("请输入顾客的ID：");
            addId=sc.next();
//            判断ID是否存在
            l1:
            while (true){
                boolean exists = managerService.isExists(addId);
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
                    Customer customer =inputManagerInfo(addId);
//        将顾客对象传给ManagerService中的addManager方法
                    boolean result=managerService.addCustomer(customer);
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
    public String inputManagerId(){
        String Id=null;
        l:
        while (true){
            System.out.println("请输入顾客的ID：");
            Id=sc.next();
//            判断ID是否存在
            l1:
            while (true){
                boolean exists = managerService.isExists(Id);
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

    public Customer inputManagerInfo(String id){
        //            根据ID修改顾客
        System.out.println("请输入顾客昵称：");
        String name = sc.next();
        System.out.println("请输入充值金额：");
        String age = sc.next();
//        将键盘录入信息封装为顾客对象
        Customer newmanager = new Customer();
        newmanager.setId(id);
        newmanager.setName(name);
        newmanager.setAge(age);
        return newmanager;
    }
}
