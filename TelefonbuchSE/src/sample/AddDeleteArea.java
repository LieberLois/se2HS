package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AddDeleteArea {

    private final AnchorPane anchorPane = new AnchorPane();

    public AddDeleteArea(Runnable onAdd, Runnable onDelete){

        final Button deleteButton = new Button("Delete");
        final Button addButton = new Button("Add");

        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);

        AnchorPane.setRightAnchor(addButton, 90.0);


        AnchorPane.setTopAnchor(deleteButton, 10.0);
        AnchorPane.setTopAnchor(addButton, 10.0);
        anchorPane.getChildren().addAll(addButton, deleteButton);

        addButton.setOnAction(event -> {
            onAdd.run();
        });

        deleteButton.setOnAction(event -> {
            onDelete.run();
        });
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
