package lab4.objectmodel;

import org.springframework.stereotype.Component;

public enum Material {
    STEEL(100) {
        public String toString() {
            return ("сталь");
        }
    },
    WOOD(10) {
        public String toString() {
            return ("дерево");
        }
    },
    ALUMINUM(30) {
        public String toString() {
            return ("алюминий");
        }
    },
    IRON(50) {
        public String toString() {
            return ("железо");
        }
    },
    COPPER(30) {
        public String toString() {
            return ("медь");
        }
    },
    PLASTIC(10) {
        public String toString() {
            return ("пластик");
        }
    },
    SILVER(40) {
        public String toString() {
            return ("серебро");
        }
    };

    private int durability;

    Material(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return this.durability;
    }
}
