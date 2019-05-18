package com.kourou.www.CheckStand;
class Order{
    private static int orderId = 0;
    private int id;
    private Goods[] items;
    private int[] itemsNumber;
    private int currentIndex;

    public Order() {
        this.id = ++orderId;
        this.items = new Goods[GoodsCenter.getMaxGoods()];
        this.itemsNumber = new int[GoodsCenter.getMaxGoods()];
        this.currentIndex = -1;
    }

    //添加订单
    public void add(Goods goods,int count){

    }

    //取消订单
    public void cancel(Goods goods,int count){

    }

    public int getSize(){
        return this.currentIndex +1;

    }

    //计算总价
    public double getTotalPrice(){
        double total = 0;
        return total;
    }

    public int getId(){
        return this.id;
    }

    //打印订单
    public void printOrder(){

    }
}

