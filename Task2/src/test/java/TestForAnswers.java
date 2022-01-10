import org.junit.Assert;
import org.junit.Test;

public class TestForAnswers {

    @Test
    public void Test1(){
        String string = "(2+2)*2";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            String result = answer.count(parser.parser(string));
            Assert.assertEquals("8.0", result);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test2(){
        String string = "5";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            String result = answer.count(parser.parser(string));
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test3(){
        String string = "(6 +10-4)/ (1+1*2) +1";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            String result = answer.count(parser.parser(string));
            Assert.assertEquals("5.0", result);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test4DWithDouble(){
        String string = " 5 / 2";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            String result = answer.count(parser.parser(string));
            Assert.assertEquals("2.5", result);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test5DWithDouble(){
        String string = " 5 / 2.5";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            String result = answer.count(parser.parser(string));
            Assert.assertEquals("2.0", result);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test6DividedBy0(){
        String string = " 5 / 0";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            String result = answer.count(parser.parser(string));
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test7DividedBy0(){
        String string = " 5 / (1 - 1)";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            var res = parser.parser(string);
            String result = answer.count(res);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test8WithWrongBrackets(){
        String string = " 5 / 1 - 1)";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            var res = parser.parser(string);
            String result = answer.count(res);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test9WithWrongBrackets(){
        String string = " (5 / 1 - 1";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            var res = parser.parser(string);
            String result = answer.count(res);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test

    public void Test10WithWrongBrackets(){
        String string = " / 5";
        try{
            ToAnswer answer = new ToAnswer();
            ToRPN parser = new ToRPN();
            var res = parser.parser(string);
            String result = answer.count(res);
            System.out.println(string + " = " + result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
