package java01.thread.waitlock;

/**
 * 음식점에서 도넛/버거 사려고 줄 서있기
 * 자신 차례가 되었는데 원하는 음식이 나오지 않으면, 다름 사람에게 순서 양보하고 대기 하다가 원하는 음식이 나오면 notify 하고 음식 사감
 *
 * 음식 Dish 를 만들어
 * 테이블 Table 에 추가
 * 요리사 COOK 와
 * 손님 Customer - 음식을 먹는 remove
 *
 */
public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        Table table =  new Table(); // 여러 스레드 공유하는 객체

        new Thread(new Cook(table), "COOK-1").start();
        new Thread(new Customer(table, "도넛1"), "CUSTOMER-1").start();
        new Thread(new Customer(table, "버거"), "CUSTOMER-2").start();

        // 0.1초 후에 강제종료
        Thread.sleep(5000);
        System.exit(0);
    }

}
