package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@SpringBootApplication aggiunge tutte le annotazioni seguenti :

@Configuration : marca la classe come una sorgente di definizioni di bean per il contesto dell'applicazione.

@EnableAutoConfiguration : dice a Spring Boot di iniziare ad aggiungere beans.

@ComponentScan :  dice a Spring di trovare altre componenti, configurazioni e servizi nel package hello. 
*/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}