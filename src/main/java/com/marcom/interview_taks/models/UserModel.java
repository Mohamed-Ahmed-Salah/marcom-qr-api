package com.marcom.interview_taks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotEmpty
    @NonNull
    @Column(unique = true,name = "registration_id")
    private String registrationId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="mobile")
    private String mobile;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "company")
    private String company;
}

