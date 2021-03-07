package com.dioneybecker.beerinventoryservice.services;

import com.dioneybecker.beerinventoryservice.config.AwsSqsConfig;
import com.dioneybecker.beerinventoryservice.domain.BeerInventory;
import com.dioneybecker.beerinventoryservice.repositories.BeerInventoryRepository;
import com.dioneybecker.brewery.model.events.NewInventoryEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Profile("awsdev")
@Slf4j
@RequiredArgsConstructor
@Service
public class NewInventorySQSListener {
    
    @Autowired
    BeerInventoryRepository beerInventoryRepository;

    @SqsListener(AwsSqsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){
        
        log.debug("Got Inventory: " + event.toString());

        BeerInventory newBeerInventory = BeerInventory.builder()
            .beerId(event.getBeerDto().getId())
            .upc(event.getBeerDto().getUpc())
            .quantityOnHand(event.getBeerDto().getQuantityOnHand())
            .build();

        beerInventoryRepository.save(newBeerInventory);
    }
}
