package com.dxc.auction.domain.item;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author gdimitrov5
 *
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

	/**
	 * A query that brings all items to a particular owner.
	 * @param name
	 * @return List<Items>
	 */
	@Query("select a from Item a  where a.owner = ?1")
	public List<Item> findItemByOwner(String name);
	

}
