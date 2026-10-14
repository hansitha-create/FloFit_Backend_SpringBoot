package com.flofit.repository;
import com.flofit.model.CycleRecord; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.Optional;
public interface CycleRecordRepository extends JpaRepository<CycleRecord,Long>{ Optional<CycleRecord> findByStartDate(LocalDate date); }
