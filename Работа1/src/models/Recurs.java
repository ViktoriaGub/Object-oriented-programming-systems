package models;

import static models.Betwen.between;

public class Recurs {
    public static void recursionPath(StringBuilder input){
        //System.out.println(between());
        new Parenthesis().parenthesis(input, between());
    }
}