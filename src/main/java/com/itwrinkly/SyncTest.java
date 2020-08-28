package com.itwrinkly;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author majunzhe
 * @created 2020/1/15 下午5:24
 */
public class SyncTest {

    public static void main(String[] args) throws InterruptedException {
        int tcnt = 20;
        int cnt = 10000;
        int sync = 0;

        if (args.length > 1) {
            tcnt = Integer.parseInt(args[0]);
            cnt = Integer.parseInt(args[1]);
            sync = Integer.parseInt(args[2]);
        }

        final int ftcnt = tcnt;
        final int fcnt = cnt;
        final int fsync = sync;

        ExecutorService executorService = Executors.newFixedThreadPool(ftcnt);
        CountDownLatch countDownLatch = new CountDownLatch(ftcnt);
        AtomicLong total = new AtomicLong(0);
        Test t = new Test();

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < ftcnt; i++) {
            executorService.submit(() -> {
                long start = System.currentTimeMillis();
                for (int j = 1; j <= fcnt; j++) {
                    if (fsync == 0) {
                        t.test2();
                    } else {
                        t.test1();
                    }

                    if (j % 10000 == 0) {
                        long cost = System.currentTimeMillis() - start;
                        total.addAndGet(cost);
//                        System.out.println(String.format("线程：%s, 执行次数: %d, 耗时：%d, 平均耗时：%f", Thread.currentThread().getName(), j, cost, (double) cost / j));
                    }
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println(String.format("线程：%s, 执行次数: %d, 所有线程累加耗时：%d, 平均耗时：%f， 总耗时: %d", Thread.currentThread().getName(),
                cnt * tcnt, total.get(), (double) total.get() / (cnt * tcnt), System.currentTimeMillis() - start1));

//        if (fsync == 0) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt * tcnt; i++) {
            t.test2();
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format("线程：%s, 执行次数: %d, 耗时：%d, 平均耗时：%f", Thread.currentThread().getName(),
                cnt * tcnt, cost, (double) cost / (cnt * tcnt)));
//        }

        System.exit(0);
    }

    private static class Test {

        synchronized void test1() {
            double d = 12390123.1293012 / 1239123.1290 + 123.123901 * 12390.12390 + 1239.19023 * 12390 * 12309103.12390123;

            String s1 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s12 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s13 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s14 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s15 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s16 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s17 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s18 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s19 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s10 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s11 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s122 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s133 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s144 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s155 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s166 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s177 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");

            double d1 = 12390123.1293012 / 1239123.1290 + 123.123901 * 12390.12390 + 1239.19023 * 12390 * 12309103.12390123;
        }

        void test2() {
            double d = 12390123.1293012 / 1239123.1290 + 123.123901 * 12390.12390 + 1239.19023 * 12390 * 12309103.12390123;

            String s1 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s12 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s13 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s14 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s15 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s16 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s17 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s18 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s19 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s10 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s11 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s122 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s133 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s144 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s155 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s166 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");
            String s177 = String.format("%s %s %s", "123980123", "a90123i10283mno 03u8e2j", "123908102j9jd121");

            double d1 = 12390123.1293012 / 1239123.1290 + 123.123901 * 12390.12390 + 1239.19023 * 12390 * 12309103.12390123;
        }
    }
}
