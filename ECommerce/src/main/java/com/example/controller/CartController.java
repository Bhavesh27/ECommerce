package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.CartDao;
import com.example.dao.CategoryDao;
import com.example.dao.ProductDao;
import com.example.dao.UserDao;
import com.example.model.Cart;
import com.example.model.Category;
import com.example.model.Product;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.UserService;



public class CartController {

	@Autowired(required = true)
	private CartDao cartDAO;

	@Autowired(required = true)
	private ProductService productDAO;

	@Autowired(required = true)
	private CategoryService categoryDAO;

	@Autowired(required = true)
	private UserService userDAO;

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryDAO.getAllCategorys());

		model.addAttribute("cart", new Cart());
		model.addAttribute("cartList", this.cartDAO.list());
		model.addAttribute("totalAmount", cartDAO.getTotalAmount("user")); // Just
																			// to
																			// test,
																			// passwrdo
																			// user
		model.addAttribute("displayCart", "true");
		return "/cart";
	}

	@RequestMapping(value = "/carts", method = RequestMethod.GET)
	public String listCarts(Model model) {
		model.addAttribute("cart", new Cart());
		model.addAttribute("cartList", this.cartDAO.list());
		return "/cart";
	}

	@RequestMapping(value = "/cart/add/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") int id, HttpSession session) {
		Product product = productDAO.getProductById(id);
		/*List<Cart> cartList = cartDAO.list();
		boolean flag=true;
		Product product = productDAO.get(id);
		for(Cart cart:cartList){
			if(product.getName().equals(cart.getProductName())){
				flag=false;
			}
		}
		if(flag){*/
			Cart cart = new Cart();
			cart.setPrice(product.getPrice());
			cart.setProductName(product.getName());
			cart.setQuantity(1);
			// String
			// loggedInUser_ID=(String)session.getAttribute("loggedInUser_ID");
			cart.setUser(userDAO.getUserByUsername((String) session.getAttribute("username"))); // id
																					// should
																					// keep
																					// session
																					// and
																					// use
																					// the
																					// same
																					// id
			cart.setStatus('N'); //
	
			cartDAO.saveOrUpdate(cart);
		//}
		// return "redirect:/views/home.jsp";
		return "redirect:/myCart";

	}

	@RequestMapping("cart/remove/{id}")
	public String removeCart(@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			cartDAO.delete(id);
			model.addAttribute("message", "Successfully removed");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/myCart";
	}

	@RequestMapping("cart/edit/{id}")
	public String editCart(@PathVariable("id") String id, Model model) {
		System.out.println("editCart");
		model.addAttribute("cart", this.cartDAO.get(id));
		model.addAttribute("listCarts", this.cartDAO.list());
		return "cart";
	}
	
}
