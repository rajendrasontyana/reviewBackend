package com.hyperint.review.controller;

import com.hyperint.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/webhook")
    public ResponseEntity<String> recieveMessage(@RequestParam("From") String from, @RequestParam("Body") String body){
        String reply = reviewService.handleMessage(from,body);
        return ResponseEntity.ok(reply);
    }
}
