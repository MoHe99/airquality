package com.moritzherrmann.airquality.model;

import java.util.List;

public class AirQualityApiResponse {

    private String status;

    private Data data;

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Data getData() { return data; }

    public void setData(Data data) { this.data = data; }

    public static class Data {
        private Integer aqi;
        private Time time;
        private Long idx;
        private IAQI iaqi;
        private Forecast forecast;

        public Long getIdx() { return idx; }

        public void setIdx(Long idx) { this.idx = idx; }

        public Integer getAqi() { return aqi; }

        public void setAqi(Integer aqi) { this.aqi = aqi; }

        public Time getTime() { return time; }

        public void setTime(Time time) { this.time = time; }

        public IAQI getIaqi() { return iaqi; }

        public void setIaqi(IAQI iaqi) { this.iaqi = iaqi; }

        public Forecast getForecast() { return forecast; }

        public void setForecast(Forecast forecast) { this.forecast = forecast; }

        public static class Time {
            private String iso;

            public String getIso() { return iso; }

            public void setIso(String iso) { this.iso = iso; }
        }

        public static class IAQI {
            private Value o3;
            private Value pm10;
            private Value pm25;
            private Value no2;

            // Getter und Setter für o3, pm10, pm25 und no2
            public Value getO3() { return o3; }
            public void setO3(Value o3) { this.o3 = o3; }

            public Value getPm10() { return pm10; }
            public void setPm10(Value pm10) { this.pm10 = pm10; }

            public Value getPm25() { return pm25; }
            public void setPm25(Value pm25) { this.pm25 = pm25; }

            public Value getNo2() { return no2; }
            public void setNo2(Value no2) { this.no2 = no2; }
        }

        public static class Value {
            private Double v;

            public Double getV() { return v; }

            public void setV(Double v) { this.v = v; }
        }

        public static class Forecast {
            private Daily daily;

            public Daily getDaily() { return daily; }

            public void setDaily(Daily daily) { this.daily = daily; }

            public static class Daily {
                private List<Pollutant> o3;
                private List<Pollutant> pm10;
                private List<Pollutant> pm25;

                public List<Pollutant> getO3() { return o3; }

                public void setO3(List<Pollutant> o3) { this.o3 = o3; }

                public List<Pollutant> getPm10() { return pm10; }

                public void setPm10(List<Pollutant> pm10) { this.pm10 = pm10; }

                public List<Pollutant> getPm25() { return pm25; }

                public void setPm25(List<Pollutant> pm25) { this.pm25 = pm25; }
            }
        }

        public static class Pollutant {
            private Double avg;
            private String day;
            private Double max;
            private Double min;

            public Double getAvg() { return avg; }

            public void setAvg(Double avg) { this.avg = avg; }

            public String getDay() { return day; }

            public void setDay(String day) { this.day = day; }

            public Double getMax() { return max; }

            public void setMax(Double max) { this.max = max; }

            public Double getMin() { return min; }

            public void setMin(Double min) { this.min = min; }
        }
    }
}

