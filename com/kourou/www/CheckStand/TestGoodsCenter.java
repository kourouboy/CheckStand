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
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (temp.getId() == goods.getId()){
                temp.setName(goods.getName());
                temp.setPrice(goods.getPrice());
                break;
            }
        }
    }

    //下架商品
    public static void OutGood(Goods goods){
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (temp.getId() == goods.getId()){
                temp.setName(placeHolder);
                temp.setPrice(0.0D);
                break;
            }
        }
    }

    //修改商品
    public static boolean modifyGoods(Goods goods){
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (temp.getId() == goods.getId()){
                temp.setName(goods.getName());
                temp.setPrice(goods.getPrice());
                break;
            }
        }
        return false;
    }

    //判断商品是否存在
    public static boolean isExist(Goods goods){
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (temp.getId() == goods.getId() && temp.getName().equals(goods.getName())){
                return true;
            }
        }
        return false;
    }

    //判断商品位是否存在
    public static boolean isPutaway(Goods goods){
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (temp.getId() == goods.getId() && !temp.getName().equals(placeHolder)){
                return true;
            }
        }
        return false;
    }

    //商品是否已满
    public static boolean isFull(){
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (goodsArray[i].getName().equals(placeHolder)){
                return false;
            }
        }
        return true;
    }

    //商品未满则打印其信息
    public static Goods getGoods(int id){
        for (int i = 0; i <goodsArray.length ; i++) {
            Goods temp = goodsArray[i];
            if (temp.getId() == id && !temp.getName().equals(placeHolder)){
                return goodsArray[i];
            }
        }
        return null;
    }

    //打印商品
    public static void printGoods(){

    }
}
