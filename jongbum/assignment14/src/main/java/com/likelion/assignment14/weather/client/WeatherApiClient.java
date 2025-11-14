package com.likelion.assignment14.weather.client;

import com.likelion.assignment14.global.code.status.ErrorStatus;
import com.likelion.assignment14.global.exception.GeneralException;
import com.likelion.assignment14.weather.api.dto.response.WeatherApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherApiClient {

    private final RestTemplate restTemplate;

    @Value("${weather.api.base-url}")
    private String baseUrl;     // API 시작 주소

    @Value("${weather.api.auth-key}")
    private String authKey;     // 공공데이터 포털에서 발급받은 인증키

    public String getWeatherEventsAsString(int pageNo, int numOfRows, String baseDate, String baseTime, int nx, int ny) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);

        String url = String.format("%s/getVilageFcst?serviceKey=%s&pageNo=%d&numOfRows=%d&dataType=XML&base_date=%s&base_time=%s&nx=%d&ny=%d", baseUrl, encodedKey, pageNo, numOfRows, baseDate, baseTime, nx, ny);
        try {
            return restTemplate.getForObject(new URI(url), String.class);
        } catch (Exception e) {
            log.error("Weather API 호출 실패 (String)", e);
            throw new GeneralException(ErrorStatus.WEATHER_API_ERROR);
        }
    }

    public WeatherApiResponseDto getWeatherEvents(int pageNo, int numOfRows, String baseDate, String baseTime, int nx, int ny) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);

        String url = String.format("%s/getVilageFcst?serviceKey=%s&pageNo=%d&numOfRows=%d&dataType=XML&base_date=%s&base_time=%s&nx=%d&ny=%d", baseUrl, encodedKey, pageNo, numOfRows, baseDate, baseTime, nx, ny);
        try {
            return restTemplate.getForObject(new URI(url), WeatherApiResponseDto.class);
        } catch (Exception e) {
            log.error("Weather API 호출 실패 (DTO)", e);
            throw new GeneralException(ErrorStatus.WEATHER_API_ERROR);
        }
    }
}
