package net.serenity.ebay.ui;

import net.serenity.ebay.model.Category;
import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {
    public static Target category(Category category){
        return Target.the(category.name() + " category")
                .locatedBy("//li[@class='hl-cat-nav__js-tab']/a[text()='{0}']")
                .of(category.name());
    }
}
