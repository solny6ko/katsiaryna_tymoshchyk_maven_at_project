package practice;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MyRecipeRunner {
    public static void main(String[] args) throws IOException {
        MyRecipeRunner recipe = new MyRecipeRunner();
        recipe.toJson();
        recipe.fromJson();
    }

    ObjectMapper objectMapper = new ObjectMapper();

    public void toJson() throws IOException {
        Recipe recipe = new Recipe("Salad",
                Arrays.asList(new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)), 3);
        objectMapper.writerWithDefaultPrettyPrinter().
                writeValue(new File("src/test/resources/recipe2.json"), recipe);
    }

    public void fromJson() throws IOException {
        Recipe recipe = objectMapper
                .readValue(new File("src/test/resources/recipe2.json"), Recipe.class);
        System.out.println(recipe);
    }
}
