package com.yang.shardingjdbc.entity;

import lombok.Data;

/**
 * @author yang
 * @date 2023/5/27 6:47
 */
@Data
public class Course {

    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;
}
