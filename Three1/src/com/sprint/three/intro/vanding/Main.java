package com.sprint.three.intro.vanding;

import java.util.HashMap;
import java.util.Map;

enum ItemType{
    COKE, PEPSI, JUICE, WATER
}

class Item{
   final private ItemType type;
   final private int price;

    public Item(ItemType type, int price) {
        this.type = type;
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}


class Inventory{
   final private Map<ItemType, Integer> stock= new HashMap<>();


    public void add(ItemType item, int quantity){
        stock.put(item, stock.getOrDefault(item, 0)+quantity);
    }

    public boolean hasItem(ItemType item){
        return stock.getOrDefault(item, 0)> 0;
    }

    public void dispense(ItemType item){
        if(!hasItem(item)) throw new RuntimeException("item out of stock");
        stock.put(item, stock.get(item)-1);
    }
}

class VendingMachine{
    private Inventory inventory= new Inventory();
    private int balance=0;

    public void addItem(ItemType type, int quantity){
        inventory.add(type, quantity);
    }

    public void insertMoney(int amount){
        balance +=amount;
        System.out.println("Inserted: "+amount);
    }

    public void selectItem(Item item){
        if(!inventory.hasItem(item.getType())){
            System.out.println("item out of stock");
            return;
        }

        if(balance <item.getPrice()){
            System.out.println("insufficient price");
            return;
        }
        inventory.dispense(item.getType());
        balance -=item.getPrice();
        System.out.println("dispenced "+item.getType());
        System.out.println("remaining balace: "+balance);

    }

    public void refund(){
        System.out.println("refunding "+balance);
        balance=0;
    }
}
public class Main {
    public static void main(String[] args) {
        VendingMachine vm= new VendingMachine();
        vm.addItem(ItemType.COKE, 5);
        vm.addItem(ItemType.PEPSI, 5);
        vm.addItem(ItemType.WATER, 20);
        vm.addItem(ItemType.JUICE, 20);


        Item coke=new Item(ItemType.COKE, 25);
        vm.insertMoney(30);
        vm.selectItem(coke);
        vm.refund();
    }

}
