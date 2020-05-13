package ru.billing.client;

import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.ItemCatalog;

import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class CatalogFileLoader implements CatalogLoader {

    private String fileName;


    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ItemCatalog cat) throws IOException {
        try (Scanner s = new Scanner(new FileInputStream(new File(fileName)))) {
            String line;
            while (s.hasNextLine()) {
                line = s.nextLine();
                if (line.length() == 0) {
                    break;
                }
                try {
                    regex(cat, line);
                } catch (ItemAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // чтение данных из текстовых файлов с кодировкой UTF-8
    public void parseUtf8(ItemCatalog cat) throws IOException {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = new String(line.getBytes(StandardCharsets.UTF_8));
                try {
                    regex(cat, string);
                } catch (ItemAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // чтение данных из текстовых файлов с кодировкой WINDOWS-1251
    public void parseWindows1251(ItemCatalog cat) throws IOException {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = new String(line.getBytes("Windows-1251"));
                try {
                    regex(cat, string);
                } catch (ItemAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // общая часть
    private void regex(ItemCatalog cat, String string) throws ItemAlreadyExistsException {
        String[] items = string.split(";");
        String name = items[0];
        float price = Float.parseFloat(items[1]);
        short expires = Short.parseShort(items[2]);
        FoodItem item = new FoodItem(name, price, expires);
        cat.addItem(item);
    }
}
