package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    private final TelBook tb1 = new TelBook(FileSystem.getDefaultPath());

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        BorderPane b1 = createTelefonArea(tb1, true);
        BorderPane b2 = createTelefonArea(new TelBook(null), false);





        root.setLeft(b1);
        root.setRight(b2);



        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private BorderPane createTelefonArea(TelBook telBook, boolean isOwnTelBook) {



        EntryArea entryArea = new EntryArea(telBook.getNumbers());

        SearchArea searchArea = new SearchArea(telBook);


        BorderPane root = new BorderPane();
        root.setTop(searchArea.getAnchorPane());

        root.setBottom(isOwnTelBook ? createAddDelete(telBook, entryArea) : createImport(telBook, entryArea));

        if(!isOwnTelBook){
            entryArea.getAnchorPane().setOnDragOver(e -> {
                e.acceptTransferModes(TransferMode.COPY);
            });

            entryArea.getAnchorPane().setOnDragDropped(e -> {
                final Dragboard db = e.getDragboard();
                Path path;

                if(db.hasFiles() && (db.getFiles().get(0).getPath().endsWith(".json") || db.getFiles().get(0).getPath().endsWith(".txt"))){
                    path = Paths.get(db.getFiles().get(0).getPath());
                    TelBook imported = new TelBook(path);
                    entryArea.setItems(imported.getNumbers());
                } else {
                    e.consume();
                }

            });

        }

        root.setCenter(entryArea.getAnchorPane());
        return root;
    }

    private AnchorPane createImport(TelBook telBook, EntryArea entryArea) {
        ImportArea importArea = new ImportArea(
                () -> {
                    List<TelNumber> selected = entryArea.getSelectedEntries();

                    selected.forEach(element -> {
                        if(!(telBook.getNumbers().contains(element))){
                            telBook.addNumber(element);
                        }
                    });

                }
        );
        return importArea.getAnchorPane();

    }

    private AnchorPane createAddDelete(TelBook telBook, EntryArea entryArea) {
        AddDeleteArea adddeleteArea = new AddDeleteArea(

                () -> {
                    telBook.getList().add(new TelNumber());
                },

                () -> {
                    List<TelNumber> selected = entryArea.getSelectedEntries();
                    telBook.getList().removeAll(selected);
                });

        return adddeleteArea.getAnchorPane();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void stop(){
        tb1.save();
    }

}
