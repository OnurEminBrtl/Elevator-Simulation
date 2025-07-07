package com.example.elevatorgame;

public class ElevatorPerson {

    int enterTime;
    int initialPosition;
    private int target;
    private Person person;


    public ElevatorPerson(Person p, int ip, int t){
        this.person = p;
        this.target = t;
        this.initialPosition = ip;
        enterTime = Elevator.getTravelMeter(); //The total distance traveled by the elevator before the person gets on.

    }

    public Person getPerson() {
        return person;
    }


    public int getTarget() {
        return target;
    }

    public int getInitialPosition() {
        return initialPosition;
    }


    public String toString(){
        //In order for the person to be happy, the elevator should not move extra.
        if(Math.abs(enterTime - Elevator.getTravelMeter()) <= Math.abs(target - initialPosition)){
            return "I am " + person.getName() + "." + " I traveled " + Math.abs(enterTime - Elevator.getTravelMeter()) + " floors" + "." + " I am happy.";
        }
        else{
            return "I am " + person.getName() + "." + " I traveled " + Math.abs(enterTime - Elevator.getTravelMeter()) + " floors" + "." + " I am unhappy.";
        }

    }

}
