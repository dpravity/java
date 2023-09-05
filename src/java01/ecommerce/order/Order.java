package java01.ecommerce.order;

public class Order {


    // todo - 주문
    public void order(){
        System.out.println(OrderType.ORDER.getName());
    }

    // todo - 취소
    public void cancel(){
        System.out.println(OrderType.CANCEL.getName());
    }

    // todo - 반품
    public void refund(){
        System.out.println(OrderType.REFUND.getName());
    }

    // todo - 교환
    public void exchange(){
        System.out.println(OrderType.EXCHANGE.getName());
    }
    // todo - 완료
    public void complete(){
        System.out.println(OrderType.COMPLETE.getName());
    }

}
