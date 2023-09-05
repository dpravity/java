package java01.polymorphism;

public class TvMain {

    public static void main(String[] args) {
        Tv tv = new Tv();
        Computer com = new Computer();
        Audio au = new Audio();


        Member buyer = new Member();
        buyer.setName("안원빈");
        buyer.setCart();
        buyer.getCart().getProductList().add(tv);
        buyer.getCart().getProductList().add(com);
        buyer.getCart().getProductList().add(au);
        System.out.println(buyer.money);

        Order order = new Order();
        order.setBuyer(buyer);
        order.buyCart();
        order.refund(com);
        order.exchange(tv);

        order.bill();



    }

}
