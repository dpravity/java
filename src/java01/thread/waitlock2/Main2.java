package java01.thread.waitlock2;


/**
 * synchronized 개선 방식
 * Lock 과 Condition 을 이용한 동기화
 * 동시성 제어 시 공유/베타/낙관 적인 lock
 * ReentrantLock : 재진입 가능한 lock. 가장 일반적인 베타 lock
 * ReentrantReadWriteLock : 읽기에는 공유적, 쓰기에는 배타적인 lock
 * StampedLock : ReentrantReadWriteLock 에 낙관적인 lock 기능을 추가
 *
 * Lock : 잠금
 * unLock : lock 해지
 * isLocked : lock 인지 확인
 */
public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Table2 table =  new Table2(); // 여러 스레드 공유하는 객체

        new Thread(new Cook2(table), "COOK-1").start();
        new Thread(new Customer2(table, "도넛"), "CUSTOMER-1").start();
        new Thread(new Customer2(table, "버거"), "CUSTOMER-2").start();

        // 0.1초 후에 강제종료
        Thread.sleep(5000);
        System.exit(0);
    }

}
