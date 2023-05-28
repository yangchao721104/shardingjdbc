package com.yang.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yang
 * @date 2023/5/27 14:50
 */
@Data
@TableName("t_user")
public class User {
    private Long userId;
    private String username;
    private String ustatus;
}
