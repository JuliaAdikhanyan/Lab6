package ru.billing.exceptions;

// исключение, выбрасываемое методом addItem класса
public class ItemAlreadyExistsException extends Exception {
    private String error;

    // конструктор с параметром
    public ItemAlreadyExistsException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }


}
