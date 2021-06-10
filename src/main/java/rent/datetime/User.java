package rent.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private LocalDateTime lastLogin;

    public User() {
    }
    public User(String firstName, String lastName, LocalDate birthDay, LocalDateTime lastLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
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

    public int getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", lastLogin=" + lastLogin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy--HH:mm:ss")) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(birthDay, user.birthDay) && Objects.equals(lastLogin, user.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDay, lastLogin);
    }
}