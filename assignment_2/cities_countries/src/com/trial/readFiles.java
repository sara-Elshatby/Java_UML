package com.trial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class readFiles {


    public static class ReadFromCSV implements cityinterface,countryinterface{
        List<countryclass> Countries = new ArrayList<countryclass>();
        List<cityclass> Cities = new ArrayList<cityclass>();



        @Override
        public List<cityclass> readCityFromCSV(String filepath) {

            BufferedReader buffread = null;
            try {
                try {
                    buffread = new BufferedReader(new FileReader(filepath));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String line = null;
                try {
                    line = buffread.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (line  != null) {
                    String[] attributes = line.split(",");
                    cityclass newc = createCity(attributes);
                    Cities.add(newc);
                    line = buffread.readLine();
                }
                return Cities;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public cityclass createCity(String[] data) {
            cityclass myc= null;
            myc = new cityclass(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3].trim());
            return myc;
        }

        @Override
        public List<countryclass> readCountryFromCSV(String filepath) {

            BufferedReader buffread = null;
            try {
                buffread = new BufferedReader(new FileReader(filepath));
                String line;
                line = buffread.readLine();
                while (line  != null) {
                    String[] attributes = line.split(",");
                    countryclass newc;
                    newc = createCountry(attributes);
                    Countries.add(newc);
                    line = buffread.readLine();
                }
                return Countries;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public countryclass createCountry(String[] data) {
            countryclass column;
            column = new countryclass(data[0], data[1], data[2] , Double.parseDouble(data[3]), Double.parseDouble(data[4]), Integer.parseInt(data[6]));
            return column;
        }


        public List<cityclass> CitiesByPopulation(String countryCode){

//create a map of country code to a list of the cities that lies in this country

            Map<String, List<cityclass>> MappingCity = Cities.stream()
                    .collect(Collectors.groupingBy(cityclass::getCountryCode));

//sorting the cities of Country by Population

            return MappingCity.get(countryCode).stream()
                    .sorted(Comparator.comparingInt(cityclass::getPopulation)).collect(Collectors.toList());
        }

        public Map<String, Double> CountryPopulation(){

//mapping  the country code with the population of that country

            return Countries.stream()
                    .collect(Collectors.toMap(countryclass::getCode, countryclass::getPopulation));
        }

        public OptionalDouble AvgCountryPopulation(){

//return the average population of all the countries

            return Countries.stream()
                    .mapToDouble(countryclass::getPopulation).average();
        }

        public OptionalDouble MaxCountriesPopulation() {

//return the max population of all the countries

            return Countries.stream()
                    .mapToDouble(countryclass::getPopulation).max();
        }

        public OptionalDouble HighestPopulationCountry(String countrycode){

//return the highest population city in a given country

            return CitiesByPopulation(countrycode).stream()
                    .mapToDouble(cityclass::getPopulation).max();
        }

        public Optional<cityclass> HighestCityPopulation(){

//return the city of the highest population

            //capital map is a map of the country codes and the capital index
            Map<String, Integer> capitalMap = Countries.stream().collect(Collectors.toMap(countryclass::getCode, countryclass::getCapital));
            //capitals is a list of all the cities indexed as capitals in the countries file
            List<cityclass> capitals=null;
            for (String s:capitalMap.keySet()) {
                capitals = Cities.stream().filter(city -> capitalMap.containsValue(city.getId())).collect(Collectors.toList());
            }

            return capitals.stream().max(Comparator.comparingInt(cityclass::getPopulation));
        }

    }
}
