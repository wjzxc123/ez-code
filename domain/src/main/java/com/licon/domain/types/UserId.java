package com.licon.domain.types;

import com.lut.admin.core.domain.repository.Identifier;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/28 16:22
 */
@Data
@AllArgsConstructor
public class UserId implements Identifier {
	private Long userId;
}
