package niit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ServletComponentScan("service")
@RequestMapping("/")
public class DemoApplication {

    @RequestMapping("/hello")
    public  String hello(){
        return "Hello Lucky Symbol";
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}
