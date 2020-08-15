package manager.controller;

import manager.domain.Customer;
import manager.service.ManagerService;

import java.util.Scanner;

public interface BaseManagerController {
     ManagerService managerService=new ManagerService();
     Scanner sc = new Scanner(System.in);
//    开启老师管理系统，展示菜单
    public void start();

    public void manageCustomer();

    public void manageFruit();

//    录入老师ID
    public String inputManagerId();

    public Customer inputManagerInfo(String id);
}
