package com.example.administrator.demos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.demos.R;
import com.example.administrator.demos.util.LogUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemoActivity extends AppCompatActivity {

    public static Object mLockObject = new Object();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //wait
/*        long startTime = System.currentTimeMillis();
        LogUtil.e("thread","线程启动");
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        synchronized (mLockObject){
            try {
                LogUtil.e("thread","主线程等待");
                mLockObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LogUtil.e("thread","等待耗时: "+(System.currentTimeMillis() - startTime));
        LogUtil.e("thread","主线程继续");*/
//==================================================================================================
        //join
/*        Worker worker_1 = new Worker("worker_1");
        Worker worker_2 = new Worker("worker_2");
        worker_1.start();
        LogUtil.e("worker","线程1启动");
        try {
            worker_1.join();
            LogUtil.e("worker","线程2启动");
            worker_2.start();
            worker_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//==================================================================================================
        //yield
/*        YieldThread yieldThread1 = new YieldThread("yield_thread_1");
        YieldThread yieldThread2 = new YieldThread("yield_thread_2");
        yieldThread1.start();
        yieldThread2.start();*/
//==================================================================================================
        ExecutorService executorService = Executors.newSingleThreadExecutor();
/*        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                int result = fibc(20);
                LogUtil.e("result",result+"");
            }
        });*/
//==================================================================================================
/*        Future<Integer> submit1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibc(20);
            }
        });
        try {
            int submit1Result = submit1.get();
            LogUtil.e("result2",submit1Result+"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
//==================================================================================================
/*        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibc(20);
            }
        });
        try {
            executorService.submit(futureTask);
            int futureResult = futureTask.get();
            LogUtil.e("futureResult",futureResult+"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
//==================================================================================================
/*        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
        for(int i = 0;i<5;i++){
            fixedExecutorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    LogUtil.e("fixedExecutorService",Thread.currentThread().getName());
                    return fibc(20);
                }
            });
        }*/
//==================================================================================================
/*        ExecutorService cacheExecutorService = Executors.newCachedThreadPool();
        for(int i = 0;i<10;i++){
            final int finalI = i;
            cacheExecutorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    LogUtil.e("cacheExecutorService", finalI +" "+Thread.currentThread().getName());
                    return fibc(50);
                }
            });
        }*/
//==================================================================================================
/*        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(3);
        scheduleExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LogUtil.e("scheduleExecutorService",Thread.currentThread().getName());
            }
        },0,5, TimeUnit.SECONDS);*/
//==================================================================================================
/*        final CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                copyOnWriteArrayList.add(System.currentTimeMillis()+"");
            }
        },0,2,TimeUnit.SECONDS);
        ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(3);
        ses2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LogUtil.e("ses",copyOnWriteArrayList.size()+"");
            }
        },0,3,TimeUnit.SECONDS);*/
//==================================================================================================
        final ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.put(index+"",index+"");
                index++;
            }
        },0,2,TimeUnit.SECONDS);
        ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(3);
        ses2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LogUtil.e("ses",concurrentHashMap.get(index));
            }
        },0,3,TimeUnit.SECONDS);

    }


/*    static class WaitThread extends Thread{
        @Override
        public void run() {
            try {
                synchronized (mLockObject){
                    Thread.sleep(3000);
                    mLockObject.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
//==================================================================================================
/*    static class Worker extends Thread{

        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogUtil.e("worker","worker in " + getName());
        }
    }*/
//==================================================================================================
/*
    static class YieldThread extends Thread{

        public YieldThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for(int i = 0;i<15;i++){
                if(i == 2){
                    Thread.yield();
                }
                LogUtil.e("yield_thread",getName()+" "+i);
            }
        }

    }
*/
//==================================================================================================
    //斐波那契数列，用作耗时操作。
    private int fibc(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);
    }
//==================================================================================================


}
