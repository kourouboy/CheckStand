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
    public static void quit(){
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
                case "S": {
                    order.printOrder();
                    break;
                }
                case "A": {
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
                    System.out.println("输入有误！请按照格式要求输入信息！");
                    break;
                }
                case "D": {
                    System.out.println("请输入要取消的商品编号 数量 格式如下：2 3");
                    String line = reader.nextLine();
                    String[] infoArray = line.split(" ");
                    if(infoArray != null && infoArray.length == 2){
                        Goods goods = GoodsCenter.getGoods(Integer.parseInt(infoArray[0]));
                        if (goods != null){
                            order.add(goods,Integer.parseInt(infoArray[1]));
                            order.printOrder();
                            break;
                        }
                    }
                    System.out.println("输入有误！请按照格式要求输入信息！");
                    break;
                }
                case "L": {
                    GoodsCenter.printGoods();
                }
                case "R": {
                    return;
                }
                default:{
                    payMenu();
                }
            }
        }

    }

    //设置
    public static void setting(){

        settingInfo();
        if(GoodsCenter.isFull()){
            System.out.println("当前货架已满，如果需要添加则下架一些物品");
        }
        while (true){
            String message = reader.nextLine();
            switch (message.toUpperCase()){
                case "S":{
                    GoodsCenter.printGoods();
                    break;
                }
                case "A":{
                    System.out.println("请输入上架商品信息，格式如下：1 橙子 2.0");
                    Goods goods = readGoods();
                    if(goods == null){
                        System.out.println("输入有误，请按格式要求重新输入！");
                        break;
                    }
                    if(GoodsCenter.isFull()){
                        System.out.println("当前货架已满，如果要上架新的商品，请先下架部分商品");
                    }else if(GoodsCenter.isExist(goods)) {
                        System.out.println("当前商品已存在，请检查后重新输入！");
                    }else{
                        GoodsCenter.addGoods(goods);
                        GoodsCenter.printGoods();
                    }
                    break;
                }
                case "D":{
                    System.out.println("请输入下架商品信息，格式如下：1 ");
                    Goods goods = readGoods();
                    if(goods == null){
                        System.out.println("输入有误，请按格式要求重新输入！");
                        break;
                    }
                    if (GoodsCenter.isPutaway(goods)){
                        GoodsCenter.OutGood(goods);
                        GoodsCenter.printGoods();
                    }else {
                        System.out.println("当前商品不存在，请重新输入！");
                    }
                    break;
                }
                case "U":{
                    System.out.println("请输入修改商品的信息，格式如下：1 橙子 2.0");
                    Goods goods = readGoods();
                    if(goods == null){
                        System.out.println("输入有误，请按格式要求重新输入！");
                        break;
                    }
                    if(GoodsCenter.isPutaway(goods)){
                        GoodsCenter.modifyGoods(goods);
                        GoodsCenter.printGoods();
                    }else {
                        System.out.println("当前商品不存在，请重新输入！");
                    }
                    break;
                }
                case "R":{
                    return;
                }
                default:{
                    settingInfo();
                }
            }
        }
    }
    //通过输入信息获取具体商品
    public static Goods readGoods(){
        String line = reader.nextLine();
        String[] infoArray = line.split(" ");
        if (infoArray != null && infoArray.length == 3 || infoArray.length == 1){
            if(infoArray.length == 3){//上架
                Goods goods = new Goods(Integer.parseInt(infoArray[0]),
                        infoArray[1],Double.parseDouble(infoArray[2]));
                return goods;
            }//Integer,parseInt(String) :将string类型转换成Integer整型类型
            if(infoArray.length == 1){//下架
                Goods goods = new Goods(Integer.parseInt(infoArray[0]),"",0.0D);
                return goods;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        beginMenu();
        while (true){
            String line = reader.nextLine();
            switch (line.trim().toUpperCase()){
                case "U":{
                    pay();
                    beginMenu();
                    break;
                }
                case "S":{
                    setting();
                    beginMenu();
                    break;
                }
                case "A":{
                    about();
                    break;
                }
                case "Q":{
                    quit();
                    break;
                }
                default:{
                    beginMenu();
                }
            }
        }
    }
}
