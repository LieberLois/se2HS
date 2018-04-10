package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;


public class SearchArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final TextField textField = new TextField();


    public SearchArea(TelBook telBook){

        AnchorPane.setLeftAnchor(textField, 10.0);
        AnchorPane.setTopAnchor(textField, 10.0);
        AnchorPane.setRightAnchor(textField, 10.0);


        anchorPane.getChildren().add(textField);

        textField.textProperty().addListener(listener ->{
            String search = textField.getText();
            telBook.search(search);
        });


    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
