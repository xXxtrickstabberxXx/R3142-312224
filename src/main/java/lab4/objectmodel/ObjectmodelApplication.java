package lab4.objectmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.lang.reflect.Method;

@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Config.class)})
public class ObjectmodelApplication {

    //пофиксить пилота
    public static void main(String[] args) {
        SpringApplication.run(ObjectmodelApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Map map = (Map) context.getBean(Map.class);
        Rocket rocket = (Rocket) context.getBean(Rocket.class);
        MoonPolice moonpolice = (MoonPolice) context.getBean(MoonPolice.class);
        rocket.team.znayka.goDown(rocket.controlPanel, 20);
        rocket.team.steklyashkin.see(Place.ROOF, moonpolice);
        Object mistakenRifle = rocket.team.steklyashkin.notice(moonpolice);
        try {
            Fire fire = moonpolice.shootAtRocket(rocket, Location.BOTTOM);
            Method shooting = moonpolice.getClass().getDeclaredMethod("shootAtRocket", Rocket.class, Location.class);
            rocket.team.steklyashkin.notice(mistakenRifle, shooting);
            fire.hit(1);
        } catch (NoSuchMethodException e) {
            System.out.println("ноусачметодэксепшон");
        }
        rocket.team.znayka.goTo(Place.CONTROLPANEL);
        rocket.team.znayka.fixControls(rocket.controlPanel);
        rocket.team.znayka.turnOnRotation(rocket.controlPanel);
        rocket.team.znayka.checkForFire(rocket.controlPanel);
        rocket.team.znayka.saveRocket(10000, rocket.controlPanel);


        MoonAstronauts moonastronauts = (MoonAstronauts) context.getBean(MoonAstronauts.class);

        try {
            rocket.landOn(map.getPlacesList().get(0), map);
        } catch (PlaceDoesNotExistException e) {
            e.printStackTrace();
        }

        Node location = moonastronauts.getLandingLocation(rocket);
        Spruts spruts = new Spruts();
        try {
            rocket.fly(map.getPlacesList().get(0), map);
            try {
                Method landing = rocket.getClass().getDeclaredMethod("fly", Node.class, Map.class);
                Event event = new Event(rocket, landing, "появление ракеты над Фантомасом");

                moonastronauts.beSurprised(event);
                moonastronauts.setTelescopesNear((Map.Town) location, rocket, map);
                spruts.hearAbout(event, location);
                spruts.empowerPolice((Map.Town) location);

            } catch (NoSuchMethodException e) {
                System.out.println("ноусачметодэксепшон");
            }
        } catch (PlaceDoesNotExistException e) {
            e.printStackTrace();
        }

        try{
            rocket.fly(map.getPlacesList().get(1), map);
            rocket.fly(map.getPlacesList().get(6), map);
            rocket.fly(map.getPlacesList().get(8), map);
            rocket.landOn(map.getPlacesList().get(4), map);
        } catch (PlaceDoesNotExistException | UnableToLandException e) {
            e.printStackTrace();
        }

    }
}
