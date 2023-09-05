package java01.interfaceorder;

public class B2cOrder implements OrderService {


    @Override
    public void order() {
        System.out.println("여기는 닷컴주문");
    }
}
