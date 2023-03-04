package Calc;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MainLogger implements Logirable{
    @Override
    public void doLog(DataLoger model) {
        try (FileWriter writer = new FileWriter("log.csv", true)){
            writer.write(LocalDate.now() + ": ");
            writer.write(model.getMessage() + "; ошибок ");
            writer.write(model.getErrorCode() + " ;");
            writer.write(model.getTag() == null? " - ; \n": model.getTag() + ";\n");

        } catch (IOException ex){

        }

    }
}
