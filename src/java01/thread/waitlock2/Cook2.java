package java01.thread.waitlock2;

public class Cook2 implements Runnable {

    private Table2 table;

    Cook2(Table2 table){
        this.table = table;
    }

    @Override
    public void run() {
        while(true){
            // 임의의 요리를 하나 선택해서 table 에 추가한다
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // fall throw
            }
        }
    }
}
