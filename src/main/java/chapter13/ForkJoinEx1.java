package chapter13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
  public static final ForkJoinPool pool = new ForkJoinPool();

  public static void main(String[] args) {

    long from = 0L, to = 100_000_000L;

    SumTask sumTask = new SumTask(from, to);

    long start = System.currentTimeMillis();
    Long result1 = pool.invoke(sumTask);
    System.out.println("Elapsed time(ForkJoinPool) : " + (System.currentTimeMillis() - start));
    System.out.printf("sum of %d to %d = %d \n", from, to, result1);

    start = System.currentTimeMillis();
    long result2 = 0;
    for (long i = from; i <= to; i++) {
      result2 += i;
    }
    System.out.println("Elapsed time(1 core) : " + (System.currentTimeMillis() - start));
    System.out.printf("sum of %d to %d = %d \n", from, to, result1);

  }
}

class SumTask extends RecursiveTask<Long> {
  private long from;
  private long to;

  public SumTask(long from, long to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public Long compute() {
    long size = to - from + 1;

    if (size <= 5) {
      return sum();
    }

    long half = (from + to) / 2;

    SumTask leftTask = new SumTask(from, half);
    SumTask rightTask = new SumTask(half + 1, to);

    rightTask.fork();

    return leftTask.compute() + rightTask.join();
  }

  public Long sum() {
    long temp = 0L;
    for (long i = from; i <= to; i++) {
      temp += i;
    }
    return temp;
  }

}
