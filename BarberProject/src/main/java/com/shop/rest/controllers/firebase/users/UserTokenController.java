package com.shop.rest.controllers.firebase.users;


import com.shop.rest.entities.PushNotificationUsers;
import com.shop.rest.interfaces.UserGenericIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTokenController {

    @Autowired
    UserGenericIntf userService;


    @PostMapping("/setPushToken")
    public void saveUnknownToken(@RequestBody PushNotificationUsers pushToken) {
//        userService.savePushToken(pushToken);
    }

}
