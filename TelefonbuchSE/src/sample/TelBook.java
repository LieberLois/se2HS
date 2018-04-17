package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TelBook {
    private final ObservableList<TelNumber> oTelNumbers = FXCollections.observableList(new ArrayList<>());
    private final FilteredList<TelNumber> filteredNumbers = new FilteredList<>(oTelNumbers);
    private Path path;

    public TelBook(Path path){
        this.path = path;

        if(path != null) {
            List<TelNumber> fromFile = FileSystem.readEntriesFromFile(path);

            if (fromFile != null) {
                fromFile.forEach(entry -> oTelNumbers.add(entry));
            }
        }
    }

    public void addNumber(TelNumber telNumber){
        oTelNumbers.add(telNumber);
    }

    public List<TelNumber> getList(){return oTelNumbers;}

    public ObservableList<TelNumber> getNumbers(){
        return filteredNumbers;
    }


    public void search(String search) {
        filteredNumbers.setPredicate(telNumber -> {
            return (telNumber.getFirstName().toLowerCase().contains(search.toLowerCase())) ||
                    telNumber.getLastName().toLowerCase().contains(search.toLowerCase()) ||
                    telNumber.getNumber().contains(search);
        });
    }

    public void save(){
        FileSystem.writeFile(oTelNumbers, FileSystem.getDefaultPath());
    }


}
