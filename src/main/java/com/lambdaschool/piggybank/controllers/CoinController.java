package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping(value = "/total",produces = "application/json")
    public ResponseEntity<?> getTotalCoins(){
        List<Coin> coins = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(coins::add);

        double total = 0;
        String coinquantity = "";
        for(Coin coin : coins)
        {
            if (coin.getQuantity() > 1) {
                coinquantity += coin.getQuantity() + ""+coin.getNameplural() + "/m";

            }
            else {
                coinquantity += coin.getQuantity() + ""+ coin.getName() + "/n";
            }
            total += coin.getValue() * coin.getQuantity();

        }

        System.out.println(coinquantity + "The piggy bank holds " + total);

        return new ResponseEntity<>(total, HttpStatus.OK);

    }

}
