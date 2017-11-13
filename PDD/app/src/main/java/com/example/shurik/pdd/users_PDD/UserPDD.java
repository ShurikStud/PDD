package com.example.shurik.pdd.users_PDD;

/**
 * Created by shurik on 11.11.2017.
 */

public class UserPDD {

    //private int id;
    private String name;
    private String login;
    private String password;

//    public UserPDD(int id, String name, String login, String password) {
    public UserPDD(String name, String login, String password) {
        //this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() { return password; }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
//        return "UserPDD{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                '}';
        return "UserPDD{" +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
