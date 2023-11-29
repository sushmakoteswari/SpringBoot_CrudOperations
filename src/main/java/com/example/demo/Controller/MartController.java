package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.MyItemsList;
import com.example.demo.Entity.SkinCare;
import com.example.demo.Service.MyItemsService;
import com.example.demo.Service.SkinCareService;

@Controller
public class MartController {
	
	@Autowired
	private SkinCareService service;
	
	@Autowired
	private MyItemsService myItemsService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/new_item")
	public String new_Item() {
		return "new_item";
	}
	
	@GetMapping("/available_items")
		public ModelAndView getAllItems() {
			 List<SkinCare>list = service.getAllItems();
//			 ModelAndView m = new ModelAndView();
//			 m.setViewName("available_items");
//			 m.addObject("items",list);
			 return new ModelAndView("available_items","items",list);
		
	}
	
	@GetMapping("/your_cart")
	public String getMycart(Model model) {
		List<MyItemsList>list = myItemsService.getAllMyItems();
		model.addAttribute("items",list);
		return "your_cart";		
	}
	
	 @PostMapping("/save")
	    public String addItem(@ModelAttribute("items") SkinCare s, Model model) {
	        service.save(s);
	        // After saving, retrieve the updated list of items and add it to the model
	        List<SkinCare> updatedList = service.getAllItems();
	        model.addAttribute("items", updatedList);
	        return "redirect:/available_items";
	    }
	 
	 
	 @RequestMapping("/addToCart/{id}")
	 public String getMyList(@PathVariable("id") int id) {
		 SkinCare s = service.getItemByID(id);
		 MyItemsList mi = new MyItemsList(s.getId(),s.getName(),s.getCount(),s.getPrice());
		 myItemsService.saveMyItem(mi);
		 return "redirect:/your_cart";
	 }
	 
	 @RequestMapping("/itemEdit/{id}")
	 public String editItem(@PathVariable("id") int id,Model model ) {
		 SkinCare s = service.getItemByID(id);
		 model.addAttribute("items",s);
		 return "itemEdit";
	 }
	 
	 @RequestMapping("/deleteItem/{id}")
	 public String deleteItem(@PathVariable("id") int id) {
		 service.deleteById(id);
		 return "redirect:/available_items";
	 }
	 
}
