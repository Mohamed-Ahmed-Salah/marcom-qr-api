package com.marcom.interview_taks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcom.interview_taks.config.Constant;
import com.marcom.interview_taks.dto.response.GeneralResponse;
import com.marcom.interview_taks.models.UserModel;
import com.marcom.interview_taks.repo.UserRepo;

@Service
public class UserService {
      @Autowired
    private UserRepo userRepository;

     public void saveUsersIfNotExist(List<UserModel> users) {
        for (UserModel user : users) {
            if (!userRepository.existsByRegistrationId(user.getRegistrationId())) {
                userRepository.save(user);
            }
        }
    }


    public GeneralResponse  getAllUsers() {
        return new GeneralResponse<>(Constant.ResponseCode.Success.CODE, Constant.ResponseCode.Success.MSG, userRepository.findAll());
    }
    
}

