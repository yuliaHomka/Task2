import org.junit.Test;

import java.util.List;

public class TestForParser {

    private ToRPN toRpn = new ToRPN();

    @Test
    public void Test1(){
        String string = "(2+2)*2";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test2(){
        String string = "5*2+10";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test3(){
        String string = "(6+10-4)/(1+1*2)+1";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void Test4WithSpaces(){
        String string = "(6 + 10-4) /(1+ 1*2)+ 1  ";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test5WithDouble(){
        String string = "2.5 + 2.5";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test6WithWrongDouble(){
        String string = "2.5 + 2..5";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Test7WithWrongDouble(){
        String string = ".5 + 2.5";
        try{
            List<Token> list = toRpn.parser(string);
            System.out.println("String for check list in debugger");
            for(var x: list){ System.out.println(x.getMeaning()); }
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
