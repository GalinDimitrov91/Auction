package com.dxc.auction.domain.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dxc.auction.errors.Errors;


/**
 * User Service class implements UserService.
 * @author gdimitrov5
 *
 */
@Service
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;	
	
	@Transactional
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOneByUsername(username);
		if(user == null){
            throw new UsernameNotFoundException(Errors.WRONG_USERNAME_OR_PASSWORD);
        }
        return user;
    }

	
}
