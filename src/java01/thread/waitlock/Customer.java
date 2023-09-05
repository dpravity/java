package java01.thread.waitlock;

public class Customer implements Runnable {

    private Table table;
    private String food;

    Customer(Table table, String food){
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // fall throw
            }
            String name = Thread.currentThread().getName();

            table.eat(food);
            System.out.println(name + " ate a " + food);
        }
    }

//    private boolean eatFood() {
//        return table.remove(food);
//    }

}
