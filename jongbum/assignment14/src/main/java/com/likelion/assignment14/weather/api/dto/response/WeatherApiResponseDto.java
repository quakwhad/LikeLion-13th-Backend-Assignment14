package com.likelion.assignment14.weather.api.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class WeatherApiResponseDto {
    // 응답 헤더
    private Header header;

    // 응답 본문
    private Body body;

    // 응답 헤더 정보
    @Getter
    @NoArgsConstructor
    public static class Header {
        // 결과 코드
        private String resultCode;

        // 결과 메시지
        private String resultMsg;
    }

    // 응답 본문 데이터
    @Getter
    @NoArgsConstructor
    public static class Body {
        // 전체 건수
        private Integer totalCount;

        // 페이지 번호
        private Integer pageNo;

        // 페이지당 행 수
        private Integer numOfRows;

        // 문화행사 목록
        private Items items;
    }

    // 문화행사 아이템 목록
    @Getter
    @NoArgsConstructor
    public static class Items {
        // 문화행사 배열
        private List<WeatherListItem> item;
    }

    // 문화행사 리스트 정보
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
