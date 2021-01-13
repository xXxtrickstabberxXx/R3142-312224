package lab4.objectmodel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Weapon rifle() {
        return new Rifle();
    }

    @Bean
    public Rocket rocket() {
        return new Rocket();
    }

    @Bean
    public MoonPolice moonpolice() {
        return new MoonPolice();
    }

    @Bean
    public MoonAstronauts moonastronauts() {
        return new MoonAstronauts();
    }

    @Bean
    public Map map() {
        return new Map();
    }

}
