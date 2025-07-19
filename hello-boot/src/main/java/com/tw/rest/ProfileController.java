package com.tw.rest;

import com.tw.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

//    http://localhost:8080/profile/add?fullName=Surbhi&age=45&salary=89.00
    @GetMapping(value = "/pro", produces = "application/json")
    public Profile getProfile(@RequestParam String fullName, @RequestParam int age, @RequestParam double salary) {
        Profile profile = new Profile();
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setSalary(salary);
        System.out.println(profile);
        return profile;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public String addProfile(@RequestBody Profile profile) {
        return "Profile added successfully!" + profile.getFullName();
    }


}
