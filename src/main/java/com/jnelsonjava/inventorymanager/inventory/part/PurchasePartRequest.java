package com.jnelsonjava.inventorymanager.inventory.part;

import lombok.Getter;

@Getter
public class PurchasePartRequest {
    private long partId;
    private int qtyToPurchase;
}
