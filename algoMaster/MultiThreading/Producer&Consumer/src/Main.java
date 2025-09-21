package src;

import java.util.LinkedList;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;





class Resource{
    private Queue<Integer> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    int size = 5;

    public void produce(int x) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() ==size) {
                System.out.println(Thread.currentThread().getName() + ": Waiting for " + size + " elements");
                notFull.await();
            }
            queue.add(x);
            System.out.println("Produced "+x);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try{
            while(queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + ": Waiting for " + size + " elements");
                notEmpty.await();
            }
            System.out.println("Consumed "+queue.poll());
            notFull.signal();
        }finally {
            lock.unlock();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(int i=0;i<3;i++){
            executor.submit(()->{
                Random random = new Random();
                for(int j=0;j<10;j++) {
                    int x = random.nextInt(100);
                    try {
                        resource.produce(x);
                    } catch (InterruptedException e) {
                        System.out.println("Nothing happend, shhh!");
                    }
                }
            });
        }

        for(int i=0;i<3;i++){
            executor.submit(()->{
                for(int j=0;j<10;j++) {
                    try {
                        resource.consume();
                    } catch (InterruptedException e) {
                        System.out.println("Nothing happend, shhh!");
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }catch (InterruptedException e) {
            System.out.println("Nothing happend, shhh!");
        }
    }
}
