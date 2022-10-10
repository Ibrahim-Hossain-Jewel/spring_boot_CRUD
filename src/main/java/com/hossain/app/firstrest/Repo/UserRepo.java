package com.hossain.app.firstrest.Repo;

import com.hossain.app.firstrest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
