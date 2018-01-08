package com.dxc.auction.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dxc.auction.core.Converter;
import com.dxc.auction.ui.user.UserForm;

/**
 * User converter. This class is used for converting a user form(Web UI form) to
 * model(entity) and backwards.
 * 
 * @author gdimitrov5
 *
 */
@Component
public class DefaultUserConverter implements Converter<UserForm, User> {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Method that converts a user form to a model.
	 */

	@Override
	public UserForm convertToForm(User model) {

		UserForm userForm = new UserForm();
		userForm.setId(model.getId());
		userForm.setUsername(model.getUsername());
		userForm.setPassword(model.getPassword());
		userForm.setAccountNonExpired(model.isAccountNonExpired());
		userForm.setAccountNonLocked(model.isAccountNonLocked());
		userForm.setCredentialsNonExpired(model.isCredentialsNonExpired());
		userForm.setEnabled(model.isEnabled());
		userForm.setBalance(model.getBalance());
		userForm.setAuthorities(model.getAuthorities());

		return userForm;
	}

	/**
	 * Method that converts a user model to a form.
	 */

	@Override
	public User convertToModel(UserForm form) {

		User user = new User();
		user.setId(form.getId());
		user.setUsername(form.getUsername());
		String encryptedPassword = this.bCryptPasswordEncoder.encode(form.getPassword());
		user.setPassword(encryptedPassword);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setBalance(form.getBalance());
		user.setAuthorities(form.getAuthorities());

		return user;
	}

}