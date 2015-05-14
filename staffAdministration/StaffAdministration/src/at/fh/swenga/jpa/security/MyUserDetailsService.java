package at.fh.swenga.jpa.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.UserRole;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	SimpleEmployeeRepository employeeDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Employee employee = null;
		List<Employee> userList = employeeDao.findByUserName(username);
		if (userList != null && userList.size() > 0) {
			employee = userList.get(0);
		}
		List<GrantedAuthority> authorities = buildUserAuthority(employee.getUserRole());

		return buildUserForAuthentication(employee, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(Employee employee,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				employee.getUserName(),
				employee.getPassword(),
				true, //account is enabled
				true, // account not expired
				true, // credentials not expired
				true, // account not locked
				authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}
}
