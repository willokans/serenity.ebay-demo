package net.serenity.ebay.ui;

import net.serenity.ebay.model.Category;
import net.serenitybdd.core.pages.PageObject;

public class CategoryNavigationBar extends PageObject {
    public void selectCategory(Category category) {
        $("//li[@class='hl-cat-nav__js-tab']/a[text()='"+category+"']").click();

    }
}
