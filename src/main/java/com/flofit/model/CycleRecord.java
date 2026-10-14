package com.flofit.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="cycle_records")
public class CycleRecord {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private LocalDate startDate; private LocalDate endDate;
 public CycleRecord() {} public CycleRecord(LocalDate s, LocalDate e){startDate=s;endDate=e;}
 public Long getId(){return id;} public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;} public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate v){endDate=v;}
}
