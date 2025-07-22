package com.marcom.interview_taks.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcom.interview_taks.models.UserModel;
import com.marcom.interview_taks.services.UserService;

import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        List<UserModel> dummyUsers = List.of(
            UserModel.builder()
                .registrationId("REG12345")
                .fullName("Abdelrahman Bakeer")
                .email("a.bakeer@marcom.com")
                .mobile("+966558121122")
                .jobTitle("Software Engineer")
                .company("Marcom Arabia")
                .build(),

            UserModel.builder()
                .registrationId("REG12346")
                .fullName("Basil Jaber")
                .email("basil@marcom.com")
                .mobile("+966558121133")
                .jobTitle("Software Engineer")
                .company("Marcom Arabia")
                .build(),

            UserModel.builder()
                .registrationId("REG12347")
                .fullName("Asim Alswiae")
                .email("asim.alshwie@marcom.com")
                .mobile("+966558121133")
                .jobTitle("Product Manager")
                .company("Marcom Arabia")
                .build(),

                

            UserModel.builder()
                .registrationId("REG12348")
                .fullName("Omar AlFarsi")
                .email("o.alfarsi@marcom.com")
                .mobile("+966558121144")
                .jobTitle("Data Analyst")
                .company("Marcom Arabia")
                .build(),

                UserModel.builder()
                .registrationId("REG12349")
                .fullName("Raneen Balsharaf")
                .email("r.bsharaf@marcom.com")
                .mobile("+966558121155")
                .jobTitle("HR")
                .company("Marcom Arabia")
                .build()
        );

        userService.saveUsersIfNotExist(dummyUsers);
    }
}
