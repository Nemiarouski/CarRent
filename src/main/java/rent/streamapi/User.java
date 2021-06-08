package rent.streamapi;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private DataTime bitrhDay;

    public User() {
    }
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String firstName, String lastName, int age, DataTime bitrhDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bitrhDay = bitrhDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DataTime getBitrhDay() {
        return bitrhDay;
    }

    public void setBitrhDay(DataTime bitrhDay) {
        this.bitrhDay = bitrhDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", bitrhDay=" + bitrhDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(bitrhDay, user.bitrhDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, bitrhDay);
    }
}