package com.epam.tc.hw7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderMetalsAndColors {

    @DataProvider(name = "DataProviderJson")
    public Object[][] dataProviderMetalColor() throws FileNotFoundException {
        Object[][] object = new Object[0][];
        String path = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
        {
            try {
                ObjectMapper mapper = new ObjectMapper();
                FileInputStream fileInputStream = new FileInputStream(path);
                HashMap<String, jdi.entities.MetalsAndColors> map = mapper.readValue(fileInputStream,
                    new TypeReference<HashMap<String, jdi.entities.MetalsAndColors>>() {
                    });
                int i = 0;
                object = new Object[map.size()][1];
                for (Map.Entry<String, jdi.entities.MetalsAndColors> entry : map.entrySet()) {
                    object[i][0] = entry.getValue();
                    i++;
                }
                fileInputStream.close();
            } catch (Exception e) {
                throw new FileNotFoundException("file not found");
            }

        }
        return object;
    }
}
