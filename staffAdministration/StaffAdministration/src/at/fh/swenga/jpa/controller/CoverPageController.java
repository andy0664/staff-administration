package at.fh.swenga.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.jpa.constant.Constant;


@Controller
public class CoverPageController {
	
	
	@RequestMapping(value={"/","start"})
	public String index(Model model){
		return Constant.PAGE_INDEX;
	}

}
