package com.dioneybecker.beerinventoryservice.web.mappers;

import com.dioneybecker.beerinventoryservice.domain.BeerInventory;
import com.dioneybecker.beerinventoryservice.domain.BeerInventory.BeerInventoryBuilder;
import com.dioneybecker.beerinventoryservice.web.model.BeerInventoryDto;
import com.dioneybecker.beerinventoryservice.web.model.BeerInventoryDto.BeerInventoryDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-07T19:07:27-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class BeerInventoryMapperImpl implements BeerInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO) {
        if ( beerInventoryDTO == null ) {
            return null;
        }

        BeerInventoryBuilder beerInventory = BeerInventory.builder();

        beerInventory.id( beerInventoryDTO.getId() );
        beerInventory.createdDate( dateMapper.asTimestamp( beerInventoryDTO.getCreatedDate() ) );
        beerInventory.lastModifiedDate( dateMapper.asTimestamp( beerInventoryDTO.getLastModifiedDate() ) );
        beerInventory.beerId( beerInventoryDTO.getBeerId() );
        beerInventory.quantityOnHand( beerInventoryDTO.getQuantityOnHand() );

        return beerInventory.build();
    }

    @Override
    public BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory) {
        if ( beerInventory == null ) {
            return null;
        }

        BeerInventoryDtoBuilder beerInventoryDto = BeerInventoryDto.builder();

        beerInventoryDto.id( beerInventory.getId() );
        beerInventoryDto.createdDate( dateMapper.asOffsetDateTime( beerInventory.getCreatedDate() ) );
        beerInventoryDto.lastModifiedDate( dateMapper.asOffsetDateTime( beerInventory.getLastModifiedDate() ) );
        beerInventoryDto.beerId( beerInventory.getBeerId() );
        beerInventoryDto.quantityOnHand( beerInventory.getQuantityOnHand() );

        return beerInventoryDto.build();
    }
}
