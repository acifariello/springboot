package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*RequestMapping() di default non specifica GET PUT POST perchè di default le mappa tutte.
    mappa le richieste "/greeting" al metodo greeting()*/
    @RequestMapping("/greeting") 
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        /* @RequestParam() lega il valore della parametro della query string "name"
        al valore del parametro "name" nel metodo greeting().
        Nel caso non ci sia il valore name allora viene usato il defaultValue */

        //viene convertito direttamente in un JSON.
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}