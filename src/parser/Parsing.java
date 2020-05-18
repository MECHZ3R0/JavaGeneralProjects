package parser;

public class Parsing {
    public static void main(String[] args) {
        String code = "start ; print() ; end ;";
        String[] keyWords = {"start","print()","end"};
        String[] keySymbols = {";","(",")"};
        String[] arrCode = code.split(" ");
        String x = isCodeCorrect(arrCode,keyWords,keySymbols)&&checkSemicolon(arrCode,keyWords)?"Code is OK":"Error detected";
        System.out.println(x);
    }
    public static boolean isCodeCorrect(String[] arrCode, String[] keyWords, String[] keySymbols){
        boolean x = false;
        int counter = 0;
        for (int i = 0; i < arrCode.length; i++) {
            for (int j = 0; j < keyWords.length; j++) {
                if(arrCode[i].equals(keyWords[j])){
                    counter++;
                }
                else if (arrCode[i].equals(keySymbols[j])){
                    counter++;
                }
            }
        }
        if(counter==arrCode.length) x=true;
        return x;
    }
    public static boolean checkSemicolon(String[] arrCode, String[] keyWords){
        boolean x=true;
        for (int i = 0; i < arrCode.length; i++) {
            for (int j = 0; j < keyWords.length; j++) {
                if(arrCode[i].equals(keyWords[j])){
                    if(!arrCode[i+1].equals(";")){
                        x=false;
                    }
                }
            }
        }
        return x;
    }
}
