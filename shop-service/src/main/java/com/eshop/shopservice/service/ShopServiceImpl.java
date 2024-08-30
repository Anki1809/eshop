package com.eshop.shopservice.service;

import com.eshop.shopservice.dao.ShopRepository;
import com.eshop.shopservice.entity.Shop;
import com.eshop.shopservice.dto.ShopDto;
import com.eshop.shopservice.exceptions.ResourceNotFoundException;
import com.eshop.shopservice.mapper.ShopMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    /**
     * @param shopDto
     * @return
     */
    @Override
    public ShopDto addShop(ShopDto shopDto) {
        Shop shop = ShopMapper.toShop(shopDto, new Shop());
        shop.setShopId(null);
        shop.setActive(true);
        shop.setOwnerId(new Random().nextLong());
        return ShopMapper.toShopDto(shopRepository.save(shop));
    }

    /**
     * @param shopDto
     * @return
     */
    @Override
    public ShopDto updateShop(ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopDto.shopId()).orElseThrow(
                () -> new ResourceNotFoundException("Shop", "shop id", shopDto.shopId().toString())
        );
        ShopMapper.toShop(shopDto,shop);
        return ShopMapper.toShopDto(shopRepository.save(shop));
    }

    /**
     * @param shopId
     * @return
     */
    @Override
    public ShopDto getShopById(Long shopId) {
        Shop shop = shopRepository.findById(shopId).orElseThrow(
                () -> new ResourceNotFoundException("Shop", "shop id", shopId.toString())
        );
        return ShopMapper.toShopDto(shop);
    }

    /**
     * @return
     */
    @Override
    public List<ShopDto> getShops(Boolean active) {
        List<Shop> shops = shopRepository.findByActive(active);
        return shops.stream().map(ShopMapper::toShopDto).toList();
    }

    /**
     * @param ownerId
     * @return
     */
    @Override
    public ShopDto getShopByOwnerId(Long ownerId) {
        Shop shop = shopRepository.findByOwnerId(ownerId).orElseThrow(
                () -> new ResourceNotFoundException("Shop", "owner id", ownerId.toString())
        );
        return ShopMapper.toShopDto(shop);
    }

    /**
     * @param shopId
     * @return
     */
    @Override
    public Boolean deactivateShop(Boolean active, Long shopId) {
        shopRepository.findById(shopId).orElseThrow(
                () -> new ResourceNotFoundException("Shop", "shop id", shopId.toString())
        );
        int v = shopRepository.updateActiveByShopId(active, shopId);
        return v == 1;
    }
}
