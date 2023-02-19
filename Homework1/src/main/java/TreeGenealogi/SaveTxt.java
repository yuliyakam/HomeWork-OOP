package TreeGenealogi;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class SaveTxt{

    public void savePairs(Kinship k) {

        try (FileWriter fw = new FileWriter("file.txt", false)) {

            for (Node el: k.getPairs()){
                fw.write(el.toString());
                fw.append('\n');
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void saveFamilyTree(ArrayList<ArrayList<Node>> family ) {

        try (FileWriter fw = new FileWriter("fileFamilyTree.txt", false)) {

            for (ArrayList el: family){
                fw.write(el.toString());
                fw.append('\n');
                fw.append("************************************");
                fw.append('\n');
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
