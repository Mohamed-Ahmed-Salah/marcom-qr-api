package com.marcom.interview_taks.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse<T> {

    int code;
    String message;
    T data;

}

