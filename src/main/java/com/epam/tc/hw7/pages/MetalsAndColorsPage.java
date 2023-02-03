package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.forms.MetalsAndColorsForm;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;

public class MetalsAndColorsPage extends WebPage {

    public MetalsAndColorsForm metalsAndColorsForm;


    @Css(".results li")
    private WebList log;

    public void fillMetalAndColorForm(jdi.entities.MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fill(metalsAndColors);
    }

    public void assertResultLog(jdi.entities.MetalsAndColors metalsAndColors) {
        Assertions.assertThat(actualResultLog()).hasSameElementsAs(metalsAndColors.getResultLog());

    }

    public List<String> actualResultLog() {
        List<String> result = new ArrayList<>();

        log.stream()
           .forEach(els -> {
               result.add(els.getText());
           });

        return result;
    }
}
