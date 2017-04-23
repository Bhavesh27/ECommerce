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

import com.example.dao.CartDao;
import com.example.model.Cart;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.UserService;


@Controller
public class CartController {

	@Autowired
	private CartDao cartDAO;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String Cart(@RequestParam("username") String username ,ModelMap model){
		
		model.addAttribute("categoryList", categoryService.getAllCategorys());
		User user = userService.getUserByUsername(username);
		model.addAttribute("name", user.getName());
		model.addAttribute("products",cartDAO.list(username));
		return "cart";
		
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public String addToCart(@RequestParam("productName") String productName,ModelMap model){
		
		if(getPrincipal() == "anonymousUser" || getPrincipal() == null )
    	{
    		return "redirect:/login";
    	}
		
		Product product = productService.getProductByName(productName);
		
		if(product.getQuantity() == 0)
    	{
			model.addAttribute("username", getPrincipal());
			return "redirect:/cart";
    	}
		
		List<Cart> list = cartDAO.list(getPrincipal());
    	System.out.println(list.size());
    	for(int i=0; i<list.size(); i++)
    	{
    		if(list.get(i).getProductName().equals(productName))
    		{
    			int j=1; //variable created to increase the quantity of product in cart by 1
    			
    			Cart cart = cartDAO.getById(list.get(i).getId());
    			if(cart.getQuantity() == product.getQuantity())
    			{
    				j=0;
    				//model.addAttribute("msg","This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    				//redirectAttributes.addFlashAttribute("msg", "This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    			}
    			cart.setQuantity(cart.getQuantity()+j);
    			cart.setProductName(productName);
    	    	
    	    	// set the price after discount
    	    	double price = product.getPrice() - product.getDiscount() * product.getPrice() / 100;
    	    	
    	    	cart.setPrice(price);
    	    	cart.setTotal(price*cart.getQuantity());
    	    	cart.setAuthorName(product.getAuthor_name());
    	    	cart.setUsername(getPrincipal());
    	    	model.addAttribute("username", getPrincipal());
    			cartDAO.Update(cart);
    			
    			return "redirect:/cart";
    		}
    	}
		
		Cart cart = new Cart();
		double price = product.getPrice() - product.getDiscount() * product.getPrice() / 100;
		cart.setPrice(price);
		cart.setProductName(productName);
		cart.setQuantity(1);
		if (product.getQuantity()>0){
			
			cart.setStatus('A');
		} else
		{
			cart.setStatus('N');
		}
		cart.setUsername(getPrincipal());
		model.addAttribute("username", getPrincipal());
		cart.setAuthorName(product.getAuthor_name());
		cartDAO.addToCart(cart);
		return "redirect:/cart";
		
	}	
	
	@RequestMapping(value="remove-cart-{cart_id}", method = RequestMethod.GET)
    public String removeCart(@PathVariable int cart_id , ModelMap model)
    {
    	cartDAO.delete(cartDAO.getById(cart_id));
    	model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryService.getAllCategorys());
    	model.addAttribute("products",cartDAO.list(getPrincipal()));
    	return "cart";
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
