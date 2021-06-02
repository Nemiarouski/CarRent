package rent.model;

import java.io.Serializable;
import java.util.Objects;

public class IntegerWrapper implements Comparable<IntegerWrapper>, Serializable {
    private static final long serialVersionUID = 1L;
    private final Integer value;

    public IntegerWrapper(Integer value) {
        this.value = value;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerWrapper that = (IntegerWrapper) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}