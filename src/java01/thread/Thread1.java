package java01.thread;

public class Thread1 extends Thread {

    volatile String var = "";

    public Thread1(String var) {
        this.var = var;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        for(int i=0; i<2000; i++){
            System.out.printf("%s", new String(var));
        }

    }
}
