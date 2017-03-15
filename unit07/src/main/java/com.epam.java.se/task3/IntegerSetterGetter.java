package com.epam.java.se.task3;

import java.util.Random;

/**
 * Created by Мария on 15.03.2017.
 */
public class IntegerSetterGetter extends Thread{
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        try {
            while (run) {
                if (rand.nextBoolean()) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getElement();
            for (int i = 0; i < 1 && number == null; i++) {
                System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait(100);
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
            }
            if (number == null) {
                System.out.println("Поток " + getName() + " не извлек число");
            } else {
                System.out.println("Поток " + getName() + " извлек число " + number);
            }
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}
