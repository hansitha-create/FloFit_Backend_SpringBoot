package com.flofit.controller;
import com.flofit.model.CycleRecord; import com.flofit.repository.CycleRecordRepository; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.time.LocalDate; import java.util.*;
@RestController @RequestMapping("/api/cycles")
public class CycleController {
 private final CycleRecordRepository repo; public CycleController(CycleRecordRepository r){repo=r;}
 @GetMapping public List<CycleRecord> all(){return repo.findAll().stream().sorted((a,b)->b.getStartDate().compareTo(a.getStartDate())).toList();}
 @PostMapping public CycleRecord save(@RequestBody Map<String,String> b){LocalDate s=parse(b.get("startDate")); String ev=b.getOrDefault("endDate",""); LocalDate e=ev==null||ev.isBlank()?null:parse(ev); if(e!=null&&e.isBefore(s))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"End date must be on or after start date."); CycleRecord c=repo.findByStartDate(s).orElse(new CycleRecord(s,e)); c.setEndDate(e); return repo.save(c);}
 @DeleteMapping("/{id}") public Map<String,Boolean> delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Period record not found.");repo.deleteById(id);return Map.of("ok",true);}
 private LocalDate parse(String s){try{return LocalDate.parse(s);}catch(Exception e){throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please provide a valid date in YYYY-MM-DD format.");}}
}
