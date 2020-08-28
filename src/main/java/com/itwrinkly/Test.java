package com.itwrinkly;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Test tt = new Test();
        AtomicLong total = new AtomicLong(0);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    for (int j = 1; j <= 10000; j++) {
                        tt.test2();
                        if (j % 5000 == 0) {
                            long cost = System.currentTimeMillis() - start;
                            total.addAndGet(cost);
                            System.out.println(String.format("thread_id:%s, execut:%d, spend time:%d, avg time:%f", Thread.currentThread().getName(), j, cost, (double)cost / j));
                        }
                    }
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        System.out.println(String.format("total:%d, avg:%f", total.get(), (double)total.get() / 20));
    }

    public synchronized void test1() {
        String.format("cccc%s %s %s %s", "asfdaser43667rhiasdjfnkawe fhi3eioe", "asdf23eas1qw1fdasdf", "adfagklj80pgfvlarpohyejj", "oopvnabcunmetqsk467gdsahlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhia26589fghjjsdjfnkawe fhi66gsh3eioe", "asdf23ea8vfsfdasdf", "adfagkljvla2`fcqrpohyejj", "oopvn04d23abcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rer656hiasdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhi45as12djfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhiasdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rh890tiasdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhia511sdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhia073sdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
    }

    public  void test2() {
        String.format("cccc%s %s %s %s", "asfdaser43667rhiasdjfnkawe fhi3eioe", "asdf23eas1qw1fdasdf", "adfagklj80pgfvlarpohyejj", "oopvnabcunmetqsk467gdsahlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhia26589fghjjsdjfnkawe fhi66gsh3eioe", "asdf23ea8vfsfdasdf", "adfagkljvla2`fcqrpohyejj", "oopvn04d23abcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rer656hiasdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhi45as12djfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhiasdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rh890tiasdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhia511sdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
        String.format("cccc%s %s %s %s", "asfdaser3rhia073sdjfnkawe fhi3eioe", "asdf23easfdasdf", "adfagkljvlarpohyejj", "oopvnabcunmetqskhlodj");
    }
}
