package lab4.objectmodel;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Map {

    private final Town phantomas = new Town("Фантомас");
    private final Field field = new Field();
    private final Hill hill1 = new Hill();
    private final Hill hill2 = new Hill();
    private final Meadow meadow = new Meadow();
    private final Village village1 = new Village();
    private final Village village2 = new Village();
    private final Forest forest = new Forest();
    private final Town unknown1 = new Town("Unknown1");
    private final Town unknown2 = new Town("Unknown2");
    private final Town unknown3 = new Town("Unknown3");
    private final List<Node> placesList = new ArrayList<Node>();


    Map() {
        this.phantomas.setConnections(new Roads(new Node[]{this.village1, this.village2, this.field, this.unknown1, this.unknown2, this.unknown3}));
        this.field.setConnections(new Roads(new Node[]{this.forest, this.phantomas}));
        this.forest.setConnections(new Roads(new Node[]{this.hill1, this.hill2, this.meadow, this.field}));
        this.hill1.setConnections(new Roads(new Node[]{this.forest, this.meadow}));
        this.hill2.setConnections(new Roads(new Node[]{this.forest, this.meadow}));
        this.meadow.setConnections(new Roads(new Node[]{this.hill1, this.hill2, this.forest}));
        this.unknown1.setConnections(new Roads(new Node[]{this.phantomas}));
        this.unknown2.setConnections(new Roads(new Node[]{this.phantomas}));
        this.unknown3.setConnections(new Roads(new Node[]{this.phantomas}));

        this.placesList.add(this.phantomas);
        this.placesList.add(this.field);
        this.placesList.add(this.hill1);
        this.placesList.add(this.hill2);
        this.placesList.add(this.meadow);
        this.placesList.add(this.village1);
        this.placesList.add(this.village2);
        this.placesList.add(this.forest);
        this.placesList.add(this.unknown1);
        this.placesList.add(this.unknown2);
        this.placesList.add(this.unknown3);
    }

    public List<Node> getPlacesList() {
        return this.placesList;
    }

    public boolean checkLocation(Node place) {
        return this.placesList.contains(place);
    }

    class Town extends Node {
        private final String name;
        private final Police police;
        private Telescope telescope = null;

        Town(String name) {
            super(true);
            this.name = name;
            this.police = new Police(name);
        }

        public String getName() {
            return this.name;
        }

        public void empowerPolice() {
            this.police.setEmpower();
        }

        public void setTelescope(Object target) {
            this.telescope = new Telescope(this.name);
            this.telescope.track(target);
        }

        public String toString() {
            return this.name;
        }

        public class Telescope {
            private final String townName;
            private boolean isActive = false;
            private Object target = null;

            Telescope(String townName) {
                this.townName = townName;
            }

            public void track(Object target) {
                this.target = target;
                this.isActive = true;
                System.out.println("Телескоп в городе " + this.townName + " следит за: " + target.toString() + ".");
            }
        }

        class Police extends MoonPolice {
            private final String townName;
            private boolean isEmpowered = false;

            Police(String townName) {
                this.townName = townName;
            }

            public void setEmpower() {
                this.isEmpowered = true;
                System.out.println("Полиция в городе " + this.townName + " была усилена.");
            }
        }
    }

    class Forest extends Node {
        Forest() {
            super(false);
        }
    }

    class Field extends Node {
        Field() {
            super(false);
        }
    }

    class Village extends Node {
        Village() {
            super(false);
        }
    }

    class Meadow extends Node {
        Meadow() {
            super(true);
        }
    }

    class Hill extends Node {
        Hill() {
            super(false);
        }
    }
}
