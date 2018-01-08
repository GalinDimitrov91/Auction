package com.dxc.auction.domain.item;

import org.springframework.stereotype.Component;

import com.dxc.auction.core.Converter;
import com.dxc.auction.ui.item.ItemForm;

/**
 * 
 * Item converter. This class is used for converting a item
 * form(Web UI form) to model(entity) and backwards.
 * @author gdimitrov5
 *
 */
@Component
public class DefaultItemConverter implements Converter<ItemForm, Item> {

	/**
	 * Method that converts a item form to a model.
	 */
	@Override
	public ItemForm convertToForm(Item model) {
		ItemForm itemForm = new ItemForm();

		itemForm.setId(model.getId());
		itemForm.setName(model.getName());
		itemForm.setDescription(model.getDescription());
		itemForm.setBuyNowPrice(model.getBuyNowPrice().toString());
		itemForm.setOwner(model.getOwner());
		itemForm.setUser(model.getUser());
		return itemForm;
	}

	/**
	 * Method that converts a item model to a form.
	 */
	@Override
	public Item convertToModel(ItemForm form) {

		Item item = new Item();

		item.setId(form.getId());
		item.setName(form.getName());
		item.setDescription(form.getDescription());
		item.setBuyNowPrice(Double.parseDouble(form.getBuyNowPrice()));
		item.setOwner(form.getOwner());
		item.setUser(form.getUser());
		return item;

	}

}
