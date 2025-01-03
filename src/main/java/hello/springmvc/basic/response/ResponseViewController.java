package hello.springmvc.basic.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView test1(){
        ModelAndView mv = new ModelAndView("response/hello");
        mv.addObject("data","hello");
        return mv;
    }

    @RequestMapping("/response-view-v2")
    public String test2(Model model){
        model.addAttribute("data","hello");
        return "response/hello";
    }
}
