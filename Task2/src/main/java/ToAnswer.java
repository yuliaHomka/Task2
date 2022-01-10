import java.util.ArrayList;
import java.util.List;

public class ToAnswer {

    public String count (List<Token> rpn)  throws Exception{
        List<Token>  answerList = new ArrayList<>();
        int size = rpn.size();
        for(int i = 0; i < size; i++){
            Token token =  rpn.remove(0);
            if (token.getLevel() == 0) {
                answerList.add(token);
            }
            else{
                int sizeTmp = answerList.size() - 1;
                if (sizeTmp < 1) throw new Exception("wrong string \n");
                var x = answerList.remove(sizeTmp);
                var y = answerList.remove(sizeTmp - 1);
                 answerList.add(new Token(count(y.getMeaning(), x.getMeaning(), token.getMeaning()), 0));
            }
        }
        if (answerList.size() != 1) throw new Exception("Wrong string \n");
        return answerList.get(0).getMeaning();
    }


    public String count(String x, String y, String oper) throws Exception {

        double xDouble = Double.parseDouble(x);
        double yDouble = Double.parseDouble(y);
        Double result = 0.0;
        if (oper.equals("*")) result = (xDouble * yDouble);
        if (oper.equals("+")) result = (xDouble + yDouble);
        if (oper.equals("-")) result = (xDouble - yDouble);
        if (oper.equals("/")) {
            if (yDouble == 0.0) throw new Exception("Divided by 0 \n");
            else result = xDouble / yDouble;
        }
        return result.toString();
    }
}
