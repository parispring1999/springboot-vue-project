package com.wms.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Long total;
    private Object data;

}
