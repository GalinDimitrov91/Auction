package com.dxc.auction.domain.item;

import java.util.List;


/**
 * 
 * Item Service interface.
 * @author gdimitrov5
 *
 */
public interface ItemService {

	/**
	 * Method for saving item.
	 * @param item
	 */
	public void save(Item item);
	
	/**
	 * Method to get all items.
	 * @return
	 */
	public List<Item> getAllItems();
	
	/**
	 * Method to get all items for specified user.
	 * @param username
	 * @return
	 */
	public List<Item> getUsersItems(String username);
	
	/**
	 * Method for finding items by id.
	 * @param id
	 * @return
	 */
	public Item getItemById(Long id);
	
	/**
	 * Delete method used for delete an item.
	 * @param item
	 */
	public void delete(Item item);
}
