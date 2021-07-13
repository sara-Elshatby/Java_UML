package com.trial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Creating object list of the countries  and cities from CSV files
        String country_Path = "C:\\countries2.csv";
        String city_Path = "C:\\cities2.csv";
        readFiles.ReadFromCSV reader = new readFiles.ReadFromCSV();

        List<cityclass> cityList = reader.readCityFromCSV(city_Path);
        List<countryclass> countryList = reader.readCountryFromCSV(country_Path);

//Mapping each country codes to a list of city names  that lie in this country
        Map<String, List<String>> listing = cityList.stream()
                .collect(Collectors.groupingBy(cityclass::getCountryCode,
                 TreeMap::new,Collectors.mapping(cityclass::getName, Collectors.toList())));

//reading from the Console by entre the country code
        InputStreamReader consoleIn = new InputStreamReader(System.in);
        BufferedReader buffread = new BufferedReader(consoleIn);
        String countryCode = null;
        System.out.print("\nEnter a country code to sort its cities by population: ");
        try {
            countryCode = buffread.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//sorting the cities according to the population
        System.out.println(reader.CitiesByPopulation(countryCode));

//getting a List of countries population
        System.out.println("List of the countries population\n"+reader.CountryPopulation()+"\n");

//determine the average countries population
        OptionalDouble avg = reader.AvgCountryPopulation();
        System.out.println("The Average Country populations= "+ avg+"\n");

// determine the maximum countries population
        OptionalDouble Max = reader.MaxCountriesPopulation();
        System.out.println("The Max Country population= "+ Max+"\n");

//detecting the highest population city in each country
        for (countryclass country: countryList) {
            try {
                System.out.println("The Highest population in " + country + " is " + reader.HighestPopulationCountry(country.getCode()));
            } catch (Exception ignored) {

            }
        }

//to print the highest population capital
        System.out.println("\nThe Highest population capital is "+ reader.HighestCityPopulation());


    }
}
