package com.beloved;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程
 */
@Slf4j
public class CreateThread {

    /**
     * Thread直接创建
     */
    @Test
    public void test01() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.debug("t1 run");
            }
        };
        t1.setName("t1");
        t1.start();

        // =================================

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                log.debug("t2 run");
            }
        };
        t2.start();

        // =================================

        Thread t3 = new Thread(() -> log.debug("t3 run"));
        t3.setName("t3");
        t3.start();

        log.debug("main log");
    }

    /**
     *  使用 Runnable 配合 Thread
     *  吧线程和任务（要执行的代码块）分开
     *      Thread：线程
     *      Runnable：任务
     */
    @Test
    public void test02() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                log.debug("t1 run");
            }
        };
        Thread t1 = new Thread(run1, "t1");
        t1.start();

        // =================================

        Runnable run2 = () -> log.debug("t2 run");
        Thread t2 = new Thread(run2, "t2");
        t2.start();

        log.debug("main run");
    }

    /**
     * FutureTask 配合 Thread
     *      可以处理有返回值的情况
     */
    @Test
    public void test03() throws ExecutionException, InterruptedException {

        //          返回值类型
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("t1 run");

                // 阻塞 1s
                Thread.sleep(1000);

                return 100;
            }
        });

        Thread t1 = new Thread(task, "t1");

        t1.start();

        /*
         * task.get()
         *   主线程运行到这里会阻塞等待，直到返回具体结果
         */
        log.debug("t1 线程返回结果：{}", task.get());

        log.debug("main run");
    }


    @Test
    public void test04() {
        System.out.println(System.getProperties());
    }
}
