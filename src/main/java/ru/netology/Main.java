package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {
    public static final int MAX_CALL = 60;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> callCentre = new ArrayBlockingQueue<>(10);
        List<Operator> treads = new ArrayList<>();

        Call call = new Call(callCentre);
        call.callStarted();

        treads.add(new Operator("1", callCentre, call));
        treads.add(new Operator("2", callCentre, call));
        treads.add(new Operator("3", callCentre, call));

        for (Operator operator : treads) {
            operator.startWork();
        }

        for (Operator operator : treads) {
            operator.opretorJoin();
        }

        System.out.println("КОЛЦЕНТР завершил работу");
    }
}