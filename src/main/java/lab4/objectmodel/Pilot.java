package lab4.objectmodel;

public abstract class Pilot extends Astronaut {

    Pilot(boolean isUnderGravity) {
        super(isUnderGravity);
    }

    public void turnOnRotation(Controls controlPanel) {
        if (controlPanel.stabilityCheck()) {
            controlPanel.rotationMechanism(90);
            System.out.println(this.toString() + " включил механизм поворота.");
            System.out.println("Вращательное движение ракеты остановлено.");
            System.out.println("Полет стабилизирован.");
        }
    }

    public void fixControls(Controls controlPanel) {
        controlPanel.recovery();
    }

    public void goDown(Controls controlPanel, int lowerY) {
        System.out.println(this.toString() + " повел ракету на снижение.");
        controlPanel.descension(lowerY);
    }

    public void saveRocket(int speedincrease, Controls controlPanel) {
        if (controlPanel.fireCheck()) {
            controlPanel.speedRise(speedincrease);
            System.out.println(this.toString() + " вывел ракету из под обстрела.");
        } else System.out.println("Ракете ничего не угрожает.");
    }
}
