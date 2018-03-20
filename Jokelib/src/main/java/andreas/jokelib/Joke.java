package andreas.jokelib;

import java.util.Random;

public class Joke {
    private String[] jokes;
    private Random random;

    public Joke() {
        jokes = new String[5];
        jokes[0] = "Hardware: The part of a computer that you can kick!";
        jokes[1] = "There are 10 kinds of people in the world: Those that know binary & those that don't";
        jokes[2] = "Two bytes meet. The first byte asks, 'Are you ill?'" +
                "The second byte replies, 'No, just feeling a bit off.'";
        jokes[3]="Q: how many programmers does it take to change a light bulb?\n" +
                "A: none, that's a hardware problem\n";
        jokes[4]="Unix is user friendly. It's just very particular about who its friends are.\n";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
