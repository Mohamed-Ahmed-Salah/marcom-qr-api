package com.marcom.interview_taks.repo;

import com.marcom.interview_taks.models.UserModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    Boolean existsByRegistrationId(String registrationId);
    Optional<UserModel> getUserByRegistrationId(String registrationId);


}
