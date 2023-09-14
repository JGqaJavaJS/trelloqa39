package dto;

import java.util.Objects;

public class UserDtoWith {

    String password;
    String email;

//    public UserDtoWith(String password, String email) {
//        this.password = password;
//        this.email = email;
//    }

//    public UserDtoWith() {
//    }

    public UserDtoWith withEmail(String email) { // setter
        this.email = email;
        return this; // new UserDtoWith
    }

    public UserDtoWith withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserDtoWith{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) { // compare // Comparable // comparator
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDtoWith that = (UserDtoWith) o;
        return Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override // HashSet  HashMap
    public int hashCode() {
        return Objects.hash(password, email);
    }
}
