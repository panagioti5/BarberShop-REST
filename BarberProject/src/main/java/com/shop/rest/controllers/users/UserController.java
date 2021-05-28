package com.shop.rest.controllers.users;


import com.shop.rest.constants.UserOperationCodes;
import com.shop.rest.entities.UpdatePassword;
import com.shop.rest.entities.User;
import com.shop.rest.entities.UserDetails;
import com.shop.rest.interfaces.UserGenericIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserGenericIntf userService;

    @PostMapping("/isUserExists")
    public UserOperationCodes getUserExistence(@RequestBody UserDetails user) {
//        return userService.getUserExistence(user);
        return new UsersTemp().getUserExistence(user);
    }

    @PostMapping("/registerUser")
    public UserOperationCodes userRegistration(@RequestBody UserDetails user) {
//        return userService.registerUser(user);
        return new UsersTemp().registerUser(user);
    }

    @GetMapping("(/getAllUsersAREST/all/pac/v1")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/confirmAccount/{userEmail}/verify")
    public UserOperationCodes confirmAccount(@PathVariable String userEmail) {
//        return userService.confirmAccount(userEmail);
        return new UsersTemp().confirmAccount(userEmail);
    }


    @PostMapping("/resendVerification")
    public UserOperationCodes resendVerification(@RequestBody String email) {
//        return userService.resendVerification(email);
        return new UsersTemp().resendVerification(email);
    }

    @PostMapping("/userDetails")
    public UserDetails userDetails(@RequestBody UserDetails user) {
//        return userService.userDetails(user);
        return new UsersTemp().userDetails(user);
    }

    @PostMapping("/forgotPassword")
    public UserOperationCodes forgotPassword(@RequestBody UserDetails user) {
//        return userService.forgotPassword(user);
        return new UsersTemp().forgotPassword(user);
    }

    @PostMapping("/updateToken")
    public UserOperationCodes updateToken(@RequestBody UpdatePassword updatePassword) {
//        return userService.updateToken(updatePassword);
        return new UsersTemp().updateToken(updatePassword);

    }

    @PostMapping("/userDetails/update")
    public UserOperationCodes userDetailsUpdate(@RequestBody UserDetails user) {
        return new UsersTemp().updateUser(user);
    }

    @GetMapping("/temp")
    public UserDetails temp() {
        return new UserDetails();
    }

    @GetMapping("/clearBatchData")
    public void clearAllData(@RequestParam(value = "batch", required = true) String eraseMethod) {
        new UsersTemp().clearAll(eraseMethod);
    }


}