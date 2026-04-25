package org.example.forkliftaccountsystem.repository;

import org.example.forkliftaccountsystem.model.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long>, JpaSpecificationExecutor<Incident> {

    List<Incident> findByForkliftIdOrderByStartTimeDesc(Long id);

    boolean existsByForklift_Id(Long forkliftId);
}
