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
	
	@RequestMapping(value = "/{username}/cart", method = RequestMethod.GET)
	public String Cart(@PathVariable("username") String username ,ModelMap model){
		
		if(!username.equals(getPrincipal())){
			 	System.out.println(username);
			 	return "redirect:/logout";
			 }
		
		model.addAttribute("categoryList", categoryService.getAllCategorys());
		User user = userService.getUserByUsername(username);
		model.addAttribute("name", user.getName());
		model.addAttribute("products",cartDAO.list(userService.getUserByUsername(username).getUser_id()));
		return "user/userCart/cart";
		
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public String addToCart(@RequestParam("productName") String productName,ModelMap model){
		
		if(getPrincipal() == "anonymousUser" || getPrincipal() == null )
    	{
    		return "redirect:/login";
    	}
		
		Product product = productService.getProductByName(productName);
		
		if(product.getProduct_quantity() == 0)
    	{
			model.addAttribute("username", getPrincipal());
			return "redirect:/user/{username}/cart";
    	}
		
		List<Cart> list = cartDAO.list(userService.getUserByUsername(getPrincipal()).getUser_id());
    	System.out.println(list.size());
    	for(int i=0; i<list.size(); i++)
    	{
    		if(list.get(i).getProduct().getProduct_name().equals(productName))
    		{
    			int j=1; //variable created to increase the quantity of product in cart by 1
    			
    			Cart cart = cartDAO.getById(list.get(i).getCart_id());
    			if(cart.getQuantity() == product.getProduct_quantity())
    			{
    				j=0;
    				//model.addAttribute("msg","This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    				//redirectAttributes.addFlashAttribute("msg", "This seller has only "+product.getQuantity()+" of these available. Check another seller to buy more");
    			}
    			cart.setQuantity(cart.getQuantity()+j);
    			//cart.setProductName(productName);
    	    	
    	    	// set the price after discount
    	    	double price = product.getProduct_price() - product.getProduct_discount() * product.getProduct_price() / 100;
    	    	
    	    	//cart.setPrice(price);
    	    	cart.setTotal(price*cart.getQuantity());
    	    	//cart.setAuthorName(product.getAuthor_name());
    	    	//cart.setUsername(getPrincipal());
    	    	cart.setProduct(product);
    	    	cart.setUser(userService.getUserByUsername(getPrincipal()));
    	    	model.addAttribute("username", getPrincipal());
    			cartDAO.Update(cart);
    			
    			return "redirect:/user/{username}/wishlist";
    		}
    	}
		
		Cart cart = new Cart();
		double price = product.getProduct_price() - product.getProduct_discount() * product.getProduct_price() / 100;
		cart.setTotal(price);
		//cart.setProductName(productName);
		cart.setQuantity(1);
		if (product.getProduct_quantity()>0){
			
			cart.setStatus('A');
		} else
		{
			cart.setStatus('N');
		}
		//cart.setUsername(getPrincipal());
		cart.setProduct(product);
    	cart.setUser(userService.getUserByUsername(getPrincipal()));
		model.addAttribute("username", getPrincipal());
		//cart.setAuthorName(product.getAuthor_name());
		cartDAO.addToCart(cart);
		return "redirect:/user/{username}/cart";
		
	}	
	
	//@RequestMapping(value="remove-cart-{cart_id}", method = RequestMethod.GET)
	@RequestMapping(value="/{username}/cart/remove-cart/{cart_id}", method = RequestMethod.GET)
    public String removeCart(@PathVariable int cart_id , ModelMap model)
    {
    	cartDAO.delete(cartDAO.getById(cart_id));
    	/*model.addAttribute("user", getPrincipal());
		model.addAttribute("categories", categoryService.getAllCategorys());
    	model.addAttribute("products",cartDAO.list(userService.getUserByUsername(getPrincipal()).getUser_id()));
    	return "cart";*/
    	model.addAttribute("username", getPrincipal());
    	return "redirect:/user/{username}/cart";
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
