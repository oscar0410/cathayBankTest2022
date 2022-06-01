package com.yunyangwu.cathaybanktest.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunyangwu.cathaybanktest.model.currency.Currency;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CurrencyResponse {

    private String name;
    private String code;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedDate;

    public CurrencyResponse(Currency currency) {
        this.name = currency.getName();
        this.code = currency.getCode();
        this.description = currency.getDescription();
        this.createdDate = currency.getCreatedDate();
        this.updatedDate = currency.getUpdatedDate();
    }
}
