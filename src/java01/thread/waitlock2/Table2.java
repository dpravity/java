package java01.thread.waitlock2;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Table2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCustomer = lock.newCondition();

    String[] dishNames = {"도넛"};
//    String[] dishNames = {"도넛", "도넛", "버거"};
    final int MAX_FOOD = 5; // 테이블에 놓을 수 있는 최대 음식의 개수

    private ArrayList<String> dishes = new ArrayList<>();

    // 테이블에 음식 추가
    public void add(String dish){
        lock.lock();
        try {
            // 테이블에 음식 가득 찼으면 추가하지 않는다
            while(dishes.size() >= MAX_FOOD){
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");
                try {
                    // COOK 스레드 대기
                    forCook.await();    //wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            dishes.add(dish);
            // 대기중인 Customer 스레드 깨움
            forCustomer.signal();   //notify();
            System.out.println("Dishes : " + dishes.toString());
        }finally {
            lock.unlock();
        }

    }

    // 테이블에서 음식 제거
    public void eat(String dishName){
        lock.lock();

        String name = Thread.currentThread().getName();

        try {
            while (dishes.size() == 0){
                System.out.println(name + " is waiting");
                try {
                    // Customer 스레드 대기
                    forCustomer.await();    //wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            while (true){
                // 지정된 요리와 일치하는 요리를 테이블에서 제거
                for(int i=0; i<dishes.size(); i++){
                    if(dishName.equals(dishes.get(i))){
                        dishes.remove(i);
                        // COOK 스레드 깨움
                        forCook.signal();   //notify();
                        return;
                    }
                }

                try {
                    System.out.println(name + " is waiting");
                    // 원하는 음식이 없는 Customer 스레드 대기
                    forCustomer.await();    //wait();
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
            }
        } finally {
            lock.unlock();
        }



    }

    public int dishNum(){
        return dishNames.length;
    }

}
