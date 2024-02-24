package packages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Save {

    private static boolean fileExists() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
            reader.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void CreateFile() {
        if (fileExists()) return;
        

        try {
            PrintWriter writer = new PrintWriter("scores.txt", "UTF-8");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save in file 3 best scores
    public static void saveScore(int score) {
        int[] scores = loadScores();


        if (scores == null) {
            scores = new int[3];
            scores[0] = score;
        } else {
            for (int i = 0; i < scores.length; i++) {
                if (score < scores[i] || scores[i] == 0) {
                    int temp = scores[i];
                    scores[i] = score;
                    score = temp;
                }
            }
        }
        saveScores(scores);
    }
    
    private static void saveScores(int[] scores) {
        try {
            PrintWriter writer = new PrintWriter("scores.txt", "UTF-8");
            for (int i = 0; i < scores.length; i++) {
                writer.println(scores[i]);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load 3 best scores from file

    public static int[] loadScores() {
        int[] scores = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("scores.txt"));
            String line = reader.readLine();
            scores = new int[3];
            int i = 0;
            while (line != null) {
                scores[i] = Integer.parseInt(line);
                i++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Scores loaded: " + scores[0] + " " + scores[1] + " " + scores[2]);
        return scores;
    }


    
}
