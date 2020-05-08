package ru.billing.sync;

public class U1901Thread extends Thread {
    private U1901Bank bankWork;
    private int intTrans;
    private long lngSleep;

    // конструктор
    public U1901Thread(U1901Bank tempBanWork, int tempIntTrans, long tempLngSleep) {
        bankWork = tempBanWork;
        intTrans = tempIntTrans;
        lngSleep = tempLngSleep;
    }

    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }

    public U1901Bank getBankWork() {
        return bankWork;
    }

    public void setBankWork(U1901Bank bankWork) {
        this.bankWork = bankWork;
    }

    public int getIntTrans() {
        return intTrans;
    }

    public void setIntTrans(int intTrans) {
        this.intTrans = intTrans;
    }

    public long getLngSleep() {
        return lngSleep;
    }

    public void setLngSleep(long lngSleep) {
        this.lngSleep = lngSleep;
    }
}
