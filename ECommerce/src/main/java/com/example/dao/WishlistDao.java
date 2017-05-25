
package com.example.dao;

import java.util.List;

import com.example.model.Wishlist;

public interface WishlistDao {
	
	public void addWishlist(Wishlist wishlist);
	public void updateWishlist(Wishlist wishlist);
	public boolean deleteWishlist(Wishlist wishlist);
	public List<Wishlist> getWishlistItems(int user_id);
	public Wishlist getWishlist(int wishlist_id);

}
