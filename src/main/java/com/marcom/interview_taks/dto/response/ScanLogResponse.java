package com.marcom.interview_taks.dto.response;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.marcom.interview_taks.models.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ScanLogResponse {
    private String registrationId;
    private boolean isScanned;
    private LocalDateTime scanTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto user; 
}
