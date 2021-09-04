package niit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class RegionController {
    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/func")
    public Region region(@RequestParam(value = "region", defaultValue = "Shanghai") String region) {
        log.info("{},{}", counter.incrementAndGet(), region);
        return new Region(counter.incrementAndGet(), String.format(template, region));
    }
}
