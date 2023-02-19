package TreeGenealogi;

public class Node {
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
        return String.format("%s %s %s %s %s \n", p1.fname, p1.name, r, p2.fname, p2.name);
    }
    }

