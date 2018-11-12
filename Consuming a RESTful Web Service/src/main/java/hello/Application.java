/*
SENZA USARE SPRINGBOOT

package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {

        /*RestTemplate prende i dati dal nostro Spring Boot quotation service.
        La libreria Jackson JSON è nel classpath, RestTemplate la usa per convertire
        il JSON in un oggetto Quote. Qui usiamo RestTemplate per una HTTP GET request, 
        ma supporta anche altre operazioni HTTP, come POST, PUT, DELETE.*/
       
       /* RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    }

}

*/

//USANDO SPRINGBOOT
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
    
    /*RestTemplate prende i dati dal nostro Spring Boot quotation service.
        La libreria Jackson JSON è nel classpath, RestTemplate la usa per convertire
        il JSON in un oggetto Quote. Qui usiamo RestTemplate per una HTTP GET request, 
        ma supporta anche altre operazioni HTTP, come POST, PUT, DELETE.*/
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    /*Estraiamo RestTemplate in un @Bean così è più semplice testarlo.*/
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}