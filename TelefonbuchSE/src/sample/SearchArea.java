package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class SearchArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final TextField textField = new TextField();
    private final Button searchButton = new Button("Search");

    public SearchArea(){

        AnchorPane.setLeftAnchor(textField, 10.0);
        AnchorPane.setTopAnchor(textField, 10.0);
        AnchorPane.setRightAnchor(textField, 90.0);


        AnchorPane.setTopAnchor(searchButton, 10.0);
        AnchorPane.setRightAnchor(searchButton, 10.0);

        anchorPane.getChildren().addAll(textField, searchButton);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
