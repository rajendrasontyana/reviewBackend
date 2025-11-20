package com.hyperint.review.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserSession {
    int step=0;
    String product_name;
    String user_name;
    String product_review;
    public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getProduct_review() {
		return product_review;
	}
	public void setProduct_review(String product_review) {
		this.product_review = product_review;
	}
}
