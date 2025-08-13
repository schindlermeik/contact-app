package de.meida.themes.generics;

public class Box<T>{

    private T value;
    private T[] array;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Box<String> bs = new Box<>("Hallo");
        bs.setValue("Susi");
    }
}
