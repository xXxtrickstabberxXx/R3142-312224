package lab4.objectmodel;

public abstract class Node {
    private Roads roads;
    private final boolean ableToLand;

    Node(boolean ableToLand) {
        this.ableToLand = ableToLand;
    }

    public boolean getAbleToLand() {
        return this.ableToLand;
    }

    public Roads getConnections() {
        return this.roads;
    }

    public void setConnections(Roads roads) {
        this.roads = roads;
    }
}