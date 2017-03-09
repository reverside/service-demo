package za.co.reverside.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @RequestMapping(value = "api/test")
    public String hello() {
        return "Hello world";
    }

}
