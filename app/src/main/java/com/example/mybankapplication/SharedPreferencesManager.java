package com.example.mybankapplication;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mybankapplication.models.Customer;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferencesManager {

    public static final String MY_PREF = "AppPreferences";
    private static SharedPreferencesManager INSTANCE = null;
    private SharedPreferences sharedPreferences;

    //pour transformer une classe en singleton mettre prive
    private SharedPreferencesManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(MY_PREF, 0);
    }

    //ca economise du code c'est un objet partage le singleton est ce que mon objet existe deja cas contraire on la cree
    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new SharedPreferencesManager(context);
        }
        return INSTANCE;
    }

    public void save(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String get(String key) {

        return this.sharedPreferences.getString(key, null);
    }

    public void remove(String key) {

        sharedPreferences.edit().remove(key).apply();
    }

    public void clear() {

        sharedPreferences.edit().clear().apply();
    }

    public void saveCustomer(List<Customer> books, String listKey) {
        Gson gson = new Gson();
        //gson.tojson qui transforme la liste en chaine de caractere
        String booksAsString = gson.toJson(books);
        save(listKey,booksAsString);
    }

    public List<Customer> getCustomer(String listKey){
        List<Customer> booksList = new ArrayList<>();
        Gson gson = new Gson();
        Customer[] books = gson.fromJson(get(listKey), Customer[].class);
        if (books != null){
            booksList = Arrays.asList(gson.fromJson(get(listKey), Customer[].class));
        }
        return  booksList;
    }

    public void addCustomerToList(Customer customer, String listKey){
        ArrayList<Customer> books = new ArrayList<>(getCustomer(listKey));
        remove(listKey);
        books.add(customer);
        saveCustomer(books,listKey);
    }



}
