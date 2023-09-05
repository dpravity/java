package java01.ecommerce.member;

import java01.ecommerce.cart.Cart;

public class Member {

    String name;
    int money = 1000;
    Cart cart;

    public Member(){
        this.cart = new Cart();
    }

    public Cart getCart(){
        return this.cart;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney(){
        return this.money;
    }
}
