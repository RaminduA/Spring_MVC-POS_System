package com.scorpion.spring.service.impl;

import com.scorpion.spring.datatransfer.ItemDTO;
import com.scorpion.spring.entity.Item;
import com.scorpion.spring.repository.ItemRepo;
import com.scorpion.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDTO getItem(String code) {
        if(!repo.findById(code).isPresent()){
            throw new RuntimeException("Item "+code+" Doesn't Exist...");
        }
        return modelMapper.map(repo.findById(code).get(), ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return modelMapper.map(repo.findAll(), new TypeToken<List<Item>>(){}.getType());
    }

    @Override
    public List<String> getAllItemCodes() {
        return repo.getAllCodes();
    }

    @Override
    public void saveItem(ItemDTO dto) {
        if (repo.findById(dto.getCode()).isPresent()) {
            throw new RuntimeException("Item Already Exists...");
        }
        repo.save(modelMapper.map(dto, Item.class));
    }

    @Override
    public void updateItem(ItemDTO dto) {
        if (!repo.findById(dto.getCode()).isPresent()) {
            throw new RuntimeException("Item Doesn't Exist...");
        }
        repo.save(modelMapper.map(dto, Item.class));
    }

    @Override
    public void deleteItem(String code) {
        if (!repo.findById(code).isPresent()) {
            throw new RuntimeException("Customer "+code+" Doesn't Exist...");
        }
        repo.deleteById(code);
    }
}
