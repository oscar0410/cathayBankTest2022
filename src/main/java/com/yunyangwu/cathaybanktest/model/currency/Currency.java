package com.yunyangwu.cathaybanktest.model.currency;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CURRENCY")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CHINESE_NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_TIME")
    private Date createdDate;

    @Column(name = "UPDATE_TIME")
    private Date updatedDate;

}
