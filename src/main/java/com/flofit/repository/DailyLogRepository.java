package com.flofit.repository;
import com.flofit.model.DailyLog; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.*;
public interface DailyLogRepository extends JpaRepository<DailyLog,Long>{ Optional<DailyLog> findByDate(LocalDate date); List<DailyLog> findByDateBetweenOrderByDateDesc(LocalDate from,LocalDate to); List<DailyLog> findAllByOrderByDateDesc(); }
