package dh.meli.projeto_integrador.utils;

import dh.meli.projeto_integrador.dto.dtoInput.CartDto;
import dh.meli.projeto_integrador.enumClass.PurchaseOrderStatusEnum;
import dh.meli.projeto_integrador.model.Cart;
import dh.meli.projeto_integrador.model.ProductCart;

import java.time.LocalDate;

public class GenerateCart {

    public static Cart newCart1() {
        return Cart.builder()
                .customer(GenerateCustomer.newCustomer1())
                .status(PurchaseOrderStatusEnum.OPEN)
                .build();
    }

    public static Cart newCartWithId1() {
        return Cart.builder()
                .id(1L)
                .customer(GenerateCustomer.newCustomer1())
                .status(PurchaseOrderStatusEnum.OPEN)
                .build();
    }

    public static Cart newCartWithId2() {
        return Cart.builder()
                .id(1L)
                .customer(GenerateCustomer.newCustomer1())
                .status(PurchaseOrderStatusEnum.FINISHED)
                .build();
    }

    public static CartDto newCartDto1() {
        return CartDto.builder()
                .buyerId(1L)
                .date(LocalDate.now())
                .orderStatus(PurchaseOrderStatusEnum.OPEN)
                .products(GenerateProduct.newProductListDto())
                .build();
    }

    public static ProductCart newProductCart() {
        return ProductCart.builder()
            .id(1)
            .cart(newCartWithId1())
            .product(GenerateProduct.newProduct1())
            .quantity(10)
            .build();
    }
}
