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
    int x1 = 500;
    int x2 = 600;
    int x3 = 700;
    int x4 = 800;
    int y = 590;
    int y1 = 620;
    int count_101 = 0;
    int count_16 = 0;
    int count_12B = 0;
    int count_10 = 0;
    int count_12A = 0;
    int count_19A = 0;


    String[] majorArray = {"CS 101", "CE 16", "CS 12B", "AMS 10","CS 12A","MATH 19A","MATH 19B"};

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group g = new Group();

        //Add Sammy the Programmer
        ImageView trash = new ImageView("trashcan.png");
        trash.setLayoutX(0);
        trash.setLayoutY(500);
        trash.setFitHeight(90);
        trash.setFitWidth(90);

        //Click twice label
        Label twice = new Label("***Click Twice to bring up Prerequisite courses***");
        twice.setLayoutX(0);
        twice.setLayoutY(600);

        //Preq
        Label preq = new Label("PREREQUISITE:");
        preq.setLayoutY(590);
        preq.setLayoutX(350);
        preq.setFont(Font.font("Verdana", 18));    //Set font

        //Add program title
        Label title = new Label("Course Manager");
        title.setLayoutX(210);
        title.setLayoutY(15);
        title.setFont(Font.font("Verdana", 25));    //Set font


        //Menu bar
        Menu menu = new Menu("Courses");

        //MAJOR COURSES MENU
        Menu Major_Menu = new Menu("Major Courses");

        MenuItem major1 = new MenuItem(majorArray[0]);
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

        //coin Flip
        Button coinFlip = new Button("Coin flip");
        coinFlip.setLayoutY(300);
        coinFlip.setLayoutX(0);

        coinFlip.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Controller.flipper();
            }
        });

        //Add Sammy the Programmer
        ImageView sammyPic = new ImageView("sammy.png");
        sammyPic.setLayoutX(0);
        sammyPic.setLayoutY(2);
        sammyPic.setFitHeight(90);
        sammyPic.setFitWidth(90);

        //Table picture
        ImageView tablePic = new ImageView("table.png");
        tablePic.setLayoutX(200);
        tablePic.setLayoutY(50);
        tablePic.setFitHeight(520);
        tablePic.setFitWidth(730);

        //Add to window
        g.getChildren().add(title);
        g.getChildren().add(sammyPic);
        g.getChildren().add(mb);
        g.getChildren().add(coinFlip);
        g.getChildren().add(tablePic);
        g.getChildren().add(preq);
        g.getChildren().add(twice);
        g.getChildren().add(trash);

        Scene scene = new Scene(g, 950, 650);
        scene.setFill(Color.rgb(255, 252, 105));

        primaryStage.setScene(scene);
        primaryStage.show();

        //MenuTask
        major1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Testing");
                Circle circle_Red = new Circle(50.0f, Color.RED);
                circle_Red.setCursor(Cursor.HAND);
                circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
                circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                Button CS101 = new Button(majorArray[0]);
                CS101.setLayoutX(25);
                CS101.setLayoutY(160);

                CS101.setCursor(Cursor.HAND);
                CS101.setOnMousePressed(labelOnMousePressedEventHandler);
                CS101.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                CS101.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        count_101++;
                        if (count_101 == 2) {

                            Button CE16 = new Button(majorArray[1]);
                            CE16.setLayoutY(y);
                            CE16.setLayoutX(x1);
                            Button CS12B = new Button(majorArray[2]);
                            CS12B.setLayoutY(y);
                            CS12B.setLayoutX(x2);
                            Button AMS10 = new Button(majorArray[3]);
                            AMS10.setLayoutY(y);
                            AMS10.setLayoutX(x3);
                            Button MATH19B = new Button(majorArray[6]);
                            MATH19B.setLayoutY(y);
                            MATH19B.setLayoutX(x4);

                            CS12B.setCursor(Cursor.HAND);
                            CS12B.setOnMousePressed(labelOnMousePressedEventHandler);
                            CS12B.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                            CE16.setCursor(Cursor.HAND);
                            CE16.setOnMousePressed(labelOnMousePressedEventHandler);
                            CE16.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                            AMS10.setCursor(Cursor.HAND);
                            AMS10.setOnMousePressed(labelOnMousePressedEventHandler);
                            AMS10.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                            MATH19B.setCursor(Cursor.HAND);
                            MATH19B.setOnMousePressed(labelOnMousePressedEventHandler);
                            MATH19B.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                            g.getChildren().add(CS12B);
                            g.getChildren().add(AMS10);
                            g.getChildren().add(CE16);
                            g.getChildren().add(MATH19B);

                            //--
                            CS12B.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {
                                    count_12B++;
                                    if(count_12B ==2) {

                                        Button CS12A = new Button(majorArray[4]);
                                        CS12A.setLayoutY(y1);
                                        CS12A.setLayoutX(x1);

                                        CS12A.setCursor(Cursor.HAND);
                                        CS12A.setOnMousePressed(labelOnMousePressedEventHandler);
                                        CS12A.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                                        g.getChildren().add(CS12A);

                                    }
                                }
                            });
                            CE16.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {
                                    count_16++;
                                    if(count_16 ==2) {
                                        Button MATH19A = new Button(majorArray[5]);
                                        MATH19A.setLayoutY(y1);
                                        MATH19A.setLayoutX(x2);

                                        MATH19A.setCursor(Cursor.HAND);
                                        MATH19A.setOnMousePressed(labelOnMousePressedEventHandler);
                                        MATH19A.setOnMouseDragged(labelOnMouseDraggedEventHandler);

                                        g.getChildren().add(MATH19A);
                                    }
                                }
                            });


                        }
                    }
                });

                g.getChildren().add(CS101);

            }
        });


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
