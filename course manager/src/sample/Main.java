package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

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
        table.setLayoutX(200);

        TableColumn year = new TableColumn("Year");
        year.setMinWidth(100);
        TableColumn fall = new TableColumn("Fall");
        fall.setMinWidth(150);
        TableColumn winter = new TableColumn("Winter");
        winter.setMinWidth(150);
        TableColumn spring = new TableColumn("Spring");
        spring.setMinWidth(150);
        TableColumn summer = new TableColumn("(Summer)");
        summer.setMinWidth(150);
        table.getColumns().addAll(year, fall,winter,spring, summer);


        Row r1 = new Row("row");

        table.getItems().add(r1);
        table.getItems().add(new Row("2nd"));
        table.getItems().add(new Row("3rd"));
        table.getItems().add(new Row("4th"));


        //Menu bar
        Menu menu = new Menu("Courses");

        //MAJOR COURSES MENU
        Menu Major_Menu = new Menu("Major Courses");

        MenuItem major1 = new MenuItem("Major 1");
        Major_Menu.getItems().add(major1);
        menu.getItems().add(Major_Menu);

        //GE COURSES MENU
        Menu GE_Menu = new Menu("GE's");
        //menu.getItems().add(GE_Menu);

        MenuItem GE1 = new MenuItem("GE 1");
        GE_Menu.getItems().add(GE1);
        menu.getItems().add(GE_Menu);

        MenuBar mb = new MenuBar();

        mb.getMenus().add(menu);

        mb.setLayoutX(0);
        mb.setLayoutY(100);

        //MenuTask
        GE1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Testing");
               Circle circle_Red = new Circle(50.0f, Color.RED);
                circle_Red.setCursor(Cursor.HAND);
                circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
                circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                Button course = new Button("I am a Gen ED!");
                course.setCursor(Cursor.HAND);
                course.setOnMousePressed(labelOnMousePressedEventHandler);
                course.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                g.getChildren().add(course);

            }
        });

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

        Scene scene = new Scene(g, 950, 650);
        scene.setFill(Color.rgb(255, 252, 105));

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public class Row {
        private String name;
        public Row(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }



    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Circle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

//Label movement
    EventHandler<MouseEvent> labelOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Button)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Button)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> labelOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Button)(t.getSource())).setTranslateX(newTranslateX);
                    ((Button)(t.getSource())).setTranslateY(newTranslateY);
                }
            };
}
