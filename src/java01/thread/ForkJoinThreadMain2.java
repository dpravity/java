package java01.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinThreadMain2 {
    // 스레드풀을 생성
    static final ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L;
        long to   = 100_000_000L;

        SumTask task = new SumTask(from, to);

        // elapsed time check
        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);

        System.out.println("Elapsed time(4 Core):"+(System.currentTimeMillis()-start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();

        result = 0L;
        // 시작 시간 초기화
        start = System.currentTimeMillis();
        for(long i=from;i<=to;i++){
            result += i;
        }

        System.out.println("Elapsed time(1 Core):"+(System.currentTimeMillis()-start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
    }
}

class SumTask extends RecursiveTask<Long> {
    long from;
    long to;

    SumTask(long from, long to) {
        this.from = from;
        this.to    = to;
    }

    public Long compute() {
        long size = to - from;

        // 더할 숫자가 5개 이하면
        if(size <= 5){
            return sum(); // 숫자의 합을 반환
        }

        // 범위를 반으로 나눠서 두 개의 작업을 생성
        // 분할 정복 알고리즘
        long half = (from+to)/2;
        SumTask leftSum  = new SumTask(from, half);
        SumTask rightSum = new SumTask(half+1, to);

        leftSum.fork();

        return rightSum.compute() + leftSum.join();
    }

    /**
     * from~to의 모든 숫자를 더한 결과를 반환
     * @return
     */
    long sum() {
        long tmp = 0L;
        for(long i=from;i<=to;i++){
            tmp += i;
        }
        return tmp;
    }
}
