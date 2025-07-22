package com.marcom.interview_taks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScanLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_id", nullable = false)
    private String registrationId;
    
    // the relationship optional if user isnt found...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id") 
    private UserModel userModel;

    @Column(name = "is_scanned")
    private boolean isScanned; // "Yes" or "No"
    @Column(name = "scan_time")
    private LocalDateTime scanTime;

}
