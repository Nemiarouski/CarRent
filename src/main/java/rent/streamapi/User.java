package rent.streamapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private LocalDate birthDay;
    private LocalDateTime lastLogin;

    public User() {
    }
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String firstName, String lastName, LocalDate birthDay, LocalDateTime lastLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = LocalDate.now().getYear() - birthDay.getYear();
        this.birthDay = LocalDate.now().minusYears(age);
        this.lastLogin = lastLogin;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthday) {
        this.birthDay = LocalDate.parse(birthday);
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", bitrhDay=" + birthDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", lastLogin=" + lastLogin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy--HH:mm:ss")) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(birthDay, user.birthDay) && Objects.equals(lastLogin, user.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, birthDay, lastLogin);
    }
}