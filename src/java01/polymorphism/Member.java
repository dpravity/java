package java01.polymorphism;

import java.util.Objects;

public class Member {

    String name;        // 구매자 이름
    int money = 1000;   // 소유금액

    Cart cart;          // 카트 정보

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }

    void setCart(){
        if(Objects.isNull(cart)){
            Cart cart = new Cart();
            this.cart = cart;
        }
    }

    Cart getCart(){
        return this.cart;
    }



}
