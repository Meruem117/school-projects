package niit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IndexController{

    public void log(long id, String region) {
        log.info("{},{}", id, region);
    }
}
