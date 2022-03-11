package com.beloved;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test1 {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                log.debug("t1 run");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                log.debug("t2 run");
            }
        }, "t2").start();
    }

}
