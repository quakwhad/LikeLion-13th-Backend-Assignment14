package com.likelion.assignment14.weather.application;

import com.likelion.assignment14.weather.client.WeatherApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WeatherService {
    private final WeatherApiClient weatherApiClient;

    public String getWeatherEventsRaw(int page, int size, String bateDate, String baseTime, int nx, int ny) {
        return weatherApiClient.getWeatherEventsAsString(page, size, bateDate, baseTime, nx, ny);
    }
}
