package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SearchArea searchArea = new SearchArea();
        AddDeleteArea addDeleteArea = new AddDeleteArea();
        BorderPane root = new BorderPane();

        root.setTop(searchArea.getAnchorPane());
        root.setBottom(addDeleteArea.getAnchorPane());

        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.setResizable(false);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
