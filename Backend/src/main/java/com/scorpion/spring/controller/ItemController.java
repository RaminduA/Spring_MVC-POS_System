package com.scorpion.spring.controller;

import com.scorpion.spring.datatransfer.ItemDTO;
import com.scorpion.spring.service.ItemService;
import com.scorpion.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping(path = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getItem(@PathVariable String code){
        return new ResponseUtil(200,"Found Item...",service.getItem(code));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItems(){
        return new ResponseUtil(200,"Found Item List...",service.getAllItems());
    }

    @GetMapping(path = "codes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItemCodes(){
        return new ResponseUtil(200,"Found All Item Codes...",service.getAllItemCodes());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveItem(@RequestBody ItemDTO dto){
        service.saveItem(dto);
        return new ResponseUtil(200,"Item Saved Successfully...",null);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        service.updateItem(dto);
        return new ResponseUtil(200,"Item Updated Successfully...",null);
    }

    @DeleteMapping(path = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteItem(@PathVariable String code){
        service.deleteItem(code);
        return new ResponseUtil(200,"Item Deleted Successfully...",null);
    }
}
