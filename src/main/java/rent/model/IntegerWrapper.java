package rent.model;

import rent.menu.CustomDescription;
import java.io.Serializable;
import java.util.Objects;

public class IntegerWrapper implements Comparable<IntegerWrapper>, Serializable {
    private static final long serialVersionUID = 1L;
    private final Integer value;
    private CustomDescription customDescription;

    public CustomDescription getCustomDescription() {
        return customDescription;
    }

    public void setCustomDescription(CustomDescription customDescription) {
        this.customDescription = customDescription;
    }

    public IntegerWrapper(Integer value) {
        this.value = value;
    }

    public IntegerWrapper(Integer value, CustomDescription customDescription) {
        this.value = value;
        this.customDescription = customDescription;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(IntegerWrapper o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return ""+ value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // проверка одинаковых ссылок
        if (o == null || getClass() != o.getClass() ) return false; //проверка на null и соответствие классу
        IntegerWrapper that = (IntegerWrapper) o; //приведение одного объекта к классу другого объекта
        return value.equals(that.value) && isEqual(customDescription, that.customDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, customDescription);
    }

    private boolean isEqual(CustomDescription a, CustomDescription b) {
        return a == null ? b == null : a.equals(b);
        /*
        if (a == null) {
            return b == null;
        }
        return a.equals(b);*/
    }

    public IntegerWrapper sum(IntegerWrapper value) {
        return new IntegerWrapper(this.value + value.getValue());
    }
}