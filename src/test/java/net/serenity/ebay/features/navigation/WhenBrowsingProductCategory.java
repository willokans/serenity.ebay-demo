package net.serenity.ebay.features.navigation;

import net.serenity.ebay.model.Category;
import net.serenity.ebay.steps.NavigatingUser;
import net.serenity.ebay.tasks.NavigateTo;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenity.ebay.model.Category.Motors;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenBrowsingProductCategory {

    @Steps
    NavigatingUser mark;

    @Managed
    WebDriver browser;

    @Test
    public void shouldBeAbleToNavigateToTheMotorsCategory() {
        //Given
        mark.isOnTheHomePage();

        //When
        mark.navigatesToCategory(Motors);

        //Then
        mark.shouldSeePageTitleContaining("eBay Motors: Auto Parts and Vehicles | eBay");

        //And

        mark.canFilterMotorCategory("2015", "BMW", "130i", "Base Hatchback 2-Door", "3.0L 2996CC l6 GAS DOHC Naturally Aspirated");
    }

    @Test
    public void shouldBeAbleToViewMotorProducts() {
        Actor mike = Actor.named("Mike");
        mike.can(BrowseTheWeb.with(browser));

        when(mike).attemptsTo(NavigateTo.theCategory(Motors));

        then(mike).should(seeThat(TheWebPage.title(), containsString("eBay Motors: Auto Parts and Vehicles | eBay")));
    }
}
