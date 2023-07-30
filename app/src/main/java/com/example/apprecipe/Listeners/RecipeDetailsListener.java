package com.example.apprecipe.Listeners;

import com.example.apprecipe.models.RecipeDetailsResponse;


public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response, String message);
    void didError(String message);
}
