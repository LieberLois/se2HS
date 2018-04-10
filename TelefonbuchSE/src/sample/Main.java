package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {


    //static ObservableList<TelNumber> telefonEntries = FXCollections.observableArrayList(new ArrayList<>());

    @Override
    public void start(Stage primaryStage) throws Exception {
        TelBook telBook = new TelBook();
        BorderPane root = new BorderPane();
        EntryArea entryArea = new EntryArea(telBook.getNumbers());

        SearchArea searchArea = new SearchArea(telBook);
        AddDeleteArea adddeleteArea = new AddDeleteArea(

                () -> {
                    telBook.getList().add(new TelNumber());
                },

                () -> {
                    List<TelNumber> selected = entryArea.getSelectedEntries();
                    telBook.getList().removeAll(selected);
                });


        root.setTop(searchArea.getAnchorPane());
        root.setBottom(adddeleteArea.getAnchorPane());
        root.setCenter(entryArea.getAnchorPane());
        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
