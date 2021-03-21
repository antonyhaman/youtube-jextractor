package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class MessagesItem{

	@SerializedName("mealbarPromoRenderer")
	private MealbarPromoRenderer mealbarPromoRenderer;

	public void setMealbarPromoRenderer(MealbarPromoRenderer mealbarPromoRenderer){
		this.mealbarPromoRenderer = mealbarPromoRenderer;
	}

	public MealbarPromoRenderer getMealbarPromoRenderer(){
		return mealbarPromoRenderer;
	}
}