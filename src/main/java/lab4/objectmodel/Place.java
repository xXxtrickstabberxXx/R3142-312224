package lab4.objectmodel;

public enum Place {
    CONTROLPANEL("пульт управления"),
    SEATS("места"),
    ROOF("на крышах");

    private final String name;

    Place(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}