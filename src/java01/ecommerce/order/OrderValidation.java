package java01.ecommerce.order;

import java01.ecommerce.member.Member;

public class OrderValidation {

    public boolean validation(Order order){
        System.out.println("주문 검증");
        return true;
    }

    public boolean validation(Order order, Member member){
        System.out.println("주문,회원 검증");
        return true;
    }

}
