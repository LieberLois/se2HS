package sample;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AddDeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final Button deleteButton = new Button("Delete");
    private final Button addButton = new Button("Add");
    public AddDeleteArea(){
        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);

        AnchorPane.setRightAnchor(addButton, 90.0);



        anchorPane.getChildren().addAll(addButton, deleteButton);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
