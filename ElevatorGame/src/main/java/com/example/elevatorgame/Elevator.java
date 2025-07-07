package com.example.elevatorgame;

import java.util.ArrayList;
import java.util.Locale;

public class Elevator {

    private static int travelMeter;
    private int currentFloor;
    private int maxFloor;
    private int minFloor;
    private MyStack people = new MyStack();
    private int capacity;


    public Elevator(){ //In the parameterless constructor, we set the values of the variables as default.
        capacity = 4;
        minFloor = 0;
        maxFloor = 10;
    }


    public Elevator(int size, int minFloor, int maxFloor){
        capacity = size;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }


    public static int getTravelMeter() {
        return travelMeter;
    }


    public boolean enter(Person p) throws IllegalArgumentException{

        ElevatorPerson person = new ElevatorPerson(p, currentFloor, p.getTarget()); //We set up ElevatorPerson

        if(p.getTarget() >= minFloor && p.getTarget() <= maxFloor){ //Floor range where person can go.

            if(!isFull()){ //Person can enter if the elevator is not full
                people.push(person);
                System.out.println(p.getName() + " is in.");
                return true;
            }
            else{
                return false;
            }
        }
        else{

            throw new IllegalArgumentException("target " + p.getTarget() + " out of bounds"); //Throws an IllegalArgumentException if the floor one wants to go to is out of range.
        }
    }


    public void goToFloor(int floor) throws IllegalArgumentException {

        if(floor >= minFloor && floor <= maxFloor){ //Floor range.

            travelMeter += Math.abs(floor-currentFloor); //The total distance traveled by the elevator increases.
            currentFloor = floor; //Elevator goes to the specified floor.

            for (int i = people.getSize()-1; i>=0; i--){ //If more than one person is going to get off on the same floor, it ensures that these people get off.

                if(((ElevatorPerson)people.peek()).getTarget() == currentFloor){

                    System.out.println(((ElevatorPerson)people.peek()).getPerson().getName() + " is out.");
                    System.out.println(people.peek().toString());
                    people.pop();
                }
                else{
                    break; //We use 'break' to avoid unnecessary checking of all persons.
                }

            }

        }
        else{
            throw new IllegalArgumentException("floor " + floor + " out of bounds"); //Throws an IllegalArgumentException if the floor to go is out of range.
        }

        System.out.println(this);
    }


    public boolean isFull(){
        if(people.getSize() == capacity){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean isEmpty(){
        return people.isEmpty();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String toString(){
        return "Elevator is on floor: " + currentFloor + ",Number of people: " + people.getSize();
    }

}
