package memory_puzzle;

import java.util.Scanner;

public class Game {
    static String[][] resultPuzzler1 =Puzzle.EmptyPuzzleMaker();
    static String[][] resultPuzzler2 =Puzzle.EmptyPuzzleMaker();
    public static void main(String[] args) {
        String[][] emptyPuzzler=Puzzle.EmptyPuzzleMaker();
        printPuzzle(emptyPuzzler);
        String[][] loadPuzzler=PuzzleArray.strArray2D();
        String input;
        int counter=0;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("---------------------");
            System.out.print("Please write the coordinates of the first card: ");
            input = scan.nextLine();
            int[] map1 = Puzzle.keyMap(input);
            puzzleAssembler(loadPuzzler,map1);
            printPuzzle(resultPuzzler1);
            System.out.println("---------------------");
            System.out.print("Please write the coordinates of the second card: ");
            input = scan.nextLine();
            int[] map2 = Puzzle.keyMap(input);
            puzzleAssembler(loadPuzzler,map2);
            printPuzzle(resultPuzzler1);
            if(resultPuzzler1[map1[0]][map1[1]].equals(resultPuzzler1[map2[0]][map2[1]])){
                reassembler1();
                counter++;
                System.out.println("Correct!");
            }
            else{
                reassembler2();
                System.out.println("---------------------");
                System.out.println("Incorrect!!!");
                System.out.println("---------------------");
                printPuzzle(resultPuzzler1);
            }
            if(counter>=5) break;
        }
    }
    public static void printPuzzle(String[][] puzzle){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(puzzle[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void puzzleAssembler(String[][] loadPuzzler, int[]map){
        resultPuzzler1[map[0]][map[1]]=loadPuzzler[map[0]][map[1]];
    }
    public static void reassembler1(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                resultPuzzler2[i][j]=resultPuzzler1[i][j];
            }
        }
    }
    public static void reassembler2(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                resultPuzzler1[i][j]=resultPuzzler2[i][j];
            }
        }
    }
}
