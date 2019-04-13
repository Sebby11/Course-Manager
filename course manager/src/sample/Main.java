package sample;

import com.sun.tools.hat.internal.model.Root;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group g = new Group();

        //Add program title
        Label title = new Label("Course Manager");
        title.setLayoutX(210);
        title.setLayoutY(15);
        title.setFont(Font.font("Verdana", 25));    //Set font

        //Add ex table
        TableView table = new TableView();
        table.setEditable(true);
        table.setLayoutY(100);
        table.setLayoutX(310);

        TableColumn whatCol = new TableColumn("What");
        TableColumn descriptCol = new TableColumn("Description");
        TableColumn dueCol = new TableColumn("Due");

        table.getColumns().addAll(whatCol, descriptCol, dueCol);


        //Menu bar
        Menu m = new Menu("menu");

        MenuItem m1 = new MenuItem("item 1");
        MenuItem m2 = new MenuItem("item 2");
        MenuItem m3 = new MenuItem("item 3");

        m.getItems().add(m1);
        m.getItems().add(m2);
        m.getItems().add(m3);

        MenuBar mb = new MenuBar();

        mb.getMenus().add(m);

        mb.setLayoutX(0);
        mb.setLayoutY(100);

        //Add Sammy the Programmer
        ImageView sammyPic = new ImageView("sammy.png");
        sammyPic.setLayoutX(0);
        sammyPic.setLayoutY(2);
        sammyPic.setFitHeight(90);
        sammyPic.setFitWidth(90);

        //Add to window
        g.getChildren().add(title);
        g.getChildren().add(sammyPic);
        g.getChildren().add(table);
        g.getChildren().add(mb);

        Scene scene = new Scene(g, 600, 500);
        scene.setFill(Color.rgb(255, 252, 105));

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
