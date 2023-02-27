package org.example;

import java.io.*;

public class Export implements Serializable {
    public void doExsport(NotePad np) throws IOException {
        FileOutputStream fos = new FileOutputStream("MyNotePad.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(np);
        oos.flush();
        oos.close();
    }
}
