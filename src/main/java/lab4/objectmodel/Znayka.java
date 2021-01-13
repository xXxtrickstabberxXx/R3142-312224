package lab4.objectmodel;

public class Znayka extends Pilot implements Crew {

    Znayka(boolean isUnderGravity) {
        super(isUnderGravity);
    }

    public String toString() {
        return "Знайка";
    }

    public boolean equals(Object object) {
        if (object instanceof Znayka)
            return (object.toString().equals(this.toString()));
        return false;
    }

    public void wakeup() {
        this.isConfused = false;
        System.out.println("Знайка очнулся первым.");
    }


}
