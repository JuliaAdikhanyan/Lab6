package ru.billing.exceptions;

// исключение, выбрасываемое методом load интерфейса CatalogLoader
public class CatalogLoadException extends Exception {
    private String error;

    // конструктор с параметром
    public CatalogLoadException(ItemAlreadyExistsException e) {
        this.error = e.getError();
    }

    // конструктор с параметром
    public CatalogLoadException(String error) {
        this.error = error;
    }
}
