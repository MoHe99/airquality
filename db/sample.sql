--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1 (Debian 16.1-1.pgdg120+1)
-- Dumped by pg_dump version 16.1 (Debian 16.1-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: air_quality_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.air_quality_data (
    id bigint NOT NULL,
    aqi integer NOT NULL,
    city_station_index bigint NOT NULL,
    time_recorded timestamp(6) without time zone,
    no2 double precision,
    o3 double precision,
    pm10 double precision,
    pm25 double precision
);


ALTER TABLE public.air_quality_data OWNER TO postgres;

--
-- Name: air_quality_data_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.air_quality_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.air_quality_data_id_seq OWNER TO postgres;

--
-- Name: air_quality_data_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.air_quality_data_id_seq OWNED BY public.air_quality_data.id;


--
-- Name: air_quality_forecasts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.air_quality_forecasts (
    id bigint NOT NULL,
    city_station_index bigint NOT NULL,
    forecast_date date,
    o3 double precision,
    pm10 double precision,
    pm25 double precision
);


ALTER TABLE public.air_quality_forecasts OWNER TO postgres;

--
-- Name: air_quality_forecasts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.air_quality_forecasts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.air_quality_forecasts_id_seq OWNER TO postgres;

--
-- Name: air_quality_forecasts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.air_quality_forecasts_id_seq OWNED BY public.air_quality_forecasts.id;


--
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    id bigint NOT NULL,
    geo_latitude double precision NOT NULL,
    geo_longitude double precision NOT NULL,
    name character varying(255) NOT NULL,
    station_index bigint NOT NULL
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- Name: cities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cities_id_seq OWNER TO postgres;

--
-- Name: cities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cities_id_seq OWNED BY public.cities.id;


--
-- Name: air_quality_data id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.air_quality_data ALTER COLUMN id SET DEFAULT nextval('public.air_quality_data_id_seq'::regclass);


--
-- Name: air_quality_forecasts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.air_quality_forecasts ALTER COLUMN id SET DEFAULT nextval('public.air_quality_forecasts_id_seq'::regclass);


--
-- Name: cities id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities ALTER COLUMN id SET DEFAULT nextval('public.cities_id_seq'::regclass);


--
-- Data for Name: air_quality_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.air_quality_data (id, aqi, city_station_index, time_recorded, no2, o3, pm10, pm25) FROM stdin;
65	9	6136	2024-01-20 10:00:00	5	20	9	24
66	12	6136	2024-01-21 10:00:00	5.2	20.5	10.5	25.5
67	8	6136	2024-01-22 10:00:00	4.8	19.5	9.5	24.5
68	11	6136	2024-01-23 10:00:00	5.1	20.2	10.2	24.8
69	10	6136	2024-01-24 10:00:00	5.3	21	10.3	25.3
70	9	6136	2024-01-25 10:00:00	4.9	19.8	9.8	24.7
71	10	6136	2024-01-26 10:00:00	5.2	20.6	10.1	25.1
72	39	10850	2024-01-20 10:00:00	18.5	4.9	13.5	39.5
73	41	10850	2024-01-21 10:00:00	19	5.3	14.3	40.3
74	38	10850	2024-01-22 10:00:00	18.8	5.1	13.8	39.8
75	40	10850	2024-01-23 10:00:00	19.3	5.4	14	40
76	42	10850	2024-01-24 10:00:00	19.6	5.2	14.6	40.6
77	39	10850	2024-01-25 10:00:00	18.7	5	13.7	39.7
78	41	10850	2024-01-26 10:00:00	19.4	5.5	14.4	40.4
79	37	6132	2024-01-20 09:00:00	4	21.5	12.5	37.5
80	39	6132	2024-01-21 09:00:00	4.3	22	13	38
81	36	6132	2024-01-22 09:00:00	3.8	21.8	12.8	37.8
82	38	6132	2024-01-23 09:00:00	4.1	22.3	13.3	38.3
83	37	6132	2024-01-24 09:00:00	4.4	22.5	13.5	37.5
84	36	6132	2024-01-25 09:00:00	3.9	21.6	12.6	37.6
85	38	6132	2024-01-26 09:00:00	4.2	22.7	13.7	38.7
86	25	11226	2024-01-20 10:00:00	19.9	4.5	11.5	25.5
87	27	11226	2024-01-21 10:00:00	20.3	4.8	12.3	26.3
88	24	11226	2024-01-22 10:00:00	20.1	4.6	11.8	25.8
89	26	11226	2024-01-23 10:00:00	20.4	5	12	26
90	25	11226	2024-01-24 10:00:00	20.7	4.7	12.7	26.7
91	24	11226	2024-01-25 10:00:00	19.8	4.4	11.4	25.4
92	27	11226	2024-01-26 10:00:00	20.5	5.1	12.5	26.5
93	45	10833	2024-01-20 09:00:00	12.8	13.8	20.8	45.8
94	47	10833	2024-01-21 09:00:00	13.5	14	21.5	46.5
95	44	10833	2024-01-22 09:00:00	12.6	13.6	20.6	45.6
96	46	10833	2024-01-23 09:00:00	13.2	14.2	21.2	46.2
97	45	10833	2024-01-24 09:00:00	13.7	14.5	21.7	45.7
98	44	10833	2024-01-25 09:00:00	12.5	13.5	20.5	45.5
99	47	10833	2024-01-26 09:00:00	13.6	14.6	21.6	46.6
100	17	6099	2024-01-20 10:00:00	19.2	\N	17	42
101	19	6099	2024-01-21 10:00:00	20	\N	18.5	43.5
102	16	6099	2024-01-22 10:00:00	18.9	\N	17.5	42.5
103	18	6099	2024-01-23 10:00:00	19.5	\N	18.2	43.2
104	17	6099	2024-01-24 10:00:00	19.8	\N	17.8	42.8
105	16	6099	2024-01-25 10:00:00	18.6	\N	17.3	42.3
106	18	6099	2024-01-26 10:00:00	19.7	\N	18.1	43.1
108	35	10850	2024-01-27 11:00:00	19.2	14.4	14	35
107	10	6136	2024-01-27 12:00:00	4.6	21.2	10	25
109	21	6099	2024-01-27 12:00:00	17.4	\N	21	43
110	42	6132	2024-01-27 11:00:00	11.9	21.2	15	42
111	29	11226	2024-01-27 12:00:00	11.5	17.5	12	29
112	19	10833	2024-01-27 11:00:00	15.6	18.7	22	46
\.


--
-- Data for Name: air_quality_forecasts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.air_quality_forecasts (id, city_station_index, forecast_date, o3, pm10, pm25) FROM stdin;
938	6136	2024-01-28	7	22	66
939	6136	2024-01-29	4	27	76
940	6136	2024-01-30	5	27	79
941	6136	2024-01-31	8	23	68
942	10850	2024-01-28	14	18	57
943	10850	2024-01-29	7	25	72
944	10850	2024-01-30	6	25	75
945	10850	2024-01-31	9	23	71
946	6099	2024-01-28	19	13	44
947	6099	2024-01-29	11	17	55
948	6099	2024-01-30	8	19	60
949	6099	2024-01-31	6	20	61
950	6132	2024-01-28	11	17	57
951	6132	2024-01-29	12	12	45
952	6132	2024-01-30	8	17	58
953	6132	2024-01-31	10	17	57
954	11226	2024-01-28	12	16	55
955	11226	2024-01-29	6	20	65
956	11226	2024-01-30	10	18	58
957	11226	2024-01-31	15	13	50
958	10833	2024-01-28	11	20	57
959	10833	2024-01-29	7	17	57
960	10833	2024-01-30	4	23	69
961	10833	2024-01-31	8	21	67
\.


--
-- Data for Name: cities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cities (id, geo_latitude, geo_longitude, name, station_index) FROM stdin;
1	49.9937671	8.2736363	Mainz	6136
2	50.078333333333	8.2313888888889	Wiesbaden	10850
3	50.947268	6.957649	Köln	6099
4	52.5200066	13.404954	Berlin	6132
5	48.783150000042	9.1807305558523	Stuttgart	11226
6	53.59235	10.053724	Hamburg	10833
\.


--
-- Name: air_quality_data_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.air_quality_data_id_seq', 112, true);


--
-- Name: air_quality_forecasts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.air_quality_forecasts_id_seq', 961, true);


--
-- Name: cities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cities_id_seq', 6, true);


--
-- Name: air_quality_data air_quality_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.air_quality_data
    ADD CONSTRAINT air_quality_data_pkey PRIMARY KEY (id);


--
-- Name: air_quality_forecasts air_quality_forecasts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.air_quality_forecasts
    ADD CONSTRAINT air_quality_forecasts_pkey PRIMARY KEY (id);


--
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

