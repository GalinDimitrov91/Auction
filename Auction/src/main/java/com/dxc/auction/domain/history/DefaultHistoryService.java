package com.dxc.auction.domain.history;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.auction.domain.user.User;

/**
 * History Service class implements HistoryService.
 * 
 * @author gdimitrov5
 *
 */
@Service
public class DefaultHistoryService implements HistoryService {

	@Autowired
	private HistoryRepository historyRepository;

	@Transactional
	@Override
	public void save(History history) {
		historyRepository.save(history);
	}

	@Override
	public List<History> getAllRecords() {

		return (List<History>) historyRepository.findAll();
	}

	@Override
	public List<History> getAllRecordsByUserId(User user) {

		return historyRepository.findRecordsByUserId(user);
	}

}
