/**
 * 
 */
package com.dxc.auction.domain.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author gdimitrov5
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * Method for finding user by username.
	 * 
	 * @param username
	 * @return user
	 */
	User findOneByUsername(String username);

}
