package lab4.objectmodel;

public class Spruts {
    public void hearAbout(Event event, Node place) {
        System.out.println("Спрутс узнал о событии: " + event.getDescription());
    }

    public void empowerPolice(Map.Town town) {
        System.out.println("Спрутс приказал усилить отряды полиции рядом с городом " + town.getName());
        town.empowerPolice();
        Roads roads = town.getConnections();
        for (Node i : roads.getNodes()) {
            if (i.getClass().getName() == "lab4.objectmodel.Map$Town") {
                Map.Town selected = (Map.Town) i;
                selected.empowerPolice();
            }
        }
    }

}
