package com.flofit.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="daily_logs")
public class DailyLog {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private LocalDate date;
 private String energy="medium", mood="calm", cramps="none", fatigue="none", bloating="none"; private boolean headache,dizziness; private String flow="none";
 @Column(length=500) private String notes="";
 public Long getId(){return id;} public LocalDate getDate(){return date;} public void setDate(LocalDate v){date=v;}
 public String getEnergy(){return energy;} public void setEnergy(String v){energy=v;} public String getMood(){return mood;} public void setMood(String v){mood=v;}
 public String getCramps(){return cramps;} public void setCramps(String v){cramps=v;} public String getFatigue(){return fatigue;} public void setFatigue(String v){fatigue=v;}
 public String getBloating(){return bloating;} public void setBloating(String v){bloating=v;} public boolean isHeadache(){return headache;} public void setHeadache(boolean v){headache=v;}
 public boolean isDizziness(){return dizziness;} public void setDizziness(boolean v){dizziness=v;} public String getFlow(){return flow;} public void setFlow(String v){flow=v;}
 public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
}
