package by.itstep.goutor.javalesson.lesson44.controller;

import by.itstep.goutor.javalesson.lesson44.model.Clicker;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread(); // Для получении ссылки на главный поток
        // т.к оно выполняется в майне(т.е. для получения ссылки из кодда)
        mainThread.setPriority(Thread.MAX_PRIORITY);


        Clicker clicker1 = new Clicker(Thread.NORM_PRIORITY + 3);
        Clicker clicker2 = new Clicker(Thread.NORM_PRIORITY - 3);

        clicker1.start();
        clicker2.start();

        TimeUnit.SECONDS.sleep(5);

        clicker1.stop();
        clicker2.stop();

//        clicker1.getThread().join();
//        clicker2.getThread().join();

        System.out.println("Clicker 1: " + clicker1.getClick()
                + "\nClicker 2: " + clicker2.getClick());
    }
}
