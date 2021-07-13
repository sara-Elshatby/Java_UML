package com.trial;

import java.util.List;

public interface countryinterface {
    public List<countryclass> readCountryFromCSV(String filepath);
    public countryclass createCountry(String[] data);
}
