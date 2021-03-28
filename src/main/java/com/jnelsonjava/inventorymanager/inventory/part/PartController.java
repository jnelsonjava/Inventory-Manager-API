package com.jnelsonjava.inventorymanager.inventory.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping("/inventory/parts")
    public String getParts() {
        return "list of all parts";
    }

    @GetMapping("/inventory/parts/{id}")
    public String getPart(@PathVariable String id) {
        return "single part details";
    }

    @PostMapping("/inventory/parts")
    public String postPart(@RequestBody Part part) {
        partRepository.save(part);
        return "create new part";
    }
}
