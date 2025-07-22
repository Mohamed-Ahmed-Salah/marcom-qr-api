package com.marcom.interview_taks.services;
import com.marcom.interview_taks.config.Constant;
import com.marcom.interview_taks.dto.response.GeneralResponse;
import com.marcom.interview_taks.dto.response.ScanLogResponse;
import com.marcom.interview_taks.dto.response.UserDto;
import com.marcom.interview_taks.models.ScanLog;
import com.marcom.interview_taks.models.UserModel;
import com.marcom.interview_taks.repo.ScanLogRepo;
import com.marcom.interview_taks.repo.UserRepo;
import org.springframework.data.domain.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScanLogService {
    
    @Autowired
    private ScanLogRepo scanLogRepository;
    
    
    @Autowired
    private UserRepo userRepository;
    
    
    public ResponseEntity<GeneralResponse> processScan(String registrationId) {
        Optional<UserModel> user = userRepository.getUserByRegistrationId(registrationId);
        ScanLog scanLog= new ScanLog();
        GeneralResponse generalResponse =new GeneralResponse<>();
        ResponseEntity<GeneralResponse> responseEntity;


        if(user.isPresent()){
            scanLog.setUserModel(user.get());
            scanLog.setScanTime(LocalDateTime.now());
            scanLog.setScanned(true);
            scanLog.setRegistrationId(registrationId);
            generalResponse.setCode(Constant.ResponseCode.Success.CODE);
            generalResponse.setMessage(Constant.ResponseCode.Success.MSG);
            generalResponse.setData(user.get());
            responseEntity = ResponseEntity.ok(generalResponse);


        }else{
            scanLog.setUserModel(null);
            scanLog.setScanTime(LocalDateTime.now());
            scanLog.setScanned(false);
            scanLog.setRegistrationId(registrationId);
            generalResponse.setCode(Constant.ResponseCode.Failure.NOT_FOUND);
            generalResponse.setMessage(Constant.ResponseCode.Failure.NOT_FOUND_MSG);
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(generalResponse);

        }

        scanLogRepository.save(scanLog);
        
        return responseEntity;
    }
    public ResponseEntity<GeneralResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ScanLog> scans=scanLogRepository.findAll(pageable);
        
        
        Page<ScanLogResponse> scanLogResponse=scans.map(scanLog -> {
        UserDto userDto = null;

        if (scanLog.getUserModel() != null) {
            UserModel userModel = scanLog.getUserModel();
            userDto=new UserDto();
            BeanUtils.copyProperties(userModel, userDto);
        }
        return new ScanLogResponse(
            scanLog.getRegistrationId(),
            scanLog.isScanned(),
            scanLog.getScanTime(),
            userDto 
        );
    });
        GeneralResponse response = new GeneralResponse();
        response.setCode(Constant.ResponseCode.Success.CODE);
        response.setMessage(Constant.ResponseCode.Success.MSG);
        response.setData(scanLogResponse.getContent());
        
        return ResponseEntity.ok(response);
    }

     public ResponseEntity<GeneralResponse> getScansByRegistrationId(String registrationId,int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ScanLog> scans=scanLogRepository.findByRegistrationId(registrationId, pageable);
         Page<ScanLogResponse> scanLogResponse=scans.map(scanLog -> {
            UserDto userDto = null;

        if (scanLog.getUserModel() != null) {
            UserModel userModel = scanLog.getUserModel();
            userDto=new UserDto();
            BeanUtils.copyProperties(userModel, userDto);
        }
        return new ScanLogResponse(
            scanLog.getRegistrationId(),
            scanLog.isScanned(),
            scanLog.getScanTime(),
            userDto );
    });
        GeneralResponse response = new GeneralResponse();
        response.setCode(Constant.ResponseCode.Success.CODE);
        response.setMessage(Constant.ResponseCode.Success.MSG);
        response.setData(scanLogResponse.getContent());
        
        return ResponseEntity.ok(response);
    }
    
    
   
}
