PGDMP         5            	    y        	   sestask1b    14.0    14.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                        1262    16533 	   sestask1b    DATABASE     e   CREATE DATABASE sestask1b WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';
    DROP DATABASE sestask1b;
                postgres    false            �            1259    16545 	   PARAMETER    TABLE     l   CREATE TABLE public."PARAMETER" (
    "Param_ID" integer NOT NULL,
    tm1_frequency_mhz bigint NOT NULL
);
    DROP TABLE public."PARAMETER";
       public         heap    postgres    false            �            1259    16543    PARAMETER_Param_ID_seq    SEQUENCE     �   CREATE SEQUENCE public."PARAMETER_Param_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public."PARAMETER_Param_ID_seq";
       public          postgres    false    213                       0    0    PARAMETER_Param_ID_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."PARAMETER_Param_ID_seq" OWNED BY public."PARAMETER"."Param_ID";
          public          postgres    false    211            �            1259    16544    PARAMETER_tm1_frequency_mhz_seq    SEQUENCE     �   CREATE SEQUENCE public."PARAMETER_tm1_frequency_mhz_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public."PARAMETER_tm1_frequency_mhz_seq";
       public          postgres    false    213                       0    0    PARAMETER_tm1_frequency_mhz_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public."PARAMETER_tm1_frequency_mhz_seq" OWNED BY public."PARAMETER".tm1_frequency_mhz;
          public          postgres    false    212            �            1259    16535    SATELITE    TABLE     �   CREATE TABLE public."SATELITE" (
    satellite_id character varying(4)[] NOT NULL,
    launch_date date,
    in_use boolean,
    orbit character varying(3)[],
    fk_parameter_id integer NOT NULL
);
    DROP TABLE public."SATELITE";
       public         heap    postgres    false            �            1259    16534    SATELITE_parameter_id_seq    SEQUENCE     �   CREATE SEQUENCE public."SATELITE_parameter_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public."SATELITE_parameter_id_seq";
       public          postgres    false    210                       0    0    SATELITE_parameter_id_seq    SEQUENCE OWNED BY     ^   ALTER SEQUENCE public."SATELITE_parameter_id_seq" OWNED BY public."SATELITE".fk_parameter_id;
          public          postgres    false    209            c           2604    16548    PARAMETER Param_ID    DEFAULT     ~   ALTER TABLE ONLY public."PARAMETER" ALTER COLUMN "Param_ID" SET DEFAULT nextval('public."PARAMETER_Param_ID_seq"'::regclass);
 E   ALTER TABLE public."PARAMETER" ALTER COLUMN "Param_ID" DROP DEFAULT;
       public          postgres    false    211    213    213            d           2604    16549    PARAMETER tm1_frequency_mhz    DEFAULT     �   ALTER TABLE ONLY public."PARAMETER" ALTER COLUMN tm1_frequency_mhz SET DEFAULT nextval('public."PARAMETER_tm1_frequency_mhz_seq"'::regclass);
 L   ALTER TABLE public."PARAMETER" ALTER COLUMN tm1_frequency_mhz DROP DEFAULT;
       public          postgres    false    213    212    213            b           2604    16538    SATELITE fk_parameter_id    DEFAULT     �   ALTER TABLE ONLY public."SATELITE" ALTER COLUMN fk_parameter_id SET DEFAULT nextval('public."SATELITE_parameter_id_seq"'::regclass);
 I   ALTER TABLE public."SATELITE" ALTER COLUMN fk_parameter_id DROP DEFAULT;
       public          postgres    false    210    209    210            �          0    16545 	   PARAMETER 
   TABLE DATA           D   COPY public."PARAMETER" ("Param_ID", tm1_frequency_mhz) FROM stdin;
    public          postgres    false    213          �          0    16535    SATELITE 
   TABLE DATA           _   COPY public."SATELITE" (satellite_id, launch_date, in_use, orbit, fk_parameter_id) FROM stdin;
    public          postgres    false    210   C                  0    0    PARAMETER_Param_ID_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."PARAMETER_Param_ID_seq"', 1, false);
          public          postgres    false    211                       0    0    PARAMETER_tm1_frequency_mhz_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public."PARAMETER_tm1_frequency_mhz_seq"', 1, false);
          public          postgres    false    212                       0    0    SATELITE_parameter_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."SATELITE_parameter_id_seq"', 1, false);
          public          postgres    false    209            i           2606    16551    PARAMETER PARAMETER_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."PARAMETER"
    ADD CONSTRAINT "PARAMETER_pkey" PRIMARY KEY ("Param_ID");
 F   ALTER TABLE ONLY public."PARAMETER" DROP CONSTRAINT "PARAMETER_pkey";
       public            postgres    false    213            f           2606    16542    SATELITE SATELITE_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."SATELITE"
    ADD CONSTRAINT "SATELITE_pkey" PRIMARY KEY (satellite_id);
 D   ALTER TABLE ONLY public."SATELITE" DROP CONSTRAINT "SATELITE_pkey";
       public            postgres    false    210            g           1259    16557    fki_FK_Param_ID_to_PARAMETER    INDEX     `   CREATE INDEX "fki_FK_Param_ID_to_PARAMETER" ON public."SATELITE" USING btree (fk_parameter_id);
 2   DROP INDEX public."fki_FK_Param_ID_to_PARAMETER";
       public            postgres    false    210            j           2606    16552 !   SATELITE FK_Param_ID_to_PARAMETER    FK CONSTRAINT     �   ALTER TABLE ONLY public."SATELITE"
    ADD CONSTRAINT "FK_Param_ID_to_PARAMETER" FOREIGN KEY (fk_parameter_id) REFERENCES public."PARAMETER"("Param_ID") NOT VALID;
 O   ALTER TABLE ONLY public."SATELITE" DROP CONSTRAINT "FK_Param_ID_to_PARAMETER";
       public          postgres    false    210    3177    213            �   "   x�3�4�40��2ц\�P�	�o����� pr�      �   d   x�M�-�0`��ҟ<lj �hN�kvw�%�5u_�{�~��'҉��M��`7X��h��،��4�ܫ��0��N��3��ڞ��5#��'V     