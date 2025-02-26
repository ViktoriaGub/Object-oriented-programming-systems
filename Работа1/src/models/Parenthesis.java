package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parenthesis {
    public StringBuilder parenthesis(StringBuilder input, StringBuilder  inputUser){

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(inputUser.toString());

        if (Betwen.flag()){
            if (matcher.find() && input.toString().length() > inputUser.toString().length()){
                inputUser.replace(Betwen.start(), Betwen.end() + (input.toString().length()- inputUser.toString().length()), input.toString());
            }
            else {
                inputUser.replace(Betwen.start(), Betwen.end(), input.toString());
                System.out.println(inputUser);
            }
        }

        while (matcher.find()){

            int start = 0, end = 0, countLeft = 0, countRight = 0 ,  cnt = 0;
            StringBuilder inp;

            for (int i = 0; i < inputUser.length(); ++i) {

                if (inputUser.charAt(i) == '(') countLeft++;
                if (inputUser.charAt(i) == ')') countRight++;

                if (inputUser.charAt(i) == ')' && cnt == 0) {
                    end = i;
                    ++cnt;
                }
            }

            for (int i = 0; i < inputUser.length(); ++i) {
                if (inputUser.charAt(i) == '('  && i < end) start = i;
            }

            if (countLeft == 0 && countRight == 0) {
                Betwen.between(inputUser, 0, inputUser.length());
                new Number().processNumber(" ",inputUser);
                Betwen.getFlag(false);

            }else if (countRight == countLeft){
                inp = new StringBuilder(inputUser.substring(start+1, end));
                Betwen.between(inputUser, start, end+1);
                inputUser.delete(start,start);
                inputUser.delete(end,end);
                Betwen.getFlag(true);
                new Number().processNumber(" ",inp);
            } else {
                inputUser =  new StringBuilder("Ошибка в формуле");
                break;
            }
        }
        return inputUser;
    }
}
