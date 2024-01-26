package com.moritzherrmann.airquality.model;

public class AirQualityApiResponse {

    private String status;

    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Integer aqi;
        private Time time;

        private Long idx;

        public Long getIdx() { return idx; }

        public void setIdx(Long idx) { this.idx = idx; }

        public Integer getAqi() {
            return aqi;
        }

        public void setAqi(Integer aqi) {
            this.aqi = aqi;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public static class Time {
            private String iso;

            public String getIso() { return iso; }

            public void setIso(String iso) { this.iso = iso; }
        }
    }
}

