package org.example;

import java.time.LocalDate;

public class YesterdayYet extends Task {

    public YesterdayYet(LocalDate data, String node, String deadLineTime, String deadLineDate, String avtor) {
        super(data, node, deadLineTime, deadLineDate, avtor);
    }

    @Override
    public String toString() {
        return "!!! High " + super.toString();
    }
}
