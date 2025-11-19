package com.hyperint.review.model;

import lombok.Data;

@Data
public class UserSession {
    int step=0;
    String product_name;
    String user_name;
    String product_review;
}
