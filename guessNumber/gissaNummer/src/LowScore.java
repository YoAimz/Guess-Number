import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowScore {

    //lista scoreboard för att spara antal gissningar
    private List<Integer> topScores = new ArrayList<>();
    //metod för att updatera topplistan av poäng
    public void updateTopScores(int score) {
        topScores.add(score); //addering av lista
        Collections.sort(topScores); //sortering av lista

        // Om topplistan innehåller mer än 5 poäng, ta bort det sista (endast topp 5 ska sparas)
        if (topScores.size() > 5) {
            topScores.remove(topScores.size() - 1); //bara top 5 ska sparas

        }
    }
    // Metod för att hämta topplistan av poäng
    public List<Integer> getTopScores() {
        return topScores;
    }
    
    
}
