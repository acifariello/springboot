import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController //questa classe è un Web Controller
@EnableAutoConfiguration /*dice a springboot di "intuire" come vorrai configurare Spring.
                           Nel nostro caso "intuirà" che stiamo sviluppando una web-application*/
public class Example {
    @RequestMapping("/") //usato per il routing :ogni richiesta HTTP con path "/" viene mappata al metodo home().
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}