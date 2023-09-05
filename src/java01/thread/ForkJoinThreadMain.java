package java01.thread;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveAction : 반환값이 없는 작업을 구현할 때 사용
 * RecursiveTask : 반환값이 있는 작업을 구현할 때 사용
 *
 * fork() 비동기 메소드 : 해당 작업을 스레드 풀의 작업 큐에 넣는다
 * join() 동기 메소드 : 해당 작업의 수행이 끝날 때까지 기다렸다가 수행이 끝나면 그 결과를 반환한다
 *
 * <p>
 * 1. compute() 에 작업을 수행하기 위한 코드 작성
 * 2. 스레드풀과 수행할 작업 생성
 * 3. invoke() 로 작업 시작
 * <p>
 *
 * 스레드 풀은 지정된 수의 스레드를 생성해서 미리 만들어 놓고 반복해서 재사용할 수 있게 한다
 * 장점
 * - 스레드를 반복해서 생성하지 않아도 된다
 * - 너무 많은 스레드가 생성되어 성능이 저하되는 것을 방지한다
 * 스레드 풀은 스레드가 수행해야하는 작업이 담긴 큐를 제공하며, 각 스레드는 자신의 작업 큐에 담긴 작업을 순서대로 처리한다
 *
 * volatile - 캐싱되지 않고 읽고 쓸 때 무조건 메인 메모리를 참조하게 된다.
 * 하나의 쓰레드가 쓰고, 다른 여러 개의 쓰레드가 읽는 시나리오에서 유용하다.
 * 여러 개의 쓰레드가 동시에 읽고/쓰는 시나리오에선 synchronized 블럭을 쓰거나 Atomic* 클래스 시리즈를 써야 한다.
 *
 * transient - 직렬화 시 스킵된다. 더 정확한 의미론 메모리 안에서만 사용되어야 함을 뜻하는 키워드다.
 */
public class ForkJoinThreadMain {
    public static void main(String[] args) {
        YesReturn y = new YesReturn(6);
        Integer result = y.invoke();
        System.out.println("result : " + result);
    }

}

/**
 * RecursiveAction : 반환값이 없는 작업을 구현할 때 사용
 */
class NoReturn extends RecursiveAction {

    @Override
    protected void compute() {

    }
}

/**
 * RecursiveTask : 반환값이 있는 작업을 구현할 때 사용
 */
class YesReturn extends RecursiveTask<Integer> {
    final int n;

    YesReturn(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1){
            return n;
        }
        // n - 1, n - 2 의 계산을 분리
        YesReturn f1 = new YesReturn(n - 1);
        f1.fork();
        YesReturn f2 = new YesReturn(n - 2);
        return f2.compute() + f1.join();
    }

}
