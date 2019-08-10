package net.serenity.ebay.ui;

import net.serenitybdd.core.pages.PageObject;

public class MotorFilter extends PageObject {

    public void filterMotorCategory(String filterKey, String fileName) {
        System.out.println("xpant is: "+ "select[name='"+filterKey+"']");
//        $("select[name='"+filterKey+"']").click();
//        $("option[value='"+fileName+"']").click();
    }
}
