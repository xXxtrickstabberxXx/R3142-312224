package lab4.objectmodel;

public enum Location {
    BOTTOM(0) {
        public String toString() {
            return ("снизу");
        }
    },
    TOP(1) {
        public String toString() {
            return ("сверху");
        }
    },
    LEFT(2) {
        public String toString() {
            return ("слева");
        }
    },
    RIGHT(3) {
        public String toString() {
            return ("справа");
        }
    };

    private int index;

    Location(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}

