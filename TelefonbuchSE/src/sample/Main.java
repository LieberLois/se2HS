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
    static TelBook telBook = new TelBook();
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();


        SearchArea searchArea = new SearchArea();
        AddDeleteArea adddeleteArea = new AddDeleteArea();
        EntryArea entryArea = new EntryArea(telBook.getNumbers());

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

    public static void addEntry(TelNumber telNumber){
        telBook.getNumbers().add(telNumber);
    }

    public static void deleteEntries(List<TelNumber> delete){
        telBook.getNumbers().removeAll(delete);
    }

    public static TelBook getTelBook(){
        return telBook;
    }

}
