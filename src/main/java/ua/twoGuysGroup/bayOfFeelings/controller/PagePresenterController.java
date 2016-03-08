package ua.twoGuysGroup.bayOfFeelings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagePresenterController {

    @RequestMapping("/")
    public String s() {
        return "index";
    }

}
