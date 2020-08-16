package manager.controller;

import manager.service.FruitService;

import java.util.Scanner;

public interface BaseCustomerController {
    FruitService customerService = new FruitService();
    Scanner sc = new Scanner(System.in);

    //    开启顾客管理系统，展示菜单
    public void start();

    public void logIn();

    public void findAllFruit();

    public void buyFruit();

    public void checkout();

    //    录入水果ID
    public String inputFruitId();
//抽象方法没有｛｝主体，分号结尾代替

}
