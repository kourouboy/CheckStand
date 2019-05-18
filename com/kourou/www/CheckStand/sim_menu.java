package com.kourou.www.CheckStand;

import sun.net.idn.Punycode;

import java.lang.reflect.Parameter;
import java.util.Scanner;

public class sim_menu {
    public static Scanner reader = new Scanner(System.in);



    //开始菜单
    public static void beginMenu(){
        System.out.println("**************欢迎使用简易超市收银台*************");
        System.out.println("       [U] 使用 [S] 设置 [A] 关于 [Q] 退出      ");
        System.out.println("           输入： U  S  A  Q  进入操作          ");
        System.out.println("**********************************************");
    }
    //退出菜单
    public static void quitMenu(){
        System.out.println("**********************************************");
        System.out.println("                谢谢使用，下次再见              ");
        System.out.println("**********************************************");
        System.exit(0);
    }
    //关于
    public static void about(){
        System.out.println("*********************关于*********************");
        System.out.println("        名称: 简易收银台                        ");
        System.out.println("        功能: 基于字符界面的收银台操作系统         ");
        System.out.println("        作者: kourou                           ");
        System.out.println("        版本: V1.0                             ");
        System.out.println("        意见反馈: 18049155516@189.cn            ");
        System.out.println("*******************************************\n\n");
    }
    //买单界面
    public static void payMenu(){
        System.out.println("******************买单功能*********************");
        System.out.println("  [S] 查看 [A] 下单 [D] 取消 [L] 浏览 [R] 返回  ");
        System.out.println("         输入： S  A  D  L  R  进入操作         ");
        System.out.println("**********************************************");
    }
    //设置界面
    public static void settingInfo() {
        System.out.println("*******************设置功能********************");
        System.out.println("  [S] 查看 [A] 上架 [D] 下架 [U] 修改 [R] 返回  ");
        System.out.println("         输入： S  A  D  U  R  进入操作         ");
        System.out.println("**********************************************");
    }

    //买单功能
    public static void pay(){
        payMenu();
        GoodsCenter.printGoods();//打印
        Order order = new Order();
        while (true){
            String message = reader.nextLine();
            switch (message.trim().toUpperCase()){
                case "S":
                case "s":{
                    order.printOrder();
                    break;
                }
                case "A":
                case "a":{
                    System.out.println("请输入货品商品信息：[编号 数量] 格式：1 3");
                    String line = reader.nextLine();
                    //以信息的空格为界限，将信息存入一个字符串数组中
                    String[] infoArray = line.split(" ");
                    if(infoArray != null && infoArray.length == 2){
                        //判断客户输入信息是否正确，正确则在商品中心调出商品信息
                        Goods goods = GoodsCenter.getGoods(Integer.parseInt(infoArray[0]));
                        if(goods != null){
                            order.add(goods,Integer.parseInt(infoArray[1]));
                            order.printOrder();
                            break;
                        }
                    }
                    System.out.println();
                }
            }
        }

    }

    //设置
    public static void setting(){

    }
    //通过输入信息获取具体商品
    public static Goods readGoods(){
        return null;
    }

    public static void main(String[] args) {

    }
}
