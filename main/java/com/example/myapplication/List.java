package com.example.myapplication;

import java.util.Random;

public class List {
    static java.util.List<String> LIST;
    public void word(java.util.List<String> list){
            LIST = list;
        return;
    }

    public String get_random_word(){
        Random rand = new Random();
        int range = LIST.size();
        int index = rand.nextInt(range);
        String word = LIST.get(index);
        return word;
    }
}
