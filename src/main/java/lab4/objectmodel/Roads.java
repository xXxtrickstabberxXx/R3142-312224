package lab4.objectmodel;

class Roads {
    private final Node[] connected;

    Roads(Node[] connected) {
        this.connected = connected;
    }

    public Node[] getNodes() {
        return this.connected;
    }
}

