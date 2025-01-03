package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.requestmapping.HelloData;
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

@Controller
@Slf4j
public class RequestBodyJsonController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info(messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info(String.valueOf(helloData));
        response.getWriter().write("ok");

    }
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String test2(@RequestBody String messageBody) throws IOException {

        log.info(messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info(String.valueOf(helloData));
        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String test3(@RequestBody HelloData helloData) throws IOException {

        log.info(String.valueOf(helloData));
        return "ok";

    }
}
