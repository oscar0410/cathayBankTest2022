package com.yunyangwu.cathaybanktest.model.currency;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "CURRENCY")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RATE")
    private BigDecimal rate;

    @Column(name = "CREATE_TIME")
    private Date createdDate;

    @Column(name = "UPDATE_TIME")
    private Date updatedDate;

}
