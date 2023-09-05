package java01.thread;

public class Thread2Main {

    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("group1");
        ThreadGroup group2 = new ThreadGroup("group2");

        // todo
        ThreadGroup subGroup1 = new ThreadGroup(group1, "subGroup1");
        group1.setMaxPriority(10);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    // 1초씩 멈춤
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(group1, r, "th1").start();
        new Thread(subGroup1, r, "th2").start();
        new Thread(group2, r, "th3").start();

        System.out.println("List Thread Group : " + main.getName());
        System.out.println("Activate Thread Group : " + main.activeGroupCount());
        System.out.println("Activate Thread : " + main.activeCount());



//        Thread1 t1 = new Thread1("-");
//        Thread1 t2 = new Thread1("|");
//
//        t1.setPriority(1);
//        t2.setPriority(10);
//
//        System.out.println("priority t1 : " + t1.getPriority());
//        System.out.println("priority t2 : " + t2.getPriority());
//
//        t1.start();
//        t2.start();

    }

}
