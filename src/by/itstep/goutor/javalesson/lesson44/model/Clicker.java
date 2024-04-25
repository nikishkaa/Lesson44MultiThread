package by.itstep.goutor.javalesson.lesson44.model;

public class Clicker implements Runnable {
    private volatile boolean running;
    // volatile Все потоки работают только с оригиналом переменной(отмена оптимизаций)
    // Синхронизированный доступ, выполняется атомарное значение
    private Thread thread;
    private long click;


    public Clicker(int priority) {
        running = true;
        click = 0;
        thread = new Thread(this);
        thread.setPriority(priority);
    }

    public void click() {
        click++;
    }


    @Override
    public void run() {
        while (running) {
            click();
        }
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        running = false;
    }

    public long getClick() {
        return click;
    }

    public Thread getThread() {
        return thread;
    }
}
