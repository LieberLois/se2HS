package sample;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class EntryArea {
    private final TableView<TelNumber> table = new TableView<>();
    Main main;

    public EntryArea(){
        TableColumn<TelNumber, String> firstName = new TableColumn<>("First Name");
        TableColumn<TelNumber, String> secondName = new TableColumn<>("Second Name");
        TableColumn<TelNumber, String> number = new TableColumn<>("Number");
        table.getColumns().addAll(firstName, secondName, number);
        //TODO: getSelectedEntries causes NullPointerException
        setItems(getSelectedEntries());

    }

    public TableView getTable() {
        return table;
    }

    public void setItems(List<TelNumber> telNumbers){
        table.getItems().setAll(telNumbers);
    }

    public List<TelNumber> getSelectedEntries(){
        return main.telBook.getNumbers();
    }
}
