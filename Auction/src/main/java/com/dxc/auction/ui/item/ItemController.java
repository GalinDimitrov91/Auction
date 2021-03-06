package com.dxc.auction.ui.item;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.auction.domain.history.DefaultHistoryService;
import com.dxc.auction.domain.history.History;
import com.dxc.auction.domain.item.DefaultItemConverter;
import com.dxc.auction.domain.item.DefaultItemService;
import com.dxc.auction.domain.item.Item;
import com.dxc.auction.domain.user.User;
import com.dxc.auction.domain.user.UserService;

/**
 * Item controller. Used for mapping urls. Methods - create item, save items,
 * buy item, all items, my items.
 * 
 * @author gdimitrov5
 *
 */
@Controller
public class ItemController {

	@Autowired
	private DefaultItemService itemService;

	@Autowired
	private DefaultItemConverter itemConverter;

	@Autowired
	private DefaultHistoryService historyService;

	@Autowired
	private UserService userService;

	/**
	 * Method to creating a new item.
	 * 
	 * @param model
	 * @return item view
	 */
	@GetMapping("/create-item")
	public String createItem(@Valid Model model) {
		model.addAttribute("itemForm", new ItemForm());
		return "item";
	}

	/**
	 * Method to saving item.
	 * 
	 * @param itemForm
	 * @param result
	 * @param principal
	 * @return create-item view
	 */
	@PostMapping("/save-item")
	public String saveItem(@Valid @ModelAttribute ItemForm itemForm, BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			return "item";
		}
		Item item = itemConverter.convertToModel(itemForm);
		User user = (User) userService.loadUserByUsername(principal.getName());
		item.setUser(user);
		item.setOwner(user.getUsername());
		itemService.save(item);
		return "redirect:create-item";
	}

	/**
	 * Method to buy item.
	 * 
	 * Checks the current user's balance if there is enough money to buy the item.
	 * If there is enough money the item goes into his history the money from his
	 * balance is taken and added to the balance of the user who has put the item
	 * then the item is deleted from "all items". If there is not enough money
	 * redirect the user to balance view.
	 * 
	 * @param itemForm
	 * @param id
	 * @return balance or history view
	 */
	@GetMapping("/buy-item")
	public String buyItem(@ModelAttribute ItemForm itemForm, @RequestParam(name = "id") Long id) {

		User user = (User) userService
				.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		Item item = itemService.getItemById(itemForm.getId());
		User user2 = (User) userService.loadUserByUsername(item.getOwner());
		History history = new History();
		String currentUserUsername = user.getUsername();
		String itemOwner = item.getOwner();

		if (currentUserUsername.equals(itemOwner) || user.getBalance() < item.getBuyNowPrice()) {
			return "redirect:balance";
		}

		history.setName(item.getName());
		history.setDescription(item.getDescription());
		history.setUser(item.getUser());
		history.setPrice(item.getBuyNowPrice());
		history.setDate(LocalDate.now());
		history.setUser(user);
		double firstUserNewBalance = user.getBalance() - item.getBuyNowPrice();
		double secondUserNewBalance = user2.getBalance() + item.getBuyNowPrice();
		user.setBalance(firstUserNewBalance);
		user2.setBalance(secondUserNewBalance);
		userService.save(user);
		userService.save(user2);

		historyService.save(history);
		itemService.delete(item);

		return "redirect:history";
	}

	/**
	 * Method for viewing all the items that were made.
	 * 
	 * @param model
	 * @return item view
	 */
	@GetMapping("/all-items")
	public String allItems(Model model) {
		model.addAttribute("items",
				itemService.getAllItems().stream().map(itemConverter::convertToForm).collect(Collectors.toList()));
		return "itemtable";
	}

	/**
	 * The method only shows those items that user has made.
	 * 
	 * @param model
	 * @return my items view
	 */
	@GetMapping("/my-items")
	public String myItems(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Item> users = itemService.getUsersItems(user.getUsername());
		model.addAttribute("items", users.stream().map(itemConverter::convertToForm).collect(Collectors.toList()));
		return "myitems";
	}

	@GetMapping("/delete-item")
	public String deleteItem(@ModelAttribute ItemForm itemForm, @RequestParam(name = "id") Long id) {
		Item item = itemService.getItemById(itemForm.getId());
		itemService.delete(item);
		return "myitems";
	}

}
