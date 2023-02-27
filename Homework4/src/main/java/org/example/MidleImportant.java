package org.example;

import java.time.LocalDate;

public class MidleImportant extends Task {

    public MidleImportant(LocalDate data, String node, String deadLineTime, String deadLineDate, String avtor) {
        super(data, node, deadLineTime, deadLineDate, avtor);
    }

    @Override
    public String toString() {
        return "! Midle " + super.toString();
    }
}
