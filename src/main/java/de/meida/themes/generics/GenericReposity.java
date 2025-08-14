package de.meida.themes.generics;
import java.util.List;

public interface GenericReposity<T, ID>{

    T findById(ID id);
}

class CRepoIml implements  GenericReposity<String, Long> {


    @Override
    public String findById(Long id) {
        return "";
    }
}

class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
        //value  = new T();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }



    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>(42);
        integerBox.setValue(75);
        GenericBox<Double> doubleGenericBox = new GenericBox<>(25D);
        GenericBox<Number> numberGenericBox = new GenericBox<>(217.0);

        BoxUtils.readValue(numberGenericBox);
        BoxUtils.readValue(doubleGenericBox);

        BoxUtils.setValue(integerBox);
        BoxUtils.setValue(numberGenericBox);

    }
}

class BoxUtils {
    public static void readValue(GenericBox<? extends Number> box) {
        //box.setValue(42);
        System.out.println(box.getValue());
    }
    public static void setValue(GenericBox<? super Integer> box) {
        box.setValue(42);
        //Integer i = box.getValue();
    }

    public static <T> void setGenricValue(GenericBox<? super T> box, T value) {
        box.setValue(value);
    }

    public static <T extends Comparable<T>> T min(List<T> values) {
        T min = values.get(0);
        for (T value : values) {
            if(value.compareTo(min) < 0){
                min = value;
            }
        }
        return min;
    }

}
