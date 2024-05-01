package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("hell basic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappinggetv1");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mapping = {}", data);
        return "ok";
    }
    @GetMapping("/check/{alias}")
    public String mapAlias(@PathVariable("alias") String data){
        log.info("alias is  = {}",data);
        return "alias ok";
    }
    /*
    path variable 다중으로 사용하기
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mapsping path userId = {}, orderID = {}",userId, orderId);
        return userId;
    }



}
