import java.util.Random;
import java.util.Scanner;

public class Game{
    
    //private att den inte ska till en annan klass och final för att värdena inte ska ändras
    //minsta värde är 1 och högsta är 100
    private static final int lowestNumber = 1;
    private static final int highestNumber = 100;
    private static final int userInputPlayAgain = 1;
    private static final int userInputExit = 2;
    private static final int userInputScoreboard = 3;

    
    private LowScore lowScore = new LowScore();
    
    

    //public void att loopa genom spelet om man vill spela igen
        public void startGame(){
            Scanner userInput = new Scanner(System.in);
            boolean playAgain = true;
            
                
            //starta själva spelet
            gameAlgorithm();
                //gör en loop om man vill spela igen
                //while-loop för gå tillbaka till meny
                do {
                    
                
                       


                    //efter att man har spelat klart ska meny visas
                    System.out.println("\nMata in 1, 2 eller 3 för att välja alternativ");
                    System.out.println("1. Spela igen");
                    System.out.println("2. Avsluta");
                    System.out.println("3. Scoreboard");
                        
                    //göra variable som sparar useinput från range 1-3
                    int choice = getValidChoice(userInput, userInputPlayAgain, userInputScoreboard );
                    switch (choice){
                        //val 1 ska starta spelet om igen från game algorithm med loop
                        case userInputPlayAgain:
                            gameAlgorithm();
                            break; 
                        //val 2 ska avsluta spelet utan att loopa igem
                        case userInputExit:
                             System.out.println("Tack för den här gången!");
                             System.exit(0);
                             break;
                        // Val 2 ska topplistan av poäng
                        case userInputScoreboard:
                            displayTopScores();
                            break;
                    }
                    
                    //    break;  // gå ut ur loop
                } 
                while (playAgain);
                    
                    
                //Spara user input i variabel, och ändra user input till lowercase
                String playAgainInput = userInput.next().toLowerCase();

                //loop att man ska svara ja eller nej om man vill spela igen.
                while (!(playAgainInput.equals("ja") || playAgainInput.equals("nej"))) {
                    
                    
                    System.out.println("Vill du spela igen (Ja/Nej)? ");
                    
                    playAgainInput = userInput.next().toLowerCase();
                    }   

                
                //if för att kontrollera om man vill spela igen
                if(!playAgainInput.equalsIgnoreCase("ja")){
                    playAgain = false;
                }
                
            
            }   

            
        //inmatning till meny om man skriver något annat än 1, 2 eller 3
        private int getValidChoice(Scanner scanner, int min, int max) {
            int choice = 0;
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print("Ditt val: ");
            
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    
                    if (choice >= min && choice <= max) {
                         validInput = true;
                           }
                           
                    else {
                        System.out.println("Mata in 1, 2 eller 3.");
                            }                        
                        }
        
                else {
                    System.out.println("Mata in 1, 2 eller 3.");
                    scanner.next();  // Consume invalid input
                } 
            }
                    return choice;
        }
    
                

    private void gameAlgorithm(){
        
        //genererar random nummmer
        Random random = new Random();
       
        //sätter range att random nummer ska vara från 1-100 
        int randomNumber  = random.nextInt(highestNumber - lowestNumber + 1) + lowestNumber;

        //räknare för antal gissningar
        int countingGuess = 0;
       
        //Scanner för att få user input, system.in parameter för att få in en keyboard svar från user
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Gissa ett tal mellan " + lowestNumber + " och " + highestNumber);
        System.out.println(randomNumber);
        

        
        //While loop att koden ska fortfarande fråga tal tills man har gissat rätt
        while(true){
            System.out.print("Gissning " + (countingGuess + 1) + ": ");

            //if sats om user input är inte heltal
            if(!userInput.hasNextInt()){
                System.out.println("Du kan bara skriva ett tal med siffror. Försök igen!");
                userInput.next();
                continue;
            }

            int userGuess = userInput.nextInt();

            //if sats för att user input ska vara mellan 1 och 100, ifall om userinput är utanför denna range
            if(userGuess < lowestNumber || userGuess > highestNumber ){
                System.out.println("Gissa ett tal mellan " + lowestNumber + " och " + highestNumber);
                continue;
            }
            


            //if sats om userInput gissning är korrekt
            if (userGuess == randomNumber){
                countingGuess +=1;
                System.out.println("Rätt! Du gissade rätt på " + countingGuess + " försök!"); 
                lowScore.updateTopScores(countingGuess);
                break; //stoppa while loop om gisning är korrekt
                }
            
            //sats if om user input är högre
            else if (userGuess > randomNumber){
                countingGuess += 1;
                System.out.println("Talet är mindre, försök igen.");
                }
            //else if om user input är mindre
            else if (userGuess < randomNumber){
                countingGuess += 1; 
                System.out.println("Talet är högre, försök igen.");
                }        

            //else om allt annat är skriven
            else{
                System.out.println("Du kan bara skriva ett tal med siffror. Försök igen!");
                }
            
        }
        



        
        
    }

    //metod för att visa topplista
    private void displayTopScores() {
        System.out.println("Top Score-lista:");

        for (int i = 0; i < lowScore.getTopScores().size(); i++) {
            System.out.println("Plats " + (i + 1) + ": " + lowScore.getTopScores().get(i) + " gissningar");
        }
    }

}
  


