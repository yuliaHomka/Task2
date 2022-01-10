import java.util.ArrayList;
import java.util.List;


public class ToRPN {

    private List<Token> rpn = new ArrayList<>();
    private List<Token> operations = new ArrayList<>();

    public List<Token> parser (String string) throws Exception {

        int level;
        int lastLevel = 0;
        String symbol;
        String s = "";
        boolean flagNumber = false;
        boolean flagDot = false;

        char[] arrayFromString = string.toCharArray();
        int length = arrayFromString.length;


        for (int idx = 0; idx < length; idx++){

           symbol = Character.toString(arrayFromString[idx]);
           level = checkType(symbol);
//           if (level == -2) throw new Exception("Wrong string with ' ' \n");
            if (level == -2) continue;

           Token token = new Token(symbol, level);
           if (level == 0) {
               if (symbol.equals(".")) {
                   if ((!flagDot) && (flagNumber)) {
                       addSymbolToToken(symbol);
                       flagDot = true;
                   } else throw new Exception("Wrong double numbers \n");
               } else {
                   if (!flagNumber) {
                       rpn.add(token);
                       flagNumber = true;
                   } else {
                       addSymbolToToken(symbol);
                   }
               }
               continue;
           }

           flagNumber = false;
           flagDot = false;
           if (level == -1) {
               if (!fromOperationToRpnBeforeSymbol("("))
                   throw new Exception("Wrong string \n");

               int size = operations.size();
               if (size == 0) lastLevel = 0;
               else lastLevel = operations.get(size - 1).getLevel();
           } else {
                if (level <= lastLevel && !operations.isEmpty()) {
                    fromOperationToRpn(level);
                }
                operations.add(token);
                lastLevel = level;
           }
        }
        fromOperationToRpnBeforeSymbol("");
        return rpn;
    }

    public int checkType (String x){
        if (x.equals(" ")) return -2;
        return checkOperType (x);
    }

    public int checkOperType (String x){
        if (x.equals(Operations.ADD.getSmb())) return Operations.ADD.getLevel();
        if (x.equals(Operations.DIV.getSmb())) return Operations.DIV.getLevel();
        if (x.equals(Operations.SUB.getSmb())) return Operations.SUB.getLevel();
        if (x.equals(Operations.MULT.getSmb())) return Operations.MULT.getLevel();
        if (x.equals(Operations.OPENBRACKET.getSmb())) return Operations.OPENBRACKET.getLevel();
        if (x.equals(Operations.CLOSEBRACKET.getSmb())) return Operations.CLOSEBRACKET.getLevel();
        else return 0;
    }


    public boolean fromOperationToRpnBeforeSymbol(String smb){
        if (operations.isEmpty()) return false;

        int lastElementIdx = operations.size() - 1;
        Token token = operations.get(lastElementIdx);

        while (!token.getMeaning().equals(smb)){
            rpn.add(token);
            operations.remove(token);
            lastElementIdx = operations.size() - 1;
            if (lastElementIdx == -1) return false;
            token = operations.get(lastElementIdx);
        }
        operations.remove(token);
        return true;
    }

    public void fromOperationToRpn (int level){

        int lastElementIdx = operations.size() - 1;
        Token token = operations.get(lastElementIdx);

        while (token.getLevel() >= level && !token.getMeaning().equals("(")){
            rpn.add(token);
            operations.remove(token);
            lastElementIdx = operations.size() - 1;
            if (lastElementIdx == -1) return;
            token = operations.get(lastElementIdx);
        }
    }

    public void addSymbolToToken(String symbol) {
        Token tmpToken = rpn.get(rpn.size() - 1);
        tmpToken.setMeaning(tmpToken.getMeaning() + symbol);
    }
}
