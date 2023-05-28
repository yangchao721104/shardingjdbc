package com.yang.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.shardingjdbc.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @date 2023/5/27 14:51
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
