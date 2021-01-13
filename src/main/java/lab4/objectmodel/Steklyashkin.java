package lab4.objectmodel;

import java.lang.reflect.Method;

public class Steklyashkin extends Astronaut {
    Steklyashkin(boolean isUnderGravity) {
        super(isUnderGravity);
    }

    public String toString() {
        return "Стекляшкин";
    }

    public Object notice(Object object) {
        if (object.getClass().equals(MoonPolice.class)) {
            if (((MoonPolice) object).getWeapon().getClass().equals(Rifle.class)) {
                Object mistaken = new MoonPolice() {
                    public String toString() {
                        return "лунные полицейские вооружены палками";
                    }
                };
                System.out.println(this.toString() + " подумал, что " + mistaken.toString() + ".");
                return mistaken;
            }
        }
        return object;
    }

    public void notice(Object object, Method method) {
        if (object.toString().contains("вооружены")) {
            if (method.getName().contains("shoot"))
                System.out.println(this.toString() + " заметил, что " + object.toString() + ", из которых вырываются огоньки с облачками дыма.");
        }
    }


}
