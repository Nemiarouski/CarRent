package rent.collections.map;

import java.util.Objects;

public class Key implements Comparable<Key>{
    private Integer id;
    private String serialWord;

    public Key() {
    }
    public Key(int id, String serialWord) {
        this.id = id;
        this.serialWord = serialWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialWord() {
        return serialWord;
    }

    public void setSerialWord(String serialWord) {
        this.serialWord = serialWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return id == key.id && serialWord.equals(key.serialWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialWord);
    }

    @Override
    public int compareTo(Key o) {
        return this.id.compareTo(o.id);
    }
}