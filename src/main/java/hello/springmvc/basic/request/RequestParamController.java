package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("user name : {} age : {}", username, age);
        response.getWriter().write("ok");
    }

    //controller view 대신 그냥 restcontroller 같은 방식으로 쓸수 있는거
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username, @RequestParam("age") int memberAge){
        log.info("user name : {} age : {}", username, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age){
       log.info("user name : {} age : {}", username, age);
       return "v3 ok";

   }
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("user name : {} age : {}", username, age);
        return "v4 ok";

    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requiredParam(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) int age,
            @RequestParam(required = false) Integer kg
    ) {
        return "return required";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "hello") String username,
            @RequestParam(required = false, defaultValue = "10") Integer age
    ){
        log.info("username : {} age : {}", username, age);
        return "default-value ok ";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamDefault(@RequestParam Map<String, Object> paramMap){
        log.info("username : {} age : {}", paramMap.get("username"), paramMap.get("age"));
        return "default-value ok ";
    }


}
