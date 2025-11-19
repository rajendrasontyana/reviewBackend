package com.hyperint.review.service;

import com.hyperint.review.model.Review;
import com.hyperint.review.model.UserSession;
import com.hyperint.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository review_repo;

    private final Map<String,UserSession> session=new HashMap<>();

    public String handleMessage(String from,String body){
        UserSession userSession=session.getOrDefault(from,new UserSession());
        switch(userSession.getStep()){
            case 0: userSession.setStep(1);
                    return "Which product is this review for?";
            case 1: userSession.setStep(2);
                    userSession.setProduct_name(body);
                    return "What's your Name?";
            case 2: userSession.setStep(3);
                    userSession.setUser_name(body);
                    return "Please send your review for "+userSession.getProduct_name();
            case 3: userSession.setStep(4);
                    userSession.setProduct_review(body);
                    saveReview(userSession,from);
                    session.remove(from);
                    return "Thanks "+userSession.getUser_name()+" review for "+userSession.getProduct_name()+" has been recorded";
        }
        return "Something went wrong";
    }

    public void saveReview(UserSession userSession,String from){
        Review reviews=new Review();
        reviews.setProduct_name(userSession.getProduct_name());
        reviews.setContact_number(from);
        reviews.setProduct_review(userSession.getProduct_review());
        reviews.setCreated_at(LocalDateTime.now());
        review_repo.save(reviews);
    }

    public List<Review> getAllReviews(){
        return review_repo.findAll();
    }

}
