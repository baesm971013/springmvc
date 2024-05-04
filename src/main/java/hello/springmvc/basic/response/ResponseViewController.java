package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView rV1(){
        ModelAndView mav = new ModelAndView("response/hello").addObject("data","hellosumin");
        return mav;
    }
    @RequestMapping("/response-view-v2")
    public String V2(Model model){
        // 실행시키면 /response-view-v2 에서 model의  data의 "this is v2" 입력하고 반환한다
        model.addAttribute("data","this is v2");
        return "/response/hello";
    }

    @RequestMapping("/response/hello")
    public void V3(Model model){
        model.addAttribute("data","v3");
    }
}
