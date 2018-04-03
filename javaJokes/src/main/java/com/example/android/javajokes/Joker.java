package com.example.android.javajokes;

import java.util.Random;

public class Joker {

    private static String joke0 = "Q: How do you make holy water?\n A: Boil the hell out of it! \n";
    private static String joke1 = "Q: What do you call sad coffee?\n A: Despresso. \n";
    private static String joke2 = "Q: What do you call a man with no body and just a nose?\n A: Nobody nose. \n";
    private static String joke3 = "Q: What belongs to you but others use more?\n A: Your name \n";
    private static String joke4 = "Q: What bow can't be tied?\n A: A rainbow! \n";

    private static String[] jokes = {joke0, joke1, joke2, joke3, joke4};


    public static String getJoke(){
        Random random = new Random();
        int index = random.nextInt(jokes.length);

        return jokes[index];
    }
}
