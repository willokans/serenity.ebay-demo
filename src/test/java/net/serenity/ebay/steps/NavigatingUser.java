package net.serenity.ebay.steps;

import net.serenity.ebay.model.Category;
import net.serenity.ebay.ui.CategoryNavigationBar;
import net.serenity.ebay.ui.CurrentPage;
import net.serenity.ebay.ui.EbayHomePage;
import net.serenity.ebay.ui.MotorFilter;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigatingUser {

    EbayHomePage ebayHomePage;
    CurrentPage currentPage;
    CategoryNavigationBar categoryNavigationBar;
    MotorFilter motorFilter;

    @Step
    public void isOnTheHomePage() {
        ebayHomePage.open();
    }

    @Step
    public void shouldSeePageTitleContaining(String expectedTitle) {
        assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);
    }

    @Step
    public void navigatesToCategory(Category category) {
        categoryNavigationBar.selectCategory(category);
    }

    @Step
    public void canFilterMotorCategory(String year, String make, String model, String trim, String engine) {

        Map<String, String> motorFilters = new HashMap<String, String>();
        motorFilters.put("Year", year);
        motorFilters.put("Make", make);
        motorFilters.put("model", model);
        motorFilters.put("trim", trim);
        motorFilters.put("Engine", engine);

        for (Map.Entry<String, String> entry : motorFilters.entrySet()) {
            motorFilter.filterMotorCategory(entry.getKey(), entry.getValue());
        }
    }
}
