import java.util.*;
import java.util.Random;
/*
 * This class is responsible for storing all the scores, and sorting them too.
 * 
 * @author Yameen Abba, Stanley Chan 
 * @version (a version number or a date)
 */
public class Scores
{
    public static ArrayList<PlayerScore> array = new ArrayList<PlayerScore>();

    public Scores()
    {
        sortScores();
    }

    public ArrayList<PlayerScore> getScores() {
        return array;
    }

    /*
     * The mergesort method is used to sort the highscores of the players in the game, 
     * stored in an arraylist. Lowest to highest.
     */
    public static void sortScores()
    {
        quicksort(array);
    }
    public static int partition(ArrayList<PlayerScore> a, int lo, int hi)
    {
        int i = lo; 
        int j = hi + 1;
        while (true) {
            while (a.get(++i).getScore() < a.get(lo).getScore())  // Find item on left to swap
                if (i == hi) break; 
            while (a.get(--j).getScore() > a.get(lo).getScore()) 
                if (j == lo) break;

            if (i >= j) break;  // Check if pointers cross
            PlayerScore tempI = new PlayerScore(a.get(i).getName(), a.get(i).getScore());
            PlayerScore tempJ = new PlayerScore(a.get(j).getName(), a.get(j).getScore());

            a.set(i, tempJ);
            a.set(j, tempI);
        } 
        PlayerScore tempLo = new PlayerScore(a.get(lo).getName(), a.get(lo).getScore());
        PlayerScore tempJ = new PlayerScore(a.get(j).getName(), a.get(j).getScore());
        a.set(lo, tempJ);
        a.set(j, tempLo);
        return j;  // Return index of item now know to be in place
    }

    public static void quicksort(ArrayList<PlayerScore> a)
    {
        quicksort(a, 0, a.size() - 1); 
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void quicksort(ArrayList<PlayerScore> a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); 
        quicksort(a, lo, j-1); 
        quicksort(a, j+1, hi);
    }
}