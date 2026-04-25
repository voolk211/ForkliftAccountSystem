package org.example.forkliftaccountsystem.repository;

import org.example.forkliftaccountsystem.model.entity.Forklift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ForkliftRepository extends JpaRepository<Forklift, Long>, JpaSpecificationExecutor<Forklift> {

    boolean existsByNumber(String number);

    List<Forklift> findByNumberContainingIgnoreCase(String number);
}
