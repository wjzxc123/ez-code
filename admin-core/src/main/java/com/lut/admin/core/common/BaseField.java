package com.lut.admin.core.common;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/04 10:09
 */
@Getter
@Setter
public class BaseField {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @Version
    private Long version;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String createBy;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;
}
