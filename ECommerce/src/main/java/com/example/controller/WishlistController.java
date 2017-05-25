package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.WishlistDao;
import com.example.model.Product;
import com.example.model.Wishlist;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class WishlistController {

	    @Autowired
	 	CategoryService categoryService;
	 	
	 	@Autowired
	 	UserService userService;
	 	
	 	@Autowired
	 	WishlistDao wishlistDao;
	 	
	 	@Autowired
	 	ProductService productService;
	 	
	 	@Autowired
	 	Product product;
	 	 	
	 	 @Autowired
	 	 Wishlist wishlist;
	 
	 	@RequestMapping(value="/{username}/wishlist" , method = RequestMethod.GET)
	 	public String wishlist(@PathVariable("username") String username , ModelMap model)
	 	{
	 		
	 		if(!username.equals(getPrincipal()))
	 				return "redirect:/logout";
	 		
	 		model.addAttribute("user", getPrincipal());
	 		model.addAttribute("categories", categoryService.getAllCategorys());
	     	model.addAttribute("products",wishlistDao.getWishlistItems(userService.getUserByUsername(username).getUser_id()));
	     	
	 		return "user/userWishlist/wishlist";
	 	}
	 	
	 	@RequestMapping(value="/addWishlistItem" , method = RequestMethod.GET)
	 	public String addItemToWishlist(@RequestParam("book") String book , ModelMap model)
	 	 {
	 		if(getPrincipal() == "anonymousUser" || getPrincipal() == null )
	 	   	{
	 	   		return "redirect:/login";
	 	   	}
	 			
	 		List<Wishlist> wishlist1 = wishlistDao.getWishlistItems(userService.getUserByUsername(getPrincipal()).getUser_id());	
	 		for(Wishlist list : wishlist1)		
	 			{		
		 			if(list.getProduct_name().equals(book))		
	 					{			
		 				    model.addAttribute("username", getPrincipal());		
	 		 	 			return "redirect:/user/{username}/wishlist";		
	 		 	 		}		
	 			}
	 		
	 	 	System.out.println(book);
	 		product = productService.getProductByName(book);
	 		wishlist = new Wishlist();
	 		wishlist.setAuthor(product.getAuthor_name());
	 		wishlist.setProduct_name(book);
	 		wishlist.setDescription(product.getProduct_desc());
	 		wishlist.setUsername(getPrincipal());
	 	 	wishlistDao.addWishlist(wishlist);
	 		model.addAttribute("username", getPrincipal());
	 		return "redirect:/user/{username}/wishlist";
	 	 }
	 	
	 	//@RequestMapping(value="remove-wishlist-{wishlist_id}", method = RequestMethod.GET)
	 	@RequestMapping(value="/{username}/wishlist/remove-wishlist/{wishlist_id}", method = RequestMethod.GET)
	     public String removeCart(@PathVariable int wishlist_id , ModelMap model)
	     {
	     	wishlistDao.deleteWishlist(wishlistDao.getWishlist(wishlist_id));
	     	/*model.addAttribute("user", getPrincipal());
	 		model.addAttribute("categories", categoryService.getAllCategorys());
	     	model.addAttribute("products",wishlistDao.getWishlistItems(userService.getUserByUsername(getPrincipal()).getUser_id()));
	     	return "wishlist";*/
	     	model.addAttribute("username", getPrincipal());
	     	return "redirect:/user/{username}/wishlist";
	     }
	 	
	 	private String getPrincipal(){
	         String userName = null;
	         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  
	         if (principal instanceof UserDetails) {
	             userName = ((UserDetails)principal).getUsername();
	         } else {
	             userName = principal.toString();
	         }
	return userName;
 }
	 
}
