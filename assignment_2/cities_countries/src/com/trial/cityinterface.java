package com.trial;

import java.util.List;

public interface cityinterface {
    public List<cityclass> readCityFromCSV(String filepath);


    public cityclass createCity (String[] data);
}
