package com.dxc.auction.ui.history;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dxc.auction.domain.history.DefaultHistoryConverter;
import com.dxc.auction.domain.history.HistoryService;

/**
 * History controller. Used for mapping urls.
 * @author gdimitrov5
 *
 */
@Controller
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@Autowired
	private DefaultHistoryConverter historyConverter;

	/**
	 * Method for viewing all the history records that were made.
	 * @param model
	 * @return history view
	 */
	@GetMapping("/history")
	public String allHistoryRecords(Model model) {

		model.addAttribute("history",
				historyService.getAllRecords().stream().map(historyConverter::convertToForm)
				.collect(Collectors.toList()));
		return "history";
	}
}
