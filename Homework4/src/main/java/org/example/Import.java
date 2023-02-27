package org.example;

import java.io.*;

public class Import implements Serializable {
    public void doImport() throws IOException, ClassNotFoundException {
        NotePad npExport = new NotePad();
        FileInputStream fis = new FileInputStream("MyNotePad.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        npExport = (NotePad) oin.readObject();
    }
}
