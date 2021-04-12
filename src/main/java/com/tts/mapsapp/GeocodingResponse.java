package com.tts.mapsapp;

import java.util.List;

import lombok.Data;

@Data
public class GeocodingResponse
{
    private List<Geocoding> results;
    
    private String status;
}
