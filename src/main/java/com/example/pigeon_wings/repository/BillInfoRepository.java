package com.example.pigeon_wings.repository;

import com.example.pigeon_wings.entity.BillInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillInfoRepository extends JpaRepository<BillInfo, Integer> {
}
