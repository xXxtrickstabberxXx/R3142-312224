package lab4.objectmodel;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Rocket extends SpaceCraft {
    public Team team = new Team(false);
    public ControlPanel controlPanel = new ControlPanel();
    private Node location = null;

    public void flinch() {
        System.out.println("Ракета вздрогнула.");
        this.controlPanel.breakDown();
    }

    public String toString() {
        return "Ракета";
    }

    public void getUnderFire(Fire fire, Location location) {
        this.controlPanel.fireAlert(fire, location);
    }

    public void landOn(Node place, Map map) throws PlaceDoesNotExistException, UnableToLandException {
        if (map.checkLocation(place)) {
            if (place.getAbleToLand()) {
                this.location = place;
                System.out.println("Ракета прилунилась над: " + place.toString() + ".");
            } else {
                throw new UnableToLandException("Приземление невозможно.");
            }
        } else {
            throw new PlaceDoesNotExistException("Локации не существует!");
        }
    }

    public void fly(Node place, Map map) throws PlaceDoesNotExistException {
        if (map.checkLocation(place)) {
            this.location = place;
            System.out.println("Ракета пролетает над " + place.toString() + ".");
        } else {
            throw new PlaceDoesNotExistException("Локации не существует!");
        }
    }

    public enum ControlStatus {
        OK,
        LOST
    }

    public class ControlPanel implements Controls {
        protected Location fireLocation = null;
        protected boolean isUnderFire = false;
        protected ControlStatus controlStatus = ControlStatus.OK;
        protected int speed = 10;
        protected boolean flightStability = true;

        public boolean stabilityCheck() {
            return this.flightStability;
        }

        public boolean fireCheck() {
            return this.isUnderFire;
        }

        public void fireAlert(Fire fire, Location location) {
            System.out.println("Ракета находится под обстрелом " + location.toString() + ".");
            this.isUnderFire = true;
            this.fireLocation = location;
        }

        public void speedRise(int increase) {
            this.speed += increase;
            System.out.println("Скорость ракеты увеличена.");
        }

        public void breakDown() {
            controlStatus = ControlStatus.LOST;
            System.out.println("Управление ракетой потеряно.");
            deviationAngle = 90 + new Random().nextInt(90);
            System.out.println("Ракета переворачивается в воздухе.");
            if (team.isUnderGravity) {
                team.fall();
            }
            this.flightStability = false;
            System.out.println("Полет дестабилизирован.");
        }

        public void rotationMechanism(int angle) {
            System.out.println("Механизм поворота включен.");
            deviationAngle += angle;
            if (deviationAngle == 0) System.out.println("Вращательное движение остановлено.");
        }

        public void recovery() {
            controlStatus = ControlStatus.OK;
            this.flightStability = true;
            System.out.println("Полет стабилизировн.");
        }

        public void descension(int Y) {
            posY -= Y;
            System.out.println("Ракета идёт на снижение.");
        }
    }

    public class Team extends Astronaut implements Crew {
        public Pilot znayka = new Znayka(this.isUnderGravity);
        public Astronaut steklyashkin = new Steklyashkin(this.isUnderGravity);
        Astronaut[] astronauts = {znayka, steklyashkin};
        private Place location = Place.SEATS;

        Team(boolean isUnderGravity) {
            super(isUnderGravity);
        }

        public void confuse() {
            for (Astronaut astronaut : astronauts) {
                astronaut.confuse();
            }
        }

        public void wakeup() {
            for (Astronaut astronaut : astronauts) {
                astronaut.wakeup();
            }
        }

        public void fall() {
            System.out.println("Космонавты попадали со своих мест.");
            this.confuse();
            znayka.wakeup();
        }

        public void goTo(Place place) {
            location = place;
            System.out.println("Команда пошла к: " + place.getName() + ".");
        }

        public void turnOnRotation(Controls controlpanel) {
            if ((this.location).equals(Place.CONTROLPANEL)) {
                controlpanel.rotationMechanism(90);
                System.out.println("Команда включила механизм поворота.");
                System.out.println("Вращательное движение ракеты остановлено.");
            }
        }

    }
}