
package com.example.elevatorgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ElevatorGame extends Application {
    private Elevator el = new Elevator();
    private Rectangle r1 = new Rectangle(25, 10, 90, 60);
    private TextField text1 = new TextField();
    private TextField text2 = new TextField();


    public void start(Stage primaryStage){

        //Create pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.addColumn(15, new GridPane());
        pane.addRow(6, new GridPane());


        //Create all floors.
        for(int i=0; i<11; i++ ){
            pane.add(new Rectangle(25,10,90,60),10, i);
        }


        //Create floors name's
        for(int i=10; i>=0; i-- ){
            pane.add(new Text(20,20,"Floor "+i),11, 10-i);
        }


        // we create elevator text
        Text elevatorText = new Text(20, 20, "  ELEVATOR");
        elevatorText.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.add(elevatorText,25,11);


        //Create a rectangle elevator
        r1.setStroke(Color.RED);
        r1.setFill(Color.PINK);
        pane.add(r1,25,10);


        //Create are buttons
        //UP Button
        Button btUP = new Button("UP");
        pane.add(btUP, 1, 5);
        GridPane.setHalignment(btUP, HPos.RIGHT);
        //Down Button
        Button btDown = new Button("Down");
        pane.add(btDown, 1, 6);
        GridPane.setHalignment(btDown, HPos.RIGHT);
        //Enter Botton
        Button btEnter = new Button("Enter");
        pane.add(btEnter, 1, 2);
        GridPane.setHalignment(btEnter, HPos.RIGHT);


        //Create are texts and text fields
        pane.add(new Label("Name:"), 0, 0);
        pane.add(text1,1,0);

        pane.add(new Label("Target:"), 0, 1);
        pane.add(text2,1,1);


        //Create are button's actions
        UpHandler handler1 = new UpHandler();
        btUP.setOnAction(handler1);

        DownHandler handler2 = new DownHandler();
        btDown.setOnAction(handler2);

        EnterHandler handler3 = new EnterHandler();
        btEnter.setOnAction(handler3);

        //Last part we are create all
        Scene scene = new Scene(pane,800,800);
        primaryStage.setTitle("ElevatorGame");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("Elevator is on floor: 0,Number of people: 0");

    }

    class EnterHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {

            Person p = new Person(text1.getText());
            p.setTarget(Integer.parseInt(text2.getText()));
            p.setInitialPosition(el.getCurrentFloor());
            el.enter(p);

        }
    }

    int a;
    class UpHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            if(el.getCurrentFloor() < 10){
                el.goToFloor(el.getCurrentFloor()+1);
                a = a-66;
                r1.setTranslateY(a);
            }
            else{
                System.out.println("You are on the top floor. You cannot go higher.");
            }
        }
    }

    class DownHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            if(el.getCurrentFloor() > 0){
                el.goToFloor(el.getCurrentFloor()-1);
                a = a+66;
                r1.setTranslateY(a);
            }
            else{
                System.out.println("You are on the lowest floor. You cannot go any lower.");
            }
        }
    }

    public static void main(String[] args){
        launch(args);
    }

}
