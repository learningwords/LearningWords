package es.jesus.learningwords.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by jesus on 27/08/15.
 */
@RestController
public class LoginController {

    /**
     * Request was able to reach this code through Spring Security
     * therefore, the login was success
     *
     * @param session
     * @return "ok"
     */
    @RequestMapping("/login")
    public String greeting(HttpSession session) {
        return "ok";
    }
}
