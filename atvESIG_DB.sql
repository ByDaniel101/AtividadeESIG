--
-- PostgreSQL database cluster dump
--

-- Started on 2021-02-26 02:47:59

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:5kNNKKdgD+FfblhGI29zGg==$kfJ+NZ+xpW8F35xsngVx7ygzhXGqYVpFJ9XKQMul1m0=:r844ENuBwNDt3FQLUdtqdVCEkhNAwVEXaNdXyK6Hucc=';






--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-02-26 02:47:59

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

-- Completed on 2021-02-26 02:48:00

--
-- PostgreSQL database dump complete
--

--
-- Database "atvESIG" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-02-26 02:48:00

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

--
-- TOC entry 2990 (class 1262 OID 41162)
-- Name: atvESIG; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "atvESIG" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE "atvESIG" OWNER TO postgres;

\connect "atvESIG"

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
-- TOC entry 201 (class 1259 OID 41230)
-- Name: atividades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atividades (
    id integer NOT NULL,
    titulo character varying(30),
    descricao character varying(140),
    responsavel character varying(30),
    prioridade character varying(5),
    deadline character varying(10),
    situacao character varying(12)
);


ALTER TABLE public.atividades OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 41228)
-- Name: atividades_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.atividades_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.atividades_id_seq OWNER TO postgres;

--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 200
-- Name: atividades_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.atividades_id_seq OWNED BY public.atividades.id;


--
-- TOC entry 2850 (class 2604 OID 41236)
-- Name: atividades id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividades ALTER COLUMN id SET DEFAULT nextval('public.atividades_id_seq'::regclass);


--
-- TOC entry 2984 (class 0 OID 41230)
-- Dependencies: 201
-- Data for Name: atividades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atividades (id, titulo, descricao, responsavel, prioridade, deadline, situacao) FROM stdin;
2	segunda	segunda atividade	Maria	Media	29/03/2021	Em andamento
1	primeira	primeira atividade	Joao	Media	20/03/2021	Em andamento
3	terceira	terceira atividade	Cleber	Media	29/03/2021	concluido
6	Trabalha	asasdasd	Cleber	Media	11/11/2020	concluido
\.


--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 200
-- Name: atividades_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.atividades_id_seq', 6, true);


--
-- TOC entry 2852 (class 2606 OID 41235)
-- Name: atividades atividades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividades
    ADD CONSTRAINT atividades_pkey PRIMARY KEY (id);


-- Completed on 2021-02-26 02:48:01

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-02-26 02:48:01

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

--
-- TOC entry 7 (class 2615 OID 16394)
-- Name: pgagent; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA pgagent;


ALTER SCHEMA pgagent OWNER TO postgres;

--
-- TOC entry 3114 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA pgagent; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA pgagent IS 'pgAgent system tables';


--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3115 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


--
-- TOC entry 3 (class 3079 OID 16395)
-- Name: pgagent; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pgagent WITH SCHEMA pgagent;


--
-- TOC entry 3116 (class 0 OID 0)
-- Dependencies: 3
-- Name: EXTENSION pgagent; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgagent IS 'A PostgreSQL job scheduler';


--
-- TOC entry 2907 (class 0 OID 16396)
-- Dependencies: 205
-- Data for Name: pga_jobagent; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_jobagent (jagpid, jaglogintime, jagstation) FROM stdin;
6600	2021-02-25 13:26:54.276304-03	DESKTOP-BROQ53K
\.


--
-- TOC entry 2908 (class 0 OID 16407)
-- Dependencies: 207
-- Data for Name: pga_jobclass; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_jobclass (jclid, jclname) FROM stdin;
\.


--
-- TOC entry 2909 (class 0 OID 16419)
-- Dependencies: 209
-- Data for Name: pga_job; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_job (jobid, jobjclid, jobname, jobdesc, jobhostagent, jobenabled, jobcreated, jobchanged, jobagentid, jobnextrun, joblastrun) FROM stdin;
\.


--
-- TOC entry 2911 (class 0 OID 16471)
-- Dependencies: 213
-- Data for Name: pga_schedule; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_schedule (jscid, jscjobid, jscname, jscdesc, jscenabled, jscstart, jscend, jscminutes, jschours, jscweekdays, jscmonthdays, jscmonths) FROM stdin;
\.


--
-- TOC entry 2912 (class 0 OID 16501)
-- Dependencies: 215
-- Data for Name: pga_exception; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_exception (jexid, jexscid, jexdate, jextime) FROM stdin;
\.


--
-- TOC entry 2913 (class 0 OID 16516)
-- Dependencies: 217
-- Data for Name: pga_joblog; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_joblog (jlgid, jlgjobid, jlgstatus, jlgstart, jlgduration) FROM stdin;
\.


--
-- TOC entry 2910 (class 0 OID 16445)
-- Dependencies: 211
-- Data for Name: pga_jobstep; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_jobstep (jstid, jstjobid, jstname, jstdesc, jstenabled, jstkind, jstcode, jstconnstr, jstdbname, jstonerror, jscnextrun) FROM stdin;
\.


--
-- TOC entry 2914 (class 0 OID 16533)
-- Dependencies: 219
-- Data for Name: pga_jobsteplog; Type: TABLE DATA; Schema: pgagent; Owner: postgres
--

COPY pgagent.pga_jobsteplog (jslid, jsljlgid, jsljstid, jslstatus, jslresult, jslstart, jslduration, jsloutput) FROM stdin;
\.


-- Completed on 2021-02-26 02:48:01

--
-- PostgreSQL database dump complete
--

-- Completed on 2021-02-26 02:48:01

--
-- PostgreSQL database cluster dump complete
--

