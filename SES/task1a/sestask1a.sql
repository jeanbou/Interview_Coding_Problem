PGDMP         #            	    y        	   sestask1a    14.0    14.0 (               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16394 	   sestask1a    DATABASE     e   CREATE DATABASE sestask1a WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';
    DROP DATABASE sestask1a;
                postgres    false            �            1259    16404    CITY    TABLE     �   CREATE TABLE public."CITY" (
    "City_ID" integer NOT NULL,
    "Name" character varying(64)[],
    "Coordinates" character varying(22)[]
);
    DROP TABLE public."CITY";
       public         heap    postgres    false                       0    0    TABLE "CITY"    COMMENT     :   COMMENT ON TABLE public."CITY" IS 'The city information';
          public          postgres    false    211            �            1259    16407    Cities_City_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."Cities_City_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."Cities_City_ID_seq";
       public          postgres    false    211                       0    0    Cities_City_ID_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public."Cities_City_ID_seq" OWNED BY public."CITY"."City_ID";
          public          postgres    false    212            �            1259    16396    PERSON    TABLE       CREATE TABLE public."PERSON" (
    "Person_ID" integer NOT NULL,
    "Name" character varying(32)[],
    "Surname" character varying(64)[],
    "Person_ID_Number" character varying(32)[],
    "Current_Job_Role" character varying(128)[],
    "Registration_Date" date
);
    DROP TABLE public."PERSON";
       public         heap    postgres    false                       0    0    TABLE "PERSON"    COMMENT     �   COMMENT ON TABLE public."PERSON" IS 'The table containes detailed info about the real person and the date of his her registration in our db ';
          public          postgres    false    210            �            1259    16395    PERSON_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."PERSON_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public."PERSON_ID_seq";
       public          postgres    false    210                       0    0    PERSON_ID_seq    SEQUENCE OWNED BY     L   ALTER SEQUENCE public."PERSON_ID_seq" OWNED BY public."PERSON"."Person_ID";
          public          postgres    false    209            �            1259    16419    REGISTRATION_JOURNAL    TABLE     �   CREATE TABLE public."REGISTRATION_JOURNAL" (
    "JOURNAL_ID" integer NOT NULL,
    "FK_Person_ID" integer NOT NULL,
    "FK_City_ID" integer NOT NULL,
    "CheckIn_Date" date,
    "CheckOut_Date" date
);
 *   DROP TABLE public."REGISTRATION_JOURNAL";
       public         heap    postgres    false                       0    0    TABLE "REGISTRATION_JOURNAL"    COMMENT     e   COMMENT ON TABLE public."REGISTRATION_JOURNAL" IS 'All visites or living status is registered here';
          public          postgres    false    216            �            1259    16418     REGISTRATION_JOURNAL_City_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."REGISTRATION_JOURNAL_City_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public."REGISTRATION_JOURNAL_City_ID_seq";
       public          postgres    false    216                       0    0     REGISTRATION_JOURNAL_City_ID_seq    SEQUENCE OWNED BY     n   ALTER SEQUENCE public."REGISTRATION_JOURNAL_City_ID_seq" OWNED BY public."REGISTRATION_JOURNAL"."FK_City_ID";
          public          postgres    false    215            �            1259    16416 #   REGISTRATION_JOURNAL_JOURNAL_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."REGISTRATION_JOURNAL_JOURNAL_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public."REGISTRATION_JOURNAL_JOURNAL_ID_seq";
       public          postgres    false    216                       0    0 #   REGISTRATION_JOURNAL_JOURNAL_ID_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public."REGISTRATION_JOURNAL_JOURNAL_ID_seq" OWNED BY public."REGISTRATION_JOURNAL"."JOURNAL_ID";
          public          postgres    false    213            �            1259    16417 "   REGISTRATION_JOURNAL_Person_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."REGISTRATION_JOURNAL_Person_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public."REGISTRATION_JOURNAL_Person_ID_seq";
       public          postgres    false    216                       0    0 "   REGISTRATION_JOURNAL_Person_ID_seq    SEQUENCE OWNED BY     r   ALTER SEQUENCE public."REGISTRATION_JOURNAL_Person_ID_seq" OWNED BY public."REGISTRATION_JOURNAL"."FK_Person_ID";
          public          postgres    false    214            i           2604    16408    CITY City_ID    DEFAULT     t   ALTER TABLE ONLY public."CITY" ALTER COLUMN "City_ID" SET DEFAULT nextval('public."Cities_City_ID_seq"'::regclass);
 ?   ALTER TABLE public."CITY" ALTER COLUMN "City_ID" DROP DEFAULT;
       public          postgres    false    212    211            h           2604    16399    PERSON Person_ID    DEFAULT     s   ALTER TABLE ONLY public."PERSON" ALTER COLUMN "Person_ID" SET DEFAULT nextval('public."PERSON_ID_seq"'::regclass);
 C   ALTER TABLE public."PERSON" ALTER COLUMN "Person_ID" DROP DEFAULT;
       public          postgres    false    210    209    210            j           2604    16422    REGISTRATION_JOURNAL JOURNAL_ID    DEFAULT     �   ALTER TABLE ONLY public."REGISTRATION_JOURNAL" ALTER COLUMN "JOURNAL_ID" SET DEFAULT nextval('public."REGISTRATION_JOURNAL_JOURNAL_ID_seq"'::regclass);
 R   ALTER TABLE public."REGISTRATION_JOURNAL" ALTER COLUMN "JOURNAL_ID" DROP DEFAULT;
       public          postgres    false    213    216    216            k           2604    16423 !   REGISTRATION_JOURNAL FK_Person_ID    DEFAULT     �   ALTER TABLE ONLY public."REGISTRATION_JOURNAL" ALTER COLUMN "FK_Person_ID" SET DEFAULT nextval('public."REGISTRATION_JOURNAL_Person_ID_seq"'::regclass);
 T   ALTER TABLE public."REGISTRATION_JOURNAL" ALTER COLUMN "FK_Person_ID" DROP DEFAULT;
       public          postgres    false    216    214    216            l           2604    16424    REGISTRATION_JOURNAL FK_City_ID    DEFAULT     �   ALTER TABLE ONLY public."REGISTRATION_JOURNAL" ALTER COLUMN "FK_City_ID" SET DEFAULT nextval('public."REGISTRATION_JOURNAL_City_ID_seq"'::regclass);
 R   ALTER TABLE public."REGISTRATION_JOURNAL" ALTER COLUMN "FK_City_ID" DROP DEFAULT;
       public          postgres    false    216    215    216                      0    16404    CITY 
   TABLE DATA           B   COPY public."CITY" ("City_ID", "Name", "Coordinates") FROM stdin;
    public          postgres    false    211   W/                 0    16396    PERSON 
   TABLE DATA              COPY public."PERSON" ("Person_ID", "Name", "Surname", "Person_ID_Number", "Current_Job_Role", "Registration_Date") FROM stdin;
    public          postgres    false    210   �/       	          0    16419    REGISTRATION_JOURNAL 
   TABLE DATA           }   COPY public."REGISTRATION_JOURNAL" ("JOURNAL_ID", "FK_Person_ID", "FK_City_ID", "CheckIn_Date", "CheckOut_Date") FROM stdin;
    public          postgres    false    216   �/                  0    0    Cities_City_ID_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."Cities_City_ID_seq"', 1, false);
          public          postgres    false    212                       0    0    PERSON_ID_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."PERSON_ID_seq"', 1, false);
          public          postgres    false    209                       0    0     REGISTRATION_JOURNAL_City_ID_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public."REGISTRATION_JOURNAL_City_ID_seq"', 1, false);
          public          postgres    false    215                       0    0 #   REGISTRATION_JOURNAL_JOURNAL_ID_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public."REGISTRATION_JOURNAL_JOURNAL_ID_seq"', 1, false);
          public          postgres    false    213                       0    0 "   REGISTRATION_JOURNAL_Person_ID_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public."REGISTRATION_JOURNAL_Person_ID_seq"', 1, false);
          public          postgres    false    214            p           2606    16471    CITY CITY_ID_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."CITY"
    ADD CONSTRAINT "CITY_ID_pkey" PRIMARY KEY ("City_ID");
 ?   ALTER TABLE ONLY public."CITY" DROP CONSTRAINT "CITY_ID_pkey";
       public            postgres    false    211            n           2606    16479    PERSON Person_ID_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."PERSON"
    ADD CONSTRAINT "Person_ID_pkey" PRIMARY KEY ("Person_ID");
 C   ALTER TABLE ONLY public."PERSON" DROP CONSTRAINT "Person_ID_pkey";
       public            postgres    false    210            r           2606    16426 1   REGISTRATION_JOURNAL REGISTRATION_JOURNAL_ID_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public."REGISTRATION_JOURNAL"
    ADD CONSTRAINT "REGISTRATION_JOURNAL_ID_pkey" PRIMARY KEY ("JOURNAL_ID");
 _   ALTER TABLE ONLY public."REGISTRATION_JOURNAL" DROP CONSTRAINT "REGISTRATION_JOURNAL_ID_pkey";
       public            postgres    false    216            s           1259    16477    fki_FK_City_ID_to_CITIES    INDEX     e   CREATE INDEX "fki_FK_City_ID_to_CITIES" ON public."REGISTRATION_JOURNAL" USING btree ("FK_City_ID");
 .   DROP INDEX public."fki_FK_City_ID_to_CITIES";
       public            postgres    false    216            t           1259    16490    fki_FK_Person_ID_to_PERSON    INDEX     i   CREATE INDEX "fki_FK_Person_ID_to_PERSON" ON public."REGISTRATION_JOURNAL" USING btree ("FK_Person_ID");
 0   DROP INDEX public."fki_FK_Person_ID_to_PERSON";
       public            postgres    false    216            u           2606    16472 )   REGISTRATION_JOURNAL FK_City_ID_to_CITIES    FK CONSTRAINT     �   ALTER TABLE ONLY public."REGISTRATION_JOURNAL"
    ADD CONSTRAINT "FK_City_ID_to_CITIES" FOREIGN KEY ("FK_City_ID") REFERENCES public."CITY"("City_ID") NOT VALID;
 W   ALTER TABLE ONLY public."REGISTRATION_JOURNAL" DROP CONSTRAINT "FK_City_ID_to_CITIES";
       public          postgres    false    216    3184    211            v           2606    16485 +   REGISTRATION_JOURNAL FK_Person_ID_to_PERSON    FK CONSTRAINT     �   ALTER TABLE ONLY public."REGISTRATION_JOURNAL"
    ADD CONSTRAINT "FK_Person_ID_to_PERSON" FOREIGN KEY ("FK_Person_ID") REFERENCES public."PERSON"("Person_ID") NOT VALID;
 Y   ALTER TABLE ONLY public."REGISTRATION_JOURNAL" DROP CONSTRAINT "FK_Person_ID_to_PERSON";
       public          postgres    false    3182    216    210               3   x�3����I̫�V21�3131:�A�OIG�R���� �qU������  �            x������ � �      	      x������ � �     