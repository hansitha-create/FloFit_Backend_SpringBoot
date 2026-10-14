package com.flofit.model;
import jakarta.persistence.*;
@Entity @Table(name="app_settings")
public class AppSettings {
 @Id private Long id=1L; private int averageCycleLength=28; private int averagePeriodLength=5;
 public Long getId(){return id;} public int getAverageCycleLength(){return averageCycleLength;} public void setAverageCycleLength(int v){averageCycleLength=v;} public int getAveragePeriodLength(){return averagePeriodLength;} public void setAveragePeriodLength(int v){averagePeriodLength=v;}
}
