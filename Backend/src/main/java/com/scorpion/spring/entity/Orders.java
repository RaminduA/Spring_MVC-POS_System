package com.scorpion.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    private String id;
    private String date;
    private String time;
    private double cost;

    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="customerId", referencedColumnName="id", nullable=false)
    private Customer customer;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<OrderDetail> detailList;
}
