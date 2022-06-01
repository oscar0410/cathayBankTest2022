package com.yunyangwu.cathaybanktest.common.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@ToString
public class CurrencyCreateRequest {
    @Valid
    @NotBlank(message = "name cannot be blank.")
    private String name;
    @Valid
    @NotBlank(message = "code cannot be blank.")
    private String code;
    private String description;

}
