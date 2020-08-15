package manager.controller;

import manager.domain.Fruit;
import manager.service.FruitService;

import java.util.Scanner;

public class OtherCustomerController implements BaseCustomerController {
    private FruitService customerService = new FruitService();
    private Scanner sc = new Scanner(System.in);

    //    开启学生管理系统，展示菜单
    public void start() {
//        Scanner sc = new Scanner(System.in);//放在开头
        l:
        while (true) {
            System.out.println("欢迎使用顾客购买功能!");
//            System.out.println("1：添加学生");
//            System.out.println("2：删除学生");
//            System.out.println("3：修改学生");
//            System.out.println("4：查看学生");
//            System.out.println("5：退出");
            System.out.println("1：登录");
            System.out.println("2：查看水果");
            System.out.println("3：开始购买");
            System.out.println("4：结账");
            System.out.println("5：退出");
            System.out.print("请输入要选择的操作（1~5）：");
            lo:
            while (true) {
                String choice = sc.next();
                lo1:
                switch (choice) {
                    case "1":
                        logIn();
                        break lo;
                    case "2":
                        findAllFruit();
                        break lo;
                    case "3":
                        buyFruit();
                        break lo;
                    case "4":
                        checkout();
                        break lo;
                    case "5":
                        System.out.println("退出顾客购买系统，成功！");
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
    public void logIn() {

    }

    @Override
    public void findAllFruit() {
        Fruit[] fruits = customerService.findAllFruit();
//        判断数组是否为空
        if (fruits == null) {
            System.out.println("查无信息，请添加后重试。");
            return;
        }
//        遍历数组打印学生信息
        System.out.println("编号\t\t名称\t价格\t\t库存量");
        for (int i = 0; i < fruits.length; i++) {
            Fruit fruit = fruits[i];
            if (fruit != null) {
                System.out.println(fruit.getId() + "\t\t" + fruit.getName() + "\t" + fruit.getAge() + "\t\t" + fruit.getAmount());
            }
        }
    }

    @Override
    public void buyFruit() {

    }

    @Override
    public void checkout() {

    }


    //    录入水果ID，可以用在buyFruit功能里
    public String inputCustomerId() {
        String Id = null;
        l:
        while (true) {
            System.out.println("请输入水果的ID：");
            Id = sc.next();
//            判断ID是否存在
            l1:
            while (true) {
                boolean exists = customerService.isExists(Id);
                if (!exists) {//exists为负,则执行
                    System.out.println("ID不存在，退出请输入0，不退出请重新输入ID：");
                    int exit;
                    exit = sc.nextInt();
                    if (exit == 0) {
                        Id = null;
                        System.out.println("退出成功！");
                        break l;
                    } else {
                        Id = String.valueOf(exit);
                    }
                } else {
                    break l;
                }
            }
        }
        return Id;
    }
}
