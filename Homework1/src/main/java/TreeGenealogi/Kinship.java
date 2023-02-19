package TreeGenealogi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kinship {
    public ArrayList<Node> pairs = new ArrayList<>();
    public void setKinship(People who, Relationship role, People whose){
        pairs.add(new Node(who, role,whose));

    }
    public void printPairs(){
        //System.out.println(Arrays.asList(pairs));
        for(var el : pairs) {
            System.out.println(el.p1.fname +" " + el.p1.name +" " + el.p1.lname + " " + el.r );
            System.out.println(el.p2.fname+" " + el.p2.name + " " + el.p2.lname);
        }

    }
    public ArrayList<Node> getPairs() {
        return pairs;
    }




}

