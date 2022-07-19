package com.scorpion.spring.service;

import com.scorpion.spring.datatransfer.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO getItem(String code);
    List<ItemDTO> getAllItems();
    List<String> getAllItemCodes();
    void saveItem(ItemDTO dto);
    void updateItem(ItemDTO dto);
    void deleteItem(String code);
}
