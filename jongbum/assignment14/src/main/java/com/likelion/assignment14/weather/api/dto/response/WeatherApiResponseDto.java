package com.likelion.assignment14.weather.api.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper; // 이 임포트 추가
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty; // 이 임포트 추가
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JacksonXmlRootElement(localName = "response")
@Getter
@NoArgsConstructor
public class WeatherApiResponseDto {
    // 응답 헤더
    private Header header;

    // 응답 본문
    private Body body;

    // 응답 헤더 정보
    @Getter
    @NoArgsConstructor
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    // 응답 본문 데이터
    @Getter
    @NoArgsConstructor
    public static class Body {
        private String dataType;

        private Items items;

        private Integer numOfRows;

        private Integer pageNo;

        private Integer totalCount;
    }

    // 날씨 아이템 목록
    @Getter
    @NoArgsConstructor
    public static class Items {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "item")
        private List<WeatherListItem> item;
    }

    // 날씨 리스트 정보
    @Getter
    @NoArgsConstructor
    public static class WeatherListItem {
        String baseDate;

        String baseTime;

        String category;

        String fcstDate;

        String fcstTime;

        int fcstValue;

        int nx;

        int ny;
    }
}