package info.axes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args){
        ConfigurableApplicationContext ctx =SpringApplication.run(CinemaApplication.class, args);
    }
}
