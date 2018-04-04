package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddDeleteArea {

    private final AnchorPane anchorPane = new AnchorPane();
    private final Button deleteButton = new Button("Delete");
    private final Button addButton = new Button("Add");
    public AddDeleteArea(){

        addButton.setOnAction(event -> {
            Main.addEntry(new TelNumber());
                });

        deleteButton.setOnAction(event -> {
            // Remove selected Entries?!
                });

        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);

        AnchorPane.setRightAnchor(addButton, 90.0);


        AnchorPane.setTopAnchor(deleteButton, 10.0);
        AnchorPane.setTopAnchor(addButton, 10.0);
        anchorPane.getChildren().addAll(addButton, deleteButton);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
