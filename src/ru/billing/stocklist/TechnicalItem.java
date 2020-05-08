package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {

    private short warrantyTime; // гарантийный срок товара

    public TechnicalItem(String tempName, float tempPrice, TechnicalItem tempAnalog, short tempWarrantyTime) {
        super(tempName, tempPrice, tempAnalog);
        warrantyTime = tempWarrantyTime;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString() + " ---WarrantyTime: " + warrantyTime + " days";
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }
}

