package ru.billing.sync;

public class U1901Bank {
    private int intTo; // счёт-получатель
    private int intFrom = 220; // счёт-отправитель

    // перевод средств
    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("\t\t\tBEFORE:" + "\nintFrom: " + intFrom + "\nintTo: " + intTo + "\n" + Thread.currentThread().getName());
        intFrom = intFrom - intTransaction;

        // временная задержка
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intTo = intTo + intTransaction;

        System.out.println("\t\t\tAFTER:" + "\nintFrom: " + intFrom + "\nintTo: " + intTo + "\n" + Thread.currentThread().getName());
    }
}
