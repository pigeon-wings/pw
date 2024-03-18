package com.example.pigeon_wings.repository;


import com.example.pigeon_wings.entity.NopRegTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NopRegTableRepository extends JpaRepository<NopRegTable, Integer> {
    //first one(UsersTbl) is entity class and second parameter is primary key

}
