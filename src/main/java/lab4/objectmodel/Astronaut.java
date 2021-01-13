package lab4.objectmodel;

import java.lang.reflect.Method;

public abstract class Astronaut extends PhysicalObject implements Crew {
    protected Place location = Place.SEATS;
    protected boolean isConfused = false;

    Astronaut(boolean isUnderGravity) {
        super(isUnderGravity);
    }

    public void confuse() {
        this.isConfused = true;
    }

    public Place getLocation() {
        return this.location;
    }

    public void wakeup() {
        this.isConfused = false;
        System.out.println(this.toString() + " очнулся.");
    }

    public String toString() {
        return "Ноунейм";
    }

    public void goTo(Place place) {
        this.location = place;
        System.out.println(this.toString() + " посдкочил к: " + place.getName() + ".");
    }

    public void checkForFire(Rocket.ControlPanel controlPanel) {
        if (controlPanel.isUnderFire) {
            System.out.println(this.toString() + " убедился, что стрельба " + controlPanel.fireLocation.toString() + " продолжается.");
        }
    }

    public Object see(Place place, Object object) {
        System.out.println(this.toString()+" увидел "  + place.getName() +" " + object.toString() + ".");
        return object;
    }

    public Object see(Object object) {
        System.out.println(this.toString()+" увидел " + object.toString() + ".");
        return object;
    }

    public Object notice(Object object){
        return object;
    }

    public void notice(Object object, Method method){
    }
}
