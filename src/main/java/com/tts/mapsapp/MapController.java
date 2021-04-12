package com.tts.mapsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.mapsapp.Location;
import com.tts.mapsapp.MapService;

@Controller
public class MapController
{
    @Autowired
    MapService mapService;

    @GetMapping("/")
    public String getDefaulfMap(Model model)
    {
        model.addAttribute(new Location());
        return "index.html";
    }
    
    @PostMapping("/")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "index.html";
    }
    @PostMapping("/random")
    public String getMapForRandomLocation(Location location, Model model) {
        mapService.addRandomCoordinates(location);
        model.addAttribute(location);
        return"index.html";       
    }
    
}
