package java01.ecommerce.bill;

public class Billing {

    public boolean requestPG(){
        System.out.println("PG 결제 호출");
        return responsePG();
    }

    public boolean responsePG(){
        System.out.println("PG 결제 완료");
        return true;
    }

}
