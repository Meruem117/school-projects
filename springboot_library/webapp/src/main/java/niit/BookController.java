package niit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class BookController {
    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/read")
    public Book book(@RequestParam(value = "cate", defaultValue = "") String cate) {
        log.info("{},{}", counter.incrementAndGet(), cate);
        return new Book(counter.incrementAndGet(), String.format(template, cate));
    }
}
