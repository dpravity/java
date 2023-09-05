package java01.ecommerce.order;

public enum OrderType {
    ORDER("주문"),
    CANCEL("주문 취소"),
    REFUND("반품"),
    EXCHANGE("교환"),
    COMPLETE("주문 완료");

    final private String name;
    OrderType(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
