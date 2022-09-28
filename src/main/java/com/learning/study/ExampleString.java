package com.learning.study;

public class ExampleString {

    public String[] split(String str){
        return str.split(",");
    }

    public String substring(String str){
        return str.substring(str.indexOf('(') + 1 , str.indexOf(')'));
    }

    public char chatAt(String str, int index){
        return str.charAt(index);
    }

}
