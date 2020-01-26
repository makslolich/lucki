package com.superseven.goose;

import android.content.Context;
import android.content.SharedPreferences;

public class DataTablePreferences {
    private static String twelve_sevens = "twelve_sevens";
    private SharedPreferences preferences;

    public DataTablePreferences(Context context){
        String NAME = "twelve_sevens";
        preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void setData(String data){
        preferences.edit().putString(DataTablePreferences.twelve_sevens, data).apply();
    }

    public String getData(){
        return preferences.getString(twelve_sevens, "");
    }
}
