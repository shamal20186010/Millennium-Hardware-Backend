package org.millennium_hardware.Service.impl;

import lombok.RequiredArgsConstructor;
import org.millennium_hardware.Repository.ItemRepository;
import org.millennium_hardware.Service.ItemService;
import org.millennium_hardware.dto.Item;
import org.millennium_hardware.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper mapper;

    @Override
    public void saveItem(Item item) {
        ItemEntity itemEntity = mapper.map(item, ItemEntity.class);
        itemRepository.save(itemEntity);
    }

    @Override
    public void updateItemById(Item item) {
        ItemEntity itemEntity = mapper.map(item, ItemEntity.class);
        itemRepository.save(itemEntity);
    }

    @Override
    public boolean existsById(Long id) {
        return itemRepository.existsById(id);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item findById(Long id) {
        return mapper.map(itemRepository.findById(id), Item.class);
    }
}
