package com.licon.security.config;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.licon.admin.core.mybatis.enums.EnableEnum;
import com.licon.admin.core.sys.po.Authority;
import com.licon.admin.core.sys.po.Role;
import com.licon.admin.core.sys.po.User;
import com.licon.admin.core.sys.repository.RoleRepository;
import com.licon.admin.core.sys.repository.UserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/2 14:57
 */
public class CustomerUserDetailService implements UserDetailsService {
	final UserRepository userRepository;
	final RoleRepository roleRepository;

	public CustomerUserDetailService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepository.queryUserByAccount(username);
			if (user == null){
				throw new Exception();
			}
		}catch (Exception e) {
			throw new UsernameNotFoundException("用户不存在");
		}
		Set<String> roles = user.getRoleList().stream().filter(x -> x.getEnable() == EnableEnum.ON)
				.map(Role::getRoleCode).collect(Collectors
						.toSet());
		Set<String> authorities = new HashSet<>();
		for (String role : roles) {
			try {
				Role userRole = roleRepository.queryRoleByRoleCode(role);
				if (userRole != null){
					Set<String> authority = userRole.getAuthorityList().stream().map(Authority::getAuthorityCode)
							.collect(Collectors.toSet());
					authorities.addAll(authority);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new org.springframework.security.core.userdetails.User(user.getAccount(),user.getPassword(),
				AuthorityUtils.createAuthorityList(authorities.toArray(new String[0])));
	}
}
