package com.example.fallingfood.Sprites;

enum FoodType {
    CEREZA,
    ENSALADA,
    FRESA,
    JAMON,
    PIZZA,
    WRAP;

        FoodType randomFoodType() {
                switch ((int) ((Math.random()*6)+1)){
                        case 1 -> {return CEREZA;}
                        case 2 -> {return ENSALADA;}
                        case 3 -> {return FRESA;}
                        case 4 -> {return JAMON;}
                        case 5 -> {return PIZZA;}
                        case 6 -> {return WRAP;}
                        default -> {
                                return null;
                        }
                }
        }
}


