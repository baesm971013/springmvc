package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

// http 메세지 바디에 직접 입력해서 반환하는 방법
@Slf4j
@Controller
public class ResponseBodyController {
    @GetMapping("/response-body-string-v1")
    public void V1(HttpServletResponse response) throws IOException{
        response.getWriter().write("ok");
    }
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> V2(){
        return new ResponseEntity<>("v2", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String V3(){
        return "v3";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> V4(){
        HelloData helloData = new HelloData();
        helloData.setUsername("baesm");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData V5(){
        HelloData helloData = new HelloData();
        helloData.setUsername("baesm");
        helloData.setAge(20);
        return helloData;
    }

}
