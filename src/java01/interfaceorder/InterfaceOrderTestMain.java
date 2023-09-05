package java01.interfaceorder;

public class InterfaceOrderTestMain {

    public static void main(String[] args) {
        Member member = new Member();
        member.order(new B2cOrder());
        member.order(new FnetOrder());
    }
}
