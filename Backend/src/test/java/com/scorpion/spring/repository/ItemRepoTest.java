package com.scorpion.spring.repository;

import com.scorpion.spring.config.JpaConfig;
import com.scorpion.spring.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = JpaConfig.class)
@ExtendWith(SpringExtension.class)
@Transactional
class ItemRepoTest {

    @Autowired
    ItemRepo repo;

    @Test
    void getAllCodes() {
        repo.save(new Item("I-000001","Banana",250.00,33));
        repo.save(new Item("I-000002","Coconut",110.00,50));
        repo.save(new Item("I-000003","Tomato",345.00,62));
        repo.save(new Item("I-000004","Onions",200.00,73));
        repo.save(new Item("I-000005","Carrot",430.00,40));

        repo.getAllCodes().forEach(System.out::println);
    }
}