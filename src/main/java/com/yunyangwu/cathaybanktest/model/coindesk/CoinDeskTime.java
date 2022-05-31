package com.yunyangwu.cathaybanktest.model.coindesk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CoinDeskTime {

    private String updated;

    private String updatedISO;

    private String updateduk;
}
