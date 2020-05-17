package word_guessing_game;

import java.util.Scanner;

public class WordArray {
    public static String randomWord(){
        String[] words={"java", "python", "ruby", "javascript"};
        return words[(int)(Math.random()*words.length)];
    }
    public static void starredWord(){
        String word = randomWord();
        String[] wordStorage = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordStorage[i]="* ";
        }
        printWordStorage(wordStorage);
        Scanner scan = new Scanner(System.in);
        String in, analyzer="";
        int k=0, m=0;
        while(true){
            System.out.print("Enter a character: ");
            in = scan.nextLine();
            while (true){
                if(analyzer.contains(in)){
                    System.out.println("You cannot use the same character more than once");
                    System.out.print("Enter a character again: ");
                    in = scan.nextLine();
                }
                else {
                    analyzer+=in;
                    break;
                }
            }
            if(word.contains(in)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i)==in.charAt(0)) {
                        wordStorage[i]=in.charAt(0) + " ";
                        m++;
                    }
                }
                printWordStorage(wordStorage);
            }
            else{
                try {
                    k++;
                    wrongAnswer(k);
                }
                catch (Exception e){
                    System.out.println("                 / \\");
                    System.out.println("Game Wins");
                    break;
                }
            }
            if(m==wordStorage.length){
                System.out.println("Player Wins");
                break;
            }
        }
    }
    public static void printWordStorage(String[] wordStorage){
        for (int i = 0; i < wordStorage.length; i++) {
            System.out.print(wordStorage[i]);
        }
        System.out.println();
    }
    public static void wrongAnswer(int k){
        String[] wr = {"                  o", "                 /|\\", "                  |"};
        for (int i = 0; i < k; i++) {
            System.out.println(wr[i]);
        }
    }
}
