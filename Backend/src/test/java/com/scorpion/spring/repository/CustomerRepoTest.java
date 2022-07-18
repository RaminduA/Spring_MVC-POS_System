package com.scorpion.spring.repository;

import com.scorpion.spring.config.JpaConfig;
import com.scorpion.spring.entity.Customer;
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
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Test
    void getAllIds() {
        repo.save(new Customer("C-00001", "Harin", "Badulla", "071-3460235"));
        repo.save(new Customer("C-00002", "Siril", "Galle", "072-6819834"));
        repo.save(new Customer("C-00003", "Supun", "Matara", "078-2689235"));
        repo.save(new Customer("C-00004", "Kasun", "Ratnapura", "070-1782253"));
        repo.save(new Customer("C-00005", "Nirvan", "Kandy", "076-9867256"));

        repo.getAllIds().forEach(System.out::println);
    }
}