package data;

import java.util.Objects;

public class BookingUser {

    private String user_login;
    private String user_password;

    public BookingUser(String user_login, String user_password) {
        this.user_login = user_login;
        this.user_password = user_password;
    }

    public BookingUser(){

    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "bookingUser{" +
                "user_login='" + user_login + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingUser that = (BookingUser) o;
        return Objects.equals(user_login, that.user_login) && Objects.equals(user_password, that.user_password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_login, user_password);
    }
}
