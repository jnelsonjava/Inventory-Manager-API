package com.jnelsonjava.inventorymanager.inventory.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping("/parts")
    public String getParts() {
        return "list of all parts";
    }

    @GetMapping("/parts/{id}")
    public String getPart(@PathVariable String id) {
        return "single part details";
    }

    @PostMapping("/parts")
    public String postPart(@RequestBody NewPartRequest newPartRequest) {
        Part part = new Part(newPartRequest.getName(), newPartRequest.getDescription());
        System.out.println(part.name);
        partRepository.save(part);
        return "create new part";
    }
}
