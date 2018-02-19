package com.example.shurik.pdd.users_PDD;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by shurik on 19.02.2018.
 */

public class UsersAdapter extends BaseAdapter {

    private Login login;

    public UsersAdapter() {
        this.login = Login.getInstance();
    }

    @Override
    public int getCount() {
        return login.size();
    }

    @Override
    public Object getItem(int i) {
        return login.getUser(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
