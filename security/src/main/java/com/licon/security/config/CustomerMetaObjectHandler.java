package com.licon.security.config;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.licon.security.util.SecurityUtils;
import org.apache.catalina.security.SecurityUtil;
import org.apache.ibatis.reflection.MetaObject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 11:14
 */
public class CustomerMetaObjectHandler implements MetaObjectHandler {


	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
		this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

		this.strictInsertFill(metaObject, "createBy", String.class, SecurityUtils.getAuthentication());
		this.strictInsertFill(metaObject, "updateBy", String.class, SecurityUtils.getAuthentication());
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
		this.strictInsertFill(metaObject, "updateBy", String.class, SecurityUtils.getAuthentication());
	}


}
