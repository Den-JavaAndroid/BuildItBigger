package com.example.jokelib;

import java.util.Random;

public class JokeTelling {
    private  String[] jokes;
    private  Random random;

    public JokeTelling() {
        jokes = new String[3];
        jokes[0] = "Girls are like Internet Domain names, the ones I like are already taken";
        jokes[1] = "I love pressing F5. It's so refreshing";
        jokes[2] = "Knock, knock.";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public  String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
