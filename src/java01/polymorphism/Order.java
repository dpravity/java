package java01.polymorphism;

import java.util.Objects;
import java.util.StringJoiner;

public class Order {

    Member buyer;

    public void setBuyer(Member buyer){
        this.buyer = buyer;
    }
    public Member getBuyer(){
        return this.buyer;
    }

    void buy(Product p){
        if(buyer.money < p.price){
            System.out.println("가진 돈이 부족합니다");
        }
        buyer.money = buyer.money - p.price;
        System.out.println(buyer.money);
    }

    void buyCart(){
        for(Product p : buyer.getCart().getProductList()){
            this.buy(p);
        }
    }

    void refund(Product p){
        if(Objects.isNull(buyer.getCart()) == false){
            if(buyer.getCart().getProductList().remove(p)){
                buyer.money += p.price;
                System.out.println(p.productName + " 상품을 반품하였습니다");
            }else{
                System.out.println("반품할 상품이 존재하지 않습니다");
            }
        }else{
            System.out.println("장바구니가 존재하지 않습니다");
        }
    }

    void exchange(Product p){
        if(Objects.isNull(buyer.getCart()) == false){
            System.out.println(p.productName + " 상품을 교환 하였습니다");
        }else{
            System.out.println("교환할 상품이 존재하지 않습니다");
        }
    }

    void bill(){
        int sum = 0;

        if(buyer.getCart().getProductList().isEmpty()){
            System.out.println("구입할 제품이 없습니다");
            return;
        }
        StringJoiner sj = new StringJoiner(",");
        // 총 가격과 목록 생성
        for(int i=0; i < buyer.getCart().getProductList().size(); i++){
            Product p = buyer.getCart().getProductList().get(i);
            sum += p.price;
            sj.add(p.productName);
        }

        System.out.println("구입 물품 목록 : " + sj.toString());
        System.out.println("구입 물품 가격 : " + sum);

    }


}
