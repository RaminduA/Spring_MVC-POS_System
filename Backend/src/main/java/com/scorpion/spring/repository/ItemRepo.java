package com.scorpion.spring.repository;

import com.scorpion.spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,String> {
    @Query(value="SELECT code FROM Item")
    List<String> getAllCodes();
}
