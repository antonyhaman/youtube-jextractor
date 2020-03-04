package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class MessagesItem {

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
