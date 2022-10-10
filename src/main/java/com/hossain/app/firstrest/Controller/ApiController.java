package com.hossain.app.firstrest.Controller;
import com.hossain.app.firstrest.Models.User;
import com.hossain.app.firstrest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ApiController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String ApiWelcome(){
        return "Welcome to controller to haditch world";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){ //here User the Model
        userRepo.save(user);
        return "Save done..";
    }
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirst_name(user.getFirst_name());
        updatedUser.setLast_name(user.getLast_name());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "Updated...";
    }
    //make the delete user controller
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "deleted user";
    }
}

