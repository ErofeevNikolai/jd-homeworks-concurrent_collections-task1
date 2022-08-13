package ru.netology;

import java.util.concurrent.BlockingQueue;

public class Operator {
    private String name;
    private BlockingQueue<String> callCentre = null;
    private Call call;
    Thread thread = new Thread(() -> {
        while (call.currentThread() || callCentre.size() != 0) {
            try {
                System.out.println(callCentre.take() + " обработан оператором " + name);
                Thread.sleep(500);

            } catch (InterruptedException e) {
                return;
            }

        }
    });

    Operator(String name, BlockingQueue<String> callCentre, Call call) {
        this.name = name;
        this.callCentre = callCentre;
        this.call = call;
    }

    public void startWork() {
        thread.start();
    }

    public void opretorJoin() throws InterruptedException {
        thread.join();
    }

}

