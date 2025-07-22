package com.marcom.interview_taks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marcom.interview_taks.dto.response.GeneralResponse;
import com.marcom.interview_taks.services.ScanLogService;

@RestController
@RequestMapping("/scan")
public class ScanLogController {
    
    @Autowired
    private ScanLogService scanLogService;
    
    @PostMapping("/{registrationId}")
    public ResponseEntity<GeneralResponse> processScan(@PathVariable String registrationId) {

        return scanLogService.processScan(registrationId);
    }
    @GetMapping("/all")
    public ResponseEntity<GeneralResponse> findAll( @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return scanLogService.findAll(page,size);
    }


     @GetMapping("/registration/{registrationId}")
    public ResponseEntity<GeneralResponse> getScansByRegistrationId(
            @PathVariable String registrationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
                return scanLogService.getScansByRegistrationId(registrationId,page,size);

            }
}
