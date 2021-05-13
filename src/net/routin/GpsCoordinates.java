package net.routin;


import com.google.gson.Gson;
import net.routin.Models.Coordinates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class GpsCoordinates {
    /**
     * Method to get the JSON file of a URL.
     * @param urlString The url string where the JSON file is stored
     * @return The JSON string
     * @throws Exception In case of error
     */
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    /**
     * Deserialize (or parse) the JSON file into an object.
     * @param place The name of the place to find
     * @return A list of coordinates object containing name, longitude and latitude
     * @throws Exception In case of error
     */
    public List<Coordinates> getGpsCoordinates(String place) throws Exception {
        String json = readUrl("https://nominatim.openstreetmap.org/search?q=" + place + "&format=json");
        Gson gson = new Gson();
        Coordinates[] coordinatesArray = gson.fromJson(json, Coordinates[].class);
        return Arrays.asList(coordinatesArray);
    }
}