package ru.billing.sync;

public class U1901Main {
    public static void main(String[] args) {
        U1901Bank bankMain = new U1901Bank(); // создание экземпляра класса U1901Bank
        U1901Thread threadOne = new U1901Thread(bankMain, 100, 2000); // создание экземпляра класса U1901Thread
        threadOne.setName("Thread ONE"); // задаём имя потоку
        threadOne.setPriority(Thread.MAX_PRIORITY); // задаём максимальный приоритет
        threadOne.start(); // запускаем поток

        // повторяем пункты
        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);
        threadTwo.setName("Thread TWO");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

    }
}
