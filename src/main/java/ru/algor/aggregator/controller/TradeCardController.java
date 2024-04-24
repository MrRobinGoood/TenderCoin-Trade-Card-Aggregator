//package ru.algor.parser.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import ru.algor.parser.entity.TradeCard;
//import ru.algor.parser.service.TradeCardService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/tradecards")
//public class TradeCardController {
//
//    private TradeCardService tradeCardService;
//
//    @Autowired
//    public TradeCardController(TradeCardService tradeCardService) {
//        this.tradeCardService = tradeCardService;
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping()
//    public List<TradeCard> getTradeCards() {
//        List<TradeCard> tradeCards = tradeCardService.getTradeCards();
//        List<TradeCard> some = new ArrayList<>();
//        for(int i = 0; i < 10; i++){
//            some.add(tradeCards.get(i));
//        }
//        return some;
//    }
//
//}
