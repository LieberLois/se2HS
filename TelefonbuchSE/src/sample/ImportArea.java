package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ImportArea {

    private final AnchorPane anchorPane = new AnchorPane();

    public ImportArea(Runnable onImport){

        final Button importButton = new Button("Import");

        AnchorPane.setBottomAnchor(importButton, 10.0);
        AnchorPane.setTopAnchor(importButton, 10.0);
        AnchorPane.setLeftAnchor(importButton, 10.0);

        anchorPane.getChildren().add(importButton);

        importButton.setOnAction(event -> {
            onImport.run();
        });

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
