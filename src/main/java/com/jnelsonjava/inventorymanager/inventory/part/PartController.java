package com.jnelsonjava.inventorymanager.inventory.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping(value = "/parts")
    public List<Part> getParts() {
        return partRepository.findAll();
    }

    @GetMapping(value = "/parts/{id}")
    public Part getPartById(@PathVariable String id) {
        return partRepository.findById(Long.parseLong(id)).get();
    }

    @PostMapping("/parts")
    public String createPart(@RequestBody NewPartRequest newPartRequest) {
        Part part = new Part(newPartRequest.getName(), newPartRequest.getDescription());
        partRepository.save(part);
        return String.format("Created part: %s, id: %d", part.name, part.id);
    }

    @PostMapping("/parts/purchase")
    public String purchasePart(@RequestBody PurchasePartRequest purchasePartRequest) {
        Part part = partRepository.findById(purchasePartRequest.getPartId()).get();
        part.qty += purchasePartRequest.getQtyToPurchase();
        partRepository.save(part);
        return String.format("Updated inventory for part %s: %d", part.name, part.qty);
    }

//    @GetMapping("/parts/shortages")
//    public String getShortages() {
//        List<Part> parts = partRepository.findAll();
//
//        return "shortage list";
//    }
}
