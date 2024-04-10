package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic")
    public String helloBasic(){
        log.info("basic");
        return "ok";
    }
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mapping get v1");
        return "ok";
    }
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping get v2");
        return "ok";
    }

    // 경로변수로 사용하는 추세가 많이 늘어난다
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mapping path userId = {}", userId);
        return "ok";
    }
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathV2(@PathVariable String userId, @PathVariable Long orderId){
        log.info("userId = {} , orderId = {}", userId, orderId);
        return "ok";
    }
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingconsumes");
        return "ok";
    }
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces(){
        log.info("mapping produces");
        return "ok";
    }


}
