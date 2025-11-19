package com.hyperint.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Id
    private Long review_id;

    private String product_name;

    private String contact_number;

    private String product_review;

    private LocalDateTime created_at;
}
