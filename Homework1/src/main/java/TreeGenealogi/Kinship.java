package TreeGenealogi;


import java.util.ArrayList;
import java.util.List;


public class Kinship {


    private List<Node> pairs = new ArrayList<>();
    private List<List<Node>> kinships = new ArrayList<>();


    public Kinship(ArrayList<Node> pairs) {
        this.pairs = pairs;

    }

    public Kinship() {
        this(new ArrayList<>());

    }

    public void setKinship(People who, Relationship role, People whose) {
        this.pairs.add(new Node(who, role, whose));
        this.kinships.add(pairs);
    }

    public List<Node> getPairs() {
        return pairs;
    }

    public List<List<Node>> getKinships() {
        return kinships;
    }

    @Override
    public String toString() {
        return "Kinship{" +
                "pairs=" + pairs +
                '}';
    }
}

