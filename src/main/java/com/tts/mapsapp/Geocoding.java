package com.tts.mapsapp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Geocoding
{
    private Geometry geometry;
    
    @JsonProperty("address_components")
    private List<AddressComponent> addressComponents;
    
    @JsonProperty("formatted_address")
    private String formattedAddress;
    
}
