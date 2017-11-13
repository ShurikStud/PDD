package com.example.shurik.pdd.users_PDD;

import android.content.Context;

import com.example.shurik.pdd.Utils;

import java.util.List;

/**
 * Created by shurik on 13.11.2017.
 */
 public final class Login {

    static Login instance = null;

    private List<UserPDD> listUsers;
    private UserPDD currentUser = null;
    Context context;

    private Login(){ Init();} // конструктор делаем приватным - невозможно будет вызвать

    public static Login getInstance(){

        if (instance == null)
            instance = new Login();

        return instance;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void loadUsers(){

        listUsers = Utils.loadUsersPDD(context);

    }

    public void addUser(String name, String login, String password){

        UserPDD newUser = null;
        for (UserPDD user: listUsers ) {

            if(user.getLogin().equals(login)){
                newUser = user;
                break;
            }

        }

        if (newUser == null) {

            newUser = new UserPDD(name, login, password);
            listUsers.add(newUser);

        } else {

            newUser.setName(name);
            newUser.setLogin(login);
            newUser.setPassword(password);

        }

        saveUsers();

    }

    private void saveUsers(){

        Utils.saveUsersPDD(context, listUsers);

    }

    public boolean signin(String login, String password){

        for (UserPDD user: listUsers) {

            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                currentUser = user;
                return true;
            }

        }

        return false;
    }

    private void Init(){
        //TODO необходимо написать инициацию ранее залогиненого пользователя. Сейчвс сделаю заглушку

//        idUser  = 75646;
//        nameUser    = "testUser";
//        passwordUser    = "testPassword";


    }


}
