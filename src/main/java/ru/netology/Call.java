package ru.netology;

import java.util.concurrent.BlockingQueue;

public class Call {
    private BlockingQueue<String> callCentre = null;
    private Thread callTread = new Thread(() -> {
        for (int i = 0; i < Main.MAX_CALL; i++) {
            try {
                callCentre.put("Звонок №" + i);
                System.out.println("поступил звонок №" + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    });

    Call(BlockingQueue<String> callCentre) {
        this.callCentre = callCentre;
    }


    public void callStarted() {
        callTread.start();
    }

    public boolean currentThread() {
        return callTread.isAlive();
    }

}
