package com.marcom.interview_taks.repo;

import com.marcom.interview_taks.models.ScanLog;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScanLogRepo extends JpaRepository<ScanLog, Long> {
  Page<ScanLog> findAll(Pageable pageable);
    Page<ScanLog> findByRegistrationId(String registrationId, Pageable pageable);

    
}
