package com.App.HMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.HMS.model.UserModel;


@Repository
public interface UserModelRepo extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);
    }
