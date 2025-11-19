package com.hyperint.review.controller;

import com.hyperint.review.model.Review;
import com.hyperint.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReviewController {

    @Autowired
    public ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews(){
        return new ResponseEntity(reviewService.getAllReviews(), HttpStatus.ACCEPTED);
    }
}
