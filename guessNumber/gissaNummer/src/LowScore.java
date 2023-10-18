import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowScore {

    //lista för att spara antal gissningar
    private List<Integer> lowScores = new ArrayList<>();

    //metod för att kolla om ett resultat kvalificerar för low score-listan
    public boolean qualifiesForLowScore(int score) {
        return lowScores.size() < 5 || score < lowScores.get(lowScores.size() - 1);
    }

    //metod för att uppdatera low score-listan
    public void updateLowScores(int score) {
        lowScores.add(score);
        Collections.sort(lowScores);

        //Om listan innehåller mer än 5 resultat, ta bort det sista (endast topp 5 ska sparas)
        if (lowScores.size() > 5) {
            lowScores.remove(lowScores.size() - 1);
        }
    }

    //metod för att hämta low score-listan
    public List<Integer> getLowScores() {
        return lowScores;
    }
    //metod för att kolla om low score är full
    public boolean isScoreboardFull() {
        return lowScores.size() >= 5;
    }
}
