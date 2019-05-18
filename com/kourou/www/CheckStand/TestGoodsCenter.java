package com.kourou.www.CheckStand;

class GoodsCenter{
//1.新增 2.删除 3.修改 4.打印
    private static String placeHolder = "--";//商品占位符

    private static int maxGoods = 10;//商品最大数量值

    private static Goods[] goodsArray;//商品容器

    //初始化商品容器
    static {
        goodsArray = new Goods[maxGoods];
        for (int i = 0; i <goodsArray.length ; i++) {
            goodsArray[i] = new Goods(i +1,"--",0.0D);
        }
    }
    private GoodsCenter(){
        this.placeHolder = placeHolder;
        this.maxGoods = maxGoods;
        this.goodsArray = new Goods[maxGoods];
    }
    public static int getMaxGoods(){
        return maxGoods;
    }

    //添加商品
    public static void addGoods(Goods goods){

    }

    //下架商品
    public static void OutGood(Goods goods){

    }

    //修改商品
    public static void modifyGoods(Goods goods){

    }

    //判断商品是否存在
    public static boolean isExist(Goods goods){
        return false;
    }

    //判断商品位是否存在
    public static boolean isPutaway(Goods goods){
        return false;
    }

    //商品是否已满
    public static boolean isFull(){
        return true;
    }

    //商品未满则打印其信息
    public static Goods getGoods(int id){
        return null;
    }

    //打印商品
    public static void printGoods(){

    }
}
