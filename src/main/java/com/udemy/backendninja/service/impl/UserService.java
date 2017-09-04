package com.udemy.backendninja.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service("userService")
public class UserService implements UserDetailsService {

	/** The user repository. */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.udemy.backendninja.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAutorities(user.getUserRole());
		return buildUser(user, authorities);
	}

	/**
	 * Builds the user.
	 *
	 * @param user the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassoword(), user.isEnable(), true, true, true, authorities);
	}

	/**
	 * Builds the autorities.
	 *
	 * @param userRoles the user roles
	 * @return the list
	 */
	private List<GrantedAuthority> buildAutorities(Set<UserRole> userRoles) {
		return userRoles.stream().map((UserRole userRole) -> new SimpleGrantedAuthority(userRole.getRole()))
				.collect(Collectors.toList());
	}
}
