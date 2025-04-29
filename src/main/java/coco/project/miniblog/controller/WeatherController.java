package coco.project.miniblog.controller;

import coco.project.miniblog.dto.PosDTO;
import coco.project.miniblog.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/")
    public String getWeather(@RequestBody PosDTO posDTO) {
        return weatherService.getWeather(posDTO.getLatitude(), posDTO.getLongitude());
    }

}
