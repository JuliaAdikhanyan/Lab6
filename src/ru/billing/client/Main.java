package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;
import ru.billing.stocklist.TechnicalItem;

import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        GenericItem[] items = new GenericItem[]{

          new GenericItem("book", 70.70f, Category.PRINT),
          new GenericItem("newBook", 220.20f, Category.PRINT),
          new GenericItem("dress", 8080.80f, Category.DRESS),
          new GenericItem("newDress", 2000.00f, Category.DRESS),
          new GenericItem("glass", 110.10f, Category.GENERAL),
          new GenericItem("newGlass", 330.30f, Category.GENERAL),
          new FoodItem("milk", 50.50f, (short) 30),
          new FoodItem("newMilk", 150.50f, (short) 10),
          new TechnicalItem("phone", 3330.30f, null, (short) 900),
          new TechnicalItem("newPhone", 30000.00f, null, (short) 365)};

        // новый каталог
        ItemCatalog newCatalog = new ItemCatalog();
        for (GenericItem item : items) {
            try {
                newCatalog.addItem(item);
            } catch (ItemAlreadyExistsException e) {
                System.out.println(e.getError());
            }
        }

        long begin = new Date().getTime();

        for (int i = 0; i < 100000; i++) {
            newCatalog.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            newCatalog.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        // загружаем товары в каталог с помощью объекта-загрузчика
        CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(newCatalog);
        } catch (CatalogLoadException | IOException e) {
            e.printStackTrace();
        }
        newCatalog.printItems();


        CatalogFileLoader fileLoader = new CatalogFileLoader("D:\\Java\\stocklist.txt");
        try {
            fileLoader.load(newCatalog);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        newCatalog.printItems();
    }
}
