package com.dxc.auction.domain.item;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Item Service class implements ItemService.
 * 
 * @author gdimitrov5
 *
 */
@Service
public class DefaultItemService implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Transactional
	@Override
	public List<Item> getAllItems() {
		return (List<Item>) itemRepository.findAll();
	}

	@Transactional
	@Override
	public void save(Item item) {
		itemRepository.save(item);

	}

	@Override
	public List<Item> getUsersItems(String username) {
		return itemRepository.findItemByOwner(username);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findOne(id);

	}

	@Override
	public void delete(Item item) {
		itemRepository.delete(item);

	}

}
