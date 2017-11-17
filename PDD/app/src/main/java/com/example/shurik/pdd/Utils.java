package com.example.shurik.pdd;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.shurik.pdd.users_PDD.UserPDD;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;
import java.util.List;

//import static com.example.shurik.pdd.Utils.updateUserPDD;

/**
 * Created by shurik on 11.11.2017.
 */

public class Utils {

    private static final String USER_PDD_ENTITY = "users_pdd_entity";
    private static final String USER_PDD_REMEMBER = "users_pdd_remember";
    private static final String USERLIST = "user_list";
    private static final String USER_PREFIX = "USER_";


    public static void saveUsersPDD(Context context, List<UserPDD> listUsersPDD, boolean remember, UserPDD currentUser){

        // инициализируем общие объекты для сохранения настроек
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PDD_ENTITY, Context.MODE_PRIVATE);
        SharedPreferences.Editor    editor  = sharedPreferences.edit();

        Gson gson   = new Gson();

        // создадим массив с логинами всех пользователей
        // и сохраним в файле
        String [] users = new String[listUsersPDD.size()];

        int iter = 0;
        for (UserPDD userPDD: (ArrayList<UserPDD>) listUsersPDD) {
            users[iter++]  = userPDD.getLogin();
            updateUserPDD(editor, gson, userPDD);
        }

        String json = gson.toJson(users);

        editor.putString(USERLIST, json);

        if (remember == true) {

            json    = gson.toJson(currentUser.getLogin());

        } else {

            json    = gson.toJson("");

        }

        editor.putString(USER_PDD_REMEMBER, json);

        editor.commit();

    }

    private static final void updateUserPDD(SharedPreferences.Editor editor, Gson gson, UserPDD userPDD){

        String json = gson.toJson(userPDD);
        editor.putString(USER_PREFIX + userPDD.getLogin(), json);

    }

    public static List<UserPDD> loadUsersPDD(Context context){

        ArrayList<UserPDD> result = new ArrayList<UserPDD>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PDD_ENTITY, Context.MODE_PRIVATE);
        Gson gson   = new Gson();

        String json = sharedPreferences.getString(USERLIST, "");

        String[] users = null;

        if ( !json.isEmpty())
            users =  gson.fromJson(json, String[].class);

        if (!(users == null)) {
            for (String login : users) {
                json = sharedPreferences.getString(USER_PREFIX + login, "");
                result.add(gson.fromJson(json, UserPDD.class));
            }
        }

        return result;
    }

    public static String loadCurrentUser(Context context){

        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PDD_ENTITY, Context.MODE_PRIVATE);
        Gson gson   = new Gson();

        String json = sharedPreferences.getString(USER_PDD_REMEMBER, "");

        String login    = "";

        if (!json.isEmpty())
            login   = gson.fromJson(json, String.class);

        return login;
    }

}
