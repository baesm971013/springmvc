package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParam(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age ={}",username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String username,
            @RequestParam("age") int memberAge){
        log.info("username = {}, age ={}",username, memberAge);
        return "request param v2";
    }

    @ResponseBody
    @RequestMapping("request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){
        log.info("username = {}, age ={}",username, age);
        return "request param v3";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username = {}, age ={}",username, age);
        return "request param v4";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){
        log.info("username = {}, age = {}",username,age);
        return "param-required";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String test(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = true, defaultValue = "-1") int age){
        log.info("username = {}, age = {}",username,age);
        return "param-required-default";
    }



}
