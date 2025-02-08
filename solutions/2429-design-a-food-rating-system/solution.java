class FoodRatings {

    static class Food implements Comparable<Food> {
        int rating;
        String foodName;

        public Food(int rating, String foodName) {
            this.rating = rating;
            this.foodName = foodName;
        }

        @Override
        public int compareTo(Food other) {
            if (other.rating == this.rating) {
                return this.foodName.compareTo(other.foodName);
            }
            return -1 * Integer.compare(this.rating, other.rating);
        }
    }

    Map<String, Integer> foodRatingMap;
    Map<String, String> foodCuisineMap;
    Map<String, PriorityQueue<Food>> cuisineToFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        this.foodRatingMap = new HashMap<>();
        this.foodCuisineMap = new HashMap<>();
        this.cuisineToFoodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            cuisineToFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>())
                                                .add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food,newRating);
        String cuisine = foodCuisineMap.get(food);
        cuisineToFoodMap.get(cuisine).offer(new Food(newRating,food));
    }

    public String highestRated(String cuisine) {
        Food highestRatedFood = cuisineToFoodMap.get(cuisine).peek();

        // remove older entry from PQ
        while (highestRatedFood.rating != foodRatingMap.get(highestRatedFood.foodName)){
            cuisineToFoodMap.get(cuisine).poll();
            highestRatedFood = cuisineToFoodMap.get(cuisine).peek();
        }
        return highestRatedFood.foodName;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
