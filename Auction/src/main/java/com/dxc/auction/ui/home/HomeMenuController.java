package com.dxc.auction.ui.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home Controller.
 * 
 * @author gdimitrov5
 *
 */
@Controller
public class HomeMenuController {

	/**
	 * @return home view
	 */
	@GetMapping("/")
	public String slash() {
		return "home";
	}

	/**
	 * @return home view
	 */
	@GetMapping("/home")
	public String slashHome() {
		return "home";
	}

}
