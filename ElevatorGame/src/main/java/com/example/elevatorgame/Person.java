package com.example.elevatorgame;

import java.lang.annotation.Target;

public class Person {

    private final String name;
    private int target;
    private int initialPosition;
    private final int enterTime;


    public Person(String name){
        this.name = name;
        enterTime = Elevator.getTravelMeter(); //The total distance traveled by the elevator before the person gets on.
    }

    public String getName(){
        return name;
    }

    public int getTarget(){
        return target;
    }

    public void setTarget(int target){
        this.target = target;
    }

    public int getInitialPosition(){
        return initialPosition;
    }

    public int getEnterTime() {
        return enterTime;
    }
    public void setInitialPosition(int initialPosition){
        this.initialPosition = initialPosition;
    }

    //toString method for Person
    public String toString(){
        return "I am a person. My name is " + name + ".";
    }

}
