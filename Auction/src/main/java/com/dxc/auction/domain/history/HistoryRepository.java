package com.dxc.auction.domain.history;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.auction.domain.user.User;

/**
 * Interface History Repository extends CrudRepository.
 * 
 * @author gdimitrov5
 *
 */
@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {

	/**
	 * A query that brings all History to a particular user.
	 * @param user
	 * @return List<History>
	 */
	@Query("select h from History h where h.user = user")
	public List<History> findRecordsByUserId(User user);

}
