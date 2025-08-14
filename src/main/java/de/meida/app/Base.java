package de.meida.app;

public class Base<T> {
    protected T id;

    public Base(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}

