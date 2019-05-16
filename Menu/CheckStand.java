package Menu;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Scanner;

public class CheckStand {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean con = true;
//        GoodsCenter.initGoodsArray();
        while (con){
            beginMenu();
            System.out.println("请选择您的操作： ");
            String id = reader.nextLine();
            switch (id){
                case "S":
                case "s":{
                    Owner();
                    continue;
                }
                case "C":
                case "c":{
                    Custumer();
                    break;
                }
                case "A":
                case "a":{
                    About();
                    break;
                }
                case "Q":
                case "q":{
                    QuitMenu();
                    con = false;
                    break;
                }
                default:{
                    System.out.println("输入有误，请重新输入：");
                    break;
                }
            }
        }
        reader.close();
    }
    //开始菜单
    public static void beginMenu(){
        System.out.println("*******************************");
        System.out.println("******* 欢迎使用简易收银台 *******");
        System.out.println("       [C]使用    [S]设置       ");
        System.out.println("       [A]关于    [Q]退出       ");
        System.out.println("      输入： C S A Q进入操作     ");
        System.out.println("*******************************\n\n");
    }
    //关于
    public static void About(){
        System.out.println("***************关于**************");
        System.out.println("    名称: 简易收银台               ");
        System.out.println("    功能: 基于字符界面的收银台操作系统");
        System.out.println("    作者: kourou                 ");
        System.out.println("    版本: V1.0                   ");
        System.out.println("    意见反馈: 18049155516@189.cn  ");
        System.out.println("*********************************\n\n");
    }
    //退出
    public static void QuitMenu(){
        System.out.println("********************************");
        System.out.println("    欢迎下次光临                  ");
        System.out.println("********************************\n\n");

    }
    //读取输入流信息
    public static Goods readGoods(){

        while (true){
            String goods = reader.nextLine();//读取一行信息存到goods中
            goods = goods.trim();//去掉信息中的空格
            String[] goodInfo = goods.split(" ");//以信息的空格为界限，将信息存入一个字符串数组中
            //当字符数组中有6个或2个元素时，执行以下代码
            if(goodInfo != null && goodInfo.length == 6 || goodInfo.length == 2){
                if(goodInfo.length == 6){//创建一个商品类对象，内容时用户输入的商品信息
                    Goods good = new Goods(
                            Integer.parseInt(goodInfo[0]),
                            goodInfo[1],
                            Float.parseFloat(goodInfo[2]),
                            Integer.parseInt(goodInfo[3]),
                            LocalDate.parse(goodInfo[4].subSequence(0,goodInfo[4].length())),
                            LocalDate.parse(goodInfo[5].subSequence(0,goodInfo[5].length())),
                            LocalDate.now()
                    );
                    return good;//返回商品
                }
             if(goodInfo.length == 2){
               Goods good = new Goods(Integer.parseInt(goodInfo[0],goodInfo[1]);
               return good;
               }
            }else {
                System.out.println("格式有误，请重新输入...");
            }
        }
    }

    public static void Owner(){

        boolean cons = true;
        while(cons){
            ownerMenu();
            int num = GoodsCenter.isToTime();//判断商品是否过期
            if(num != 0){
                System.out.println("上架商品中出现过期商品共"+
                        num+ "件，请及时下架！\n");
            }
            System.out.println("请选择您的操作： ");
            String op = reader.nextLine();
            switch (op){
                case "P"://商品上架
                case "p":{
                    GoodsCenter.printGoods();
                    System.out.println("请输入上架商品信息：格式如下；" +
                            "（不用填写上架日期）");
                    System.out.println("1 橘子 5 100 2019-05-15 2019-05-25");
                    Goods goods = readGoods();
                    GoodCenter.addGood(goods);
                    GoodCenter.printGoods();
                    break;
                }
                case "D"://商品下架
                case "d":{
                    GoodsCenter.printGoods();
                    System.out.println("请输入下架商品编号及名称：格式如下：");
                    System.out.println("1 苹果");
                    Goods goods = readGoods();
                    GoodsCenter.deleteGood(goods);
                    GoodsCenter.printGoods();
                    break;
                }
                case "Q"://退出店主操作
                case "q":{
                    cons = false;
                    break;
                }
                default:{
                    System.out.println("输入有误，请重新输入：");
                    break;
                }
            }
        }
    }
    public static void Custumer(){
        //顾客操作
        System.out.println("**************************");
        System.out.println("");
        System.out.println("");
        System.out.println("");


    }

    public static void ownerMenu(){
        //店主菜单
        System.out.println("***************************");
        System.out.println("*****       店主      ******");
        System.out.println("");
        System.out.println("");

    }

    public static void customerMenu(){
        //顾客菜单
    }
    //商品信息类
    static class Goods{

        private int no ;//商品货号
        private  String name ;//商品名称
        private float price;//商品价格
        private int num;//商品数量
        private LocalDate toTime;//截至日期
        private LocalDate proTime;//生产日期
        private LocalDate upTime;//上架日期
      //构造方法

        public Goods(int no, String name, float price, int num, LocalDate toTime, LocalDate proTime, LocalDate upTime) {
            this.no = no;
            this.name = name;
            this.price = price;
            this.num = num;
            this.toTime = toTime;
            this.proTime = proTime;
            this.upTime = upTime;
        }

        public Goods(int no,String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public LocalDate getToTime() {
            return toTime;
        }

        public void setToTime(LocalDate toTime) {
            this.toTime = toTime;
        }

        public LocalDate getProTime() {
            return proTime;
        }

        public void setProTime(LocalDate proTime) {
            this.proTime = proTime;
        }

        public LocalDate getUpTime() {
            return upTime;
        }

        public void setUpTime(LocalDate upTime) {
            this.upTime = upTime;
        }
    }


    //货架
    static class GoodsCenter {


        //添加商品
        public static void addGood(Goods goods) {

        }

        //删除商品
        public static void deleteGood(Goods goods) {

        }

        //修改商品信息
        public static void modifyGood(Goods goods) {

        }

        //商品是否已满
        public static void isFull() {

        }

        //商品位是否全为空
        public static boolean isEmply() {
            return true;
        }

        //商品是否存在
        public static boolean isExit(Goods goods) {
            return false;
        }

        //打印商品信息
        public static void printGoods() {

        }

        //判断有几件商品到期了
        public static int isToTime() {
            int count = 0;
            return count;
        }

        //返回商品
        public static Goods getGood(int id) {
            return null;
        }

        //
        public static int getMaxGoods() {
            return getMaxGoods();
        }
    }



}

