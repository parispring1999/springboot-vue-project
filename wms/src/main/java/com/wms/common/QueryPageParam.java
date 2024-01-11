package com.wms.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class QueryPageParam {
    private static int PAGE_SIZE=20,PAGE_NUM=1;
    private int pageSize=PAGE_SIZE,pageNum=PAGE_NUM;
    private HashMap param;
}
