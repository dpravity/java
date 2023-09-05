package java01.thread;

public class ThreadMain {

    /**
     * start 와 run 차이
     * start : 스레드 실행
     * run : run 메소드 실행
     */
    public static void main(String[] args) {
        Thread1 t1 = new Thread1("-");
        Thread1 t2 = new Thread1("|");
//        Runnable r = new Thread2();
//        Thread t2 = new Thread(r);

        t1.setPriority(1);
        t2.setPriority(10);

        // start : 실행 대기 -> 자기차례 시 실행
        t1.start();
        t2.start();
//        t1.start(); // 두 번째 호출 시 에러 : IllegalThreadStateException
//        t2.start();

//        t1.run();
//        t2.run();

        // synchronized : 동기화 - 내꺼ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ
        // async : 비동기화 - 내꺼인듯 아닌듯?
//        t1.start();
//        for(int i=0; i<200; i++){
//            System.out.printf("%s", new String("|"));
//        }
    }


}
