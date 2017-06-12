package com.manoj.microservice.oauth.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by synerzip on 22/5/17.
 */
@RestController
public class OAuthUserController {

    @RequestMapping("/me")
    @ResponseBody
    public Principal getCurrentLoggedInUser(Principal user){
        return user;
    }
}
