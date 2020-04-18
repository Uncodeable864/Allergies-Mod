package net.kidkoder.allergies.system.allergy;

public enum Allergen {

    GOLD,
    EGGS,
    WHEAT,
    MILK;

    public static Allergen intToAllergen(int i) {
        switch (i) {
            case 0:
                return GOLD;
            case 1:
                return EGGS;
            case 2:
                return WHEAT;
            case 3:
                return MILK;

        }
        return null;
    }

    public static String allergenToString(Allergen allergen) {
        switch (allergen) {
            case EGGS:
                return "eggs";
            case GOLD:
                return "gold";
            case WHEAT:
                return "wheat";
            case MILK:
                return "milk";
        }
        return null;
    }

}
