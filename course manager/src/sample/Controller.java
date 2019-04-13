package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class Controller {
    TableView table;

    Controller(TableView table) {
        this.table = table;
    }

    public static void addTask() {

        Label title = new Label("Add task");
        title.setFont(Font.font("Courier", 30));

        //ENTER WHAT
        Label whatLabel = new Label("What will you be doing?");

        TextField what = new TextField();

        //ENTER DESCRIPTION
        Label descripLabel = new Label("Add description");

        TextField descript = new TextField();

        //Enter DUE
        Label dueLabel = new Label("When will it be due?");

        TextField due = new TextField();

        //FINISH
        Button finish = new Button("Done");

        VBox layout = new VBox();
        layout.setSpacing(1);                  //Spacing between components

        //Set margins for components
        layout.setMargin(whatLabel, new Insets(10, 20, 10, 20));
        layout.setMargin(what, new Insets(10, 20, 10, 20));
        layout.setMargin(descripLabel, new Insets(10, 20, 10, 20));
        layout.setMargin(descript, new Insets(10, 20, 10, 20));
        layout.setMargin(dueLabel, new Insets(10, 20, 10, 20));
        layout.setMargin(due, new Insets(10, 20, 10, 20));
        layout.setMargin(finish, new Insets(10, 20, 10, 20));

        //Create a list & add components
        ObservableList list = layout.getChildren();
        list.addAll(title, whatLabel, what, descripLabel, descript, dueLabel, due, finish);

        Scene addTaskScene = new Scene(layout, 300, 440);

        //New window creation
        Stage newWindow = new Stage();
        newWindow.setTitle("Add Task");
        newWindow.setScene(addTaskScene);
        newWindow.setResizable(false);

        newWindow.show();
    }
}