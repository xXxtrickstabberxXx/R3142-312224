package lab4.objectmodel;

public abstract class PhysicalObject implements Physics {
    protected boolean isUnderGravity;
    protected boolean isUnderFire = false;

    PhysicalObject(boolean isUnderGravity) {
        this.isUnderGravity = isUnderGravity;
    }

    public void fall() {
        if (this.isUnderGravity) {
            System.out.println(this.toString() + " упал.");
        }
    }

    public void hit(PhysicalObject target) {
        System.out.println(this.toString() + " ударила: " + target.toString());
    }

    public void flinch() {
        System.out.println(this.toString() + " вздрогнул.");
    }

    public String toString() {
        return "Предмет";
    }
}
