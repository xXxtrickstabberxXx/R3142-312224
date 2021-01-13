package lab4.objectmodel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MoonAstronauts {
    private List<Event> surprisingEvents = new ArrayList<Event>();

    public void beSurprised(Event event) {
        if (surprisingEvents.contains(event)) {
            System.out.println("Событие ''" + event.getDescription() + "'' удивило лунных астрономов.");
        } else {
            System.out.println("Событие ''" + event.getDescription() + "'' не удивило лунных астрономов.");
        }
    }

    public void addSurprisingEvent(Event event) {
        this.surprisingEvents.add(event);
    }

    public Node getLandingLocation(Rocket rocket){
        try {
            Field field = Rocket.class.getDeclaredField("location");
            field.setAccessible(true);
            Node location = (Node) field.get(rocket);
            System.out.println("Лунный астронавты засекли ракету в локации: " + location.toString());
            return location;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Не удалось засечь ракету");
            e.printStackTrace();
            return null;
        }
    }

    public void setTelescopesNear(Map.Town town, Object target, Map map){
        town.setTelescope(target);
        Roads roads = town.getConnections();
        for (Node i: roads.getNodes()){
            if (i.getClass().getName() == "lab4.objectmodel.Map$Town"){
                Map.Town selected = (Map.Town) i;
                selected.setTelescope(target);
            }
        }
    }
}
