package com.dxc.auction.domain.history;



import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.dxc.auction.core.Converter;
import com.dxc.auction.ui.history.HistoryForm;

/**
 * History converter. This class is used for converting a history
 * form(Web UI form) to model(entity) and backwards.
 * @author gdimitrov5
 *
 */
@Component
public class DefaultHistoryConverter implements Converter<HistoryForm, History> {

	/**
	 * Method that converts a history form to a model.
	 */
	@Override
	public HistoryForm convertToForm(History model) {

		HistoryForm historyForm = new HistoryForm();
		
		historyForm.setId(model.getId());
		historyForm.setName(model.getName());
		historyForm.setDescription(model.getDescription());
		historyForm.setUser(model.getUser());
		historyForm.setPrice(model.getPrice().toString());
		historyForm.setDate(model.getDate().toString());
		
		return historyForm;
	}

	/**
	 * Method that converts a history model to a form.
	 */
	@Override
	public History convertToModel(HistoryForm form) {
		
		History history = new History();
		
		history.setId(form.getId());
		history.setName(form.getName());
		history.setDescription(form.getDescription());
		history.setUser(form.getUser());
		history.setPrice(Double.parseDouble(form.getPrice()));
		history.setDate(LocalDate.parse(form.getDate()));
		
		return history;
	}

}
