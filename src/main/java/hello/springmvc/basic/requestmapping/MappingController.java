package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloworld");
        return "hello";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingV2(){
        log.info("hellowrold");
        return "ok";
    }

    /**
     *
     * @param data
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info(data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathV2(@PathVariable String userId, @PathVariable String orderId){
        log.info("order name : {}, order id :{}", userId, orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers="mode=debug")
    public String test3(){
        log.info("header-test");
        return "ok";
    }

    @PostMapping(value="/mapping-consume", consumes = "application/json")
    public String consumeTest(){
        log.info("only works in application json format");
        return "ok";
    }
}
