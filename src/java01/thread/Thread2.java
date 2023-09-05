package java01.thread;

public class Thread2 implements Runnable {


    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            System.out.println("thread 2");
        }
    }
}
