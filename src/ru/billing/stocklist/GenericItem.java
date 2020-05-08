package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    private static int currentID; // поле, хранящее максимальный назначенный ID товара в текущей сессии
    protected int id; // ID товара
    protected String name; // наименование товара
    protected float price; // цена товара
    protected GenericItem analog; // аналог товара по id
    protected Category category = Category.GENERAL; // категория товара // GENERAL - по умолчанию

    // конструктор №1
    public GenericItem(String tempName, float tempPrice, Category tempCategory) {
        id = currentID++;
        name = tempName;
        price = tempPrice;
        category = tempCategory;
    }

    // конструктор №2
    public GenericItem(String tempName, float tempPrice, GenericItem tempAnalog) {
        id = currentID++;
        name = tempName;
        price = tempPrice;
        analog = tempAnalog;
    }

    // конструктор №3
    public GenericItem() {
        id = currentID++;
    }

    public int getId() {
        return id;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String toString() { // преобразуем в строку
        return "---ID: " + id + " ---Name: " + name + " ---Price: " + price + " ---Category: " + category;
    }

    public static int getCurrentID() {
        return currentID;
    }
}
