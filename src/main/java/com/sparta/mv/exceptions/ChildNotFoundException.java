package com.sparta.mv.exceptions;

public class ChildNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "Element child does not exist in this tree";
    }
}
