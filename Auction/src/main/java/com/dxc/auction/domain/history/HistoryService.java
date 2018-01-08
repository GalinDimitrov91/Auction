package com.dxc.auction.domain.history;

import java.util.List;

import com.dxc.auction.domain.user.User;


/**
 * History Service interface.
 * @author gdimitrov5
 *
 */
public interface HistoryService {
	
	/**
	 * Method for saving history.
	 * @param history
	 */
	public void save(History history);
	
	/**
	 * Method to get all history records.
	 * @return
	 */
	public List<History> getAllRecords();
	
	/**
	 * Method for finding history by user id.
	 * @param user
	 * @return
	 */
	public List<History> getAllRecordsByUserId(User user);
}
