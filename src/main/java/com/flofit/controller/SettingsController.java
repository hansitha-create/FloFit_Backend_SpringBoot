package com.flofit.controller;
import com.flofit.model.AppSettings; import com.flofit.repository.AppSettingsRepository; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestController @RequestMapping("/api/settings")
public class SettingsController {
 private final AppSettingsRepository repo; public SettingsController(AppSettingsRepository r){repo=r;}
 @GetMapping public AppSettings get(){return repo.findById(1L).orElseGet(this::defaults);}
 @PutMapping public AppSettings update(@RequestBody Map<String,Object>b){int c=num(b.get("averageCycleLength"),28),p=num(b.get("averagePeriodLength"),5);if(c<20||c>45)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Average cycle length must be between 20 and 45 days.");if(p<2||p>10)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Average period length must be between 2 and 10 days.");AppSettings s=repo.findById(1L).orElseGet(this::defaults);s.setAverageCycleLength(c);s.setAveragePeriodLength(p);return repo.save(s);}
 private AppSettings defaults(){return repo.save(new AppSettings());} private int num(Object v,int d){try{return Integer.parseInt(String.valueOf(v));}catch(Exception e){return d;}}
}
