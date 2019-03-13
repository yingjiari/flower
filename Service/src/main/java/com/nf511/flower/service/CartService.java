package com.nf511.flower.service;


import com.nf511.flower.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartService {

    List<Cart> selectAllCart(int userId);
    Cart selectCartByUserIdAndFlowerId(@Param("userId") long userId, @Param("flowerId") long flowerId);
    int insertCart(Cart cart);
    int updateCartAmount(@Param("cartId") int cartId, @Param("cartAmount") int cartAmount);
    int deleteCart(@Param("cartId") int cartId);
    List<Cart> selectAllCartId(@Param("cartIds") List<Integer> cartIds);



    List<Cart>selectAllCartByPage(@Param("pagelimit") int pagelimit, @Param("size") int size);
    int updateCart(Cart cart);

    int deleteAll(@Param("cartIds") List<Integer> items);
}
