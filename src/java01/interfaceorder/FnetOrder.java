package java01.interfaceorder;

public class FnetOrder implements OrderService {


    @Override
    public void order() {
        System.out.println("여기는 패넷주문");
    }
}
