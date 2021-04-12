package com.tts.mapsapp;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MapService
{
    @Value("${api_key}")
    private String apiKey;
    
    public void addCoordinates(Location location) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
        location.getCity() + "," + location.getState() + "&key=" + apiKey;
        
        RestTemplate restTemplate = new RestTemplate();
        
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }
    
    public void addRandomCoordinates(Location location) {
        
        double lat = ThreadLocalRandom.current().nextDouble(-90, 90);
        double longi = ThreadLocalRandom.current().nextDouble(-180, 180);
        
        System.out.println("lat " + lat);
        System.out.println("longi " + longi);
      
        
        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + 
        lat + "," + longi + "&key=" + apiKey;
        
        RestTemplate restTemplate = new RestTemplate();
        
        
        
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        if(response.getResults().isEmpty()) {
            addRandomCoordinates(location);
           return; 
        }
       
       List<AddressComponent>  coordinates = response.getResults().get(0).getAddressComponents();
       String formattedaddress = response.getResults().get(0).getFormattedAddress();
        for(AddressComponent addressComponent: coordinates) {
                System.out.println("AddressComponent: " + addressComponent.getLongName());
                for(String type: addressComponent.getTypes()) {
                    System.out.println("   Type: " + type);
                    
                }
               
        }
       
        location.setLat(String.valueOf(lat));
        location.setLng(String.valueOf(longi));
        location.setCity(formattedaddress);
        
    }
    
    
}