package com.tw.dto;

import lombok.Data;

//order dto is used to encapsulate open parameters for json
@Data
public class OrderDto {
    private int custId;
    private int code;
    private String payMode;
}
