package com.trip.dao;

import java.util.ArrayList;

import com.trip.domain.Food;



public interface FoodDao {
     public ArrayList<Food> queryByName(String name);
     
}
