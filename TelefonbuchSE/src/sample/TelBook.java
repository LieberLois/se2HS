package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.List;

public class TelBook {
    private final ObservableList<TelNumber> oTelNumbers = FXCollections.observableList(new ArrayList<>());
    private final FilteredList<TelNumber> filteredNumbers = new FilteredList<TelNumber>(oTelNumbers);

    public TelBook(){

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
            return (telNumber.getFirstName().contains(search)) || telNumber.getLastName().contains(search) || telNumber.getNumber().contains(search);
        });
    }

    public void save(){
        FileSystem.writeFile(oTelNumbers);
    }


}
