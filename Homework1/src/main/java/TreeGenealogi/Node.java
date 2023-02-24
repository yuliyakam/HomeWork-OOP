package TreeGenealogi;

import java.io.Serializable;

public class Node implements Serializable {
    People p1;
    Relationship r;
    People p2;

    public Node(People p1, Relationship r, People p2) {
        this.p1 = p1;
        this.r = r;
        this.p2 = p2;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %s %s \n", p1.getFname(), p1.getFname(), r, p2.getFname(), p2.getName());
    }
}

