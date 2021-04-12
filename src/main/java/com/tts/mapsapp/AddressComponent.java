package com.tts.mapsapp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddressComponent
{
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("long_name")
    private String longName;

    private List<String> types;

}
