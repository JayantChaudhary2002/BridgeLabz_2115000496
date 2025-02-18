import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private String userName;
    private List<T> mealPlans;

    public Meal(String userName) {
        this.userName = userName;
        this.mealPlans = new ArrayList<>();
    }

    public void addMealPlan(T mealPlan) {
        mealPlans.add(mealPlan);
    }

    public <E extends MealPlan> void generateMealPlan(E mealPlan) {
        if (validateMealPlan(mealPlan)) {
            System.out.println(userName + ", your personalized meal plan includes: " + mealPlan.getMealType());
        } else {
            System.out.println("Invalid meal plan selection.");
        }
    }

    private <E extends MealPlan> boolean validateMealPlan(E mealPlan) {
        // Here we can add more complex validation logic if needed
        return mealPlan != null;
    }

    public void displayMealPlans() {
        System.out.println(userName + "'s Meal Plans:");
        for (T mealPlan : mealPlans) {
            System.out.println(" - " + mealPlan.getMealType());
        }
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {

        Meal<MealPlan> mealPlanGenerator = new Meal<>("Alice");

        mealPlanGenerator.addMealPlan(new VegetarianMeal());
        mealPlanGenerator.addMealPlan(new VeganMeal());
        mealPlanGenerator.addMealPlan(new KetoMeal());
        mealPlanGenerator.addMealPlan(new HighProteinMeal());

        mealPlanGenerator.displayMealPlans();

        mealPlanGenerator.generateMealPlan(new VegetarianMeal());
        mealPlanGenerator.generateMealPlan(new VeganMeal());
        mealPlanGenerator.generateMealPlan(new KetoMeal());
        mealPlanGenerator.generateMealPlan(new HighProteinMeal());
    }
}
