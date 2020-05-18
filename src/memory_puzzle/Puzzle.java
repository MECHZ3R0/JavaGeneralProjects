package memory_puzzle;

public class Puzzle {
    public static String[][] EmptyPuzzleMaker(){
        String[][] puzzler = new String[5][4];
        puzzler[0][0]=" ";
        for (int i = 1; i < 5; i++) {
            puzzler[i][0]=""+(char)('A'+i-1);
            for (int j = 1; j < 4; j++) {
                puzzler[0][j]=""+j;
                puzzler[i][j]="*";
            }
        }
        return puzzler;
    }
    public static int[] keyMap(String scan){
        int[] map = new int[2];
        switch(scan.toLowerCase()){
            case "a1": map[0]=1; map[1]=1; break;
            case "a2": map[0]=1; map[1]=2; break;
            case "a3": map[0]=1; map[1]=3; break;
            case "b1": map[0]=2; map[1]=1; break;
            case "b2": map[0]=2; map[1]=2; break;
            case "b3": map[0]=2; map[1]=3; break;
            case "c1": map[0]=3; map[1]=1; break;
            case "c2": map[0]=3; map[1]=2; break;
            case "c3": map[0]=3; map[1]=3; break;
            case "d1": map[0]=4; map[1]=1; break;
            case "d2": map[0]=4; map[1]=2; break;
            case "d3": map[0]=4; map[1]=3; break;
            default: System.out.println("Unknown Key Configuration!!! Please, first enter one single letter from the map followed with one single number from the map and no spaces between them."); break;
        }
        return map;
    }
}
