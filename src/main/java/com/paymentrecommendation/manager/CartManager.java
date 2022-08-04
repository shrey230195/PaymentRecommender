package com.paymentrecommendation.manager;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.Cart;
import com.paymentrecommendation.models.CartDetail;
import com.paymentrecommendation.models.CartItem;

import java.util.ArrayList;
import java.util.List;


public class CartManager {

    public Cart createCartForBusiness(LineOfBusiness lineOfBusiness) {
        CartItem shoes = new CartItem("1", "shoes", 20.2);
        CartItem shirt = new CartItem("2", "shirt", 30.2);
        List<CartItem> items = new ArrayList<>();
        items.add(shoes);
        items.add(shirt);
        CartDetail cartDetail = new CartDetail(1100.0, items );
        return new Cart(lineOfBusiness, cartDetail);
    }
}