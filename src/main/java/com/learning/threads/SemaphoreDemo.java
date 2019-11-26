package com.learning.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    Semaphore binary = new Semaphore(1);
 
    public static void main(String args[]) {
        final SemaphoreDemo test = new SemaphoreDemo();
        
        new Thread(){
            @Override
            public void run(){
              test.mutualExclusion();
            }
        }.start();
     
        new Thread(){
            @Override
            public void run(){
              test.mutualExclusion();
            }
        }.start();
     
    }
 
    private void mutualExclusion() {
        try {
            binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }
 
}


