package com.scorpion.spring.repository;

import com.scorpion.spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {

}
