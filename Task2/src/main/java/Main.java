import java.util.Scanner;

public class Main {

    public static void main (String args []) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input your expression: ");
        String expression = in.nextLine();
        ToRPN parser = new ToRPN();
        ToAnswer answer = new ToAnswer();
        String result;

        try{
          result = answer.count(parser.parser(expression));
          System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
