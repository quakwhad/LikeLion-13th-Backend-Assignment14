package com.likelion.assignment14.weather.api;

import com.likelion.assignment14.weather.application.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/raw")
    public ResponseEntity<String> getWeatherRaw(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "1") int size,
            @RequestParam(defaultValue = "20251113") String baseDate,
            @RequestParam(defaultValue = "0500") String baseTime,
            @RequestParam(defaultValue = "55") int nx,
            @RequestParam(defaultValue = "127") int ny) {

        String response = weatherService.getWeatherEventsRaw(page, size, baseDate, baseTime, nx, ny);
        return ResponseEntity.ok(response);
    }
}
