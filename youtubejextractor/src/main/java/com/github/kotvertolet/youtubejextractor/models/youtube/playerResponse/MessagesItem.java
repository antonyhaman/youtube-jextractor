package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class MessagesItem implements Serializable {

    private MealbarPromoRenderer mealbarPromoRenderer;

    public MealbarPromoRenderer getMealbarPromoRenderer() {
        return mealbarPromoRenderer;
    }

    public void setMealbarPromoRenderer(MealbarPromoRenderer mealbarPromoRenderer) {
        this.mealbarPromoRenderer = mealbarPromoRenderer;
    }

    @Override
    public String toString() {
        return
                "MessagesItem{" +
                        "mealbarPromoRenderer = '" + mealbarPromoRenderer + '\'' +
                        "}";
    }
}
