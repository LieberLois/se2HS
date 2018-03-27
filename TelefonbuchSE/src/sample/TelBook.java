package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TelBook {
    private final ObservableList<TelNumber> oTelNumbers = FXCollections.observableList(new ArrayList<>());

    public TelBook(){
        oTelNumbers.add(new TelNumber("Samuel", "Glogger", "+49 66666"));
    }

    public ObservableList<TelNumber> getNumbers(){
        return oTelNumbers;
    }




}
