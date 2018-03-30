package sample;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EntryArea {
    private final TableView<TelNumber> table = new TableView<>();

    public EntryArea(){
        TableColumn<TelNumber, String> telNumber = new TableColumn<>("Name");
        table.getColumns().addAll(telNumber);
    }

    public TableView getTable() {
        return table;
    }
}
