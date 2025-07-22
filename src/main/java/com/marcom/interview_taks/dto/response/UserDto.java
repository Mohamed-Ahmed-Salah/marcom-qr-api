package com.marcom.interview_taks.dto.response;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long Id;
    private String registrationId;
    private String fullName;
    private String email;
    private String mobile;
    private String jobTitle;
    private String company;// Add only the fields you want to expose
}

