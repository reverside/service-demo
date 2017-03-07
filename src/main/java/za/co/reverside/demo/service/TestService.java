package za.co.reverside.demo.service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TestService {

    @RequestMapping(path = "api/test", method = RequestMethod.GET, produces = "text/plain")
    public String test() {
        return "Hello world";
    }

}
