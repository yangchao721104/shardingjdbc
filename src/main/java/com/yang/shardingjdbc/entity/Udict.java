package com.yang.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yang
 * @date 2023/5/27 15:12
 */
@Data
@TableName("t_udict")
public class Udict {

    private Long dictid;
    private String username;
    private String ustatus;
}
