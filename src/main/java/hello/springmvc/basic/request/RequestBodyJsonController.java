package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void V1(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ServletInputStream inputStream = request.getInputStream();
        String mBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("message, = {}", mBody);
        HelloData data = objectMapper.readValue(mBody, HelloData.class);
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String V2(@RequestBody String mBody) throws IOException{
        HelloData data = objectMapper.readValue(mBody,HelloData.class);
        log.info("username={}, age={}", data.getUsername(), data.getAge());
        return "v2";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String V3(@RequestBody HelloData data){
        log.info("user name = {}, age= {}",data.getUsername(), data.getAge());
        return "v3";
    }


}
