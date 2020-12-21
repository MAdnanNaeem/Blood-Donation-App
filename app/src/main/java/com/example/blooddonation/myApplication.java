package com.example.blooddonation;

import android.app.Application;

import java.util.ArrayList;

public class myApplication extends Application
{
    public static ArrayList<Person> people;
    @Override
    public void onCreate()
    {
        super.onCreate();
        people = new ArrayList<>();
        people.add(new Person("Adnan Naeem","0+","Changa Manga","03035455558"));
        people.add(new Person("Arslan Naeem","B+","Dubai","03012133338"));
        people.add(new Person("M Farooq ","0+","Narmal Ki","0306080045"));
        people.add(new Person("Naeem Shafi","AB+","Dubai","03334444562"));

    }
}
