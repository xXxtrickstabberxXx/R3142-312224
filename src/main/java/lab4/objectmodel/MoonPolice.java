package lab4.objectmodel;

import org.springframework.beans.factory.annotation.Autowired;

public class MoonPolice {
    @Autowired
    private Weapon rifle;

    public String toString() {
        return ("лунных полицейских, вооруженных " + rifle.toString());
    }

    public Weapon getWeapon() {
        return this.rifle;
    }

    public Fire shootAtRocket(Rocket target, Location location){
            Fire fire = new Fire(target, location);
            return fire;
    }
}
