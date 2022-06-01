package com.yunyangwu.cathaybanktest.common.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CurrencyPatchRequest {
    private String name;
    private String code;
    private String description;
}
