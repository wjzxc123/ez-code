package com.licon.domain.common;


import com.baomidou.mybatisplus.annotation.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseField {
    @Version
    private Long version;
}
