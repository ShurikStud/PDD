package com.example.shurik.pdd.users_PDD;

/**
 * Created by shurik on 11.11.2017.
 */

public class UserPDD {

    private int id;
    private String name;
    private String login;
    private String password;

    public UserPDD(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "UserPDD{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
