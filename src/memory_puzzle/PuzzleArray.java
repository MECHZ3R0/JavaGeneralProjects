package memory_puzzle;

import java.util.Stack;

public class PuzzleArray {
    private static String randomText(){
        return ""+(char)('a'+(int)(Math.random()*26));
    }
    private static Stack<String> container(){
        Stack<String> cont = new Stack<>();
        for (int i = 0; i < 6; i++) {
            cont.push(randomText());
        }
        return cont;
    }
    private static String[] strArray(){
        String[] arrStr = new String[12];
        for (int i = 0; i < 6; i++) {
            arrStr[i]=container().pop();
        }
        String randomNumbers, indexRandomizer="";
        for (int i = 0; i < 6;) {
            randomNumbers=""+(int)(Math.random()*6);
            if(!indexRandomizer.contains(randomNumbers))
            indexRandomizer+=randomNumbers;
            i=indexRandomizer.length();
        }
        for (int i = 6,j=0; i < 12; i++) {
            arrStr[i]=arrStr[Integer.parseInt(""+indexRandomizer.charAt(j))];
            j++;
        }
        return arrStr;
    }
    public static String[][] strArray2D(){
        String[] strArrayTemp=strArray();
        String[][] strArr2D = new String[5][4];
        for (int i = 1, k=0; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                strArr2D[i][j]=strArrayTemp[k];
                k++;
            }
        }
        return strArr2D;
    }
}
