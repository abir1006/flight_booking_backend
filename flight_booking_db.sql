PGDMP  9    ;                |           flight_booking    16.3 (Debian 16.3-1.pgdg120+1)    16.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16388    flight_booking    DATABASE     y   CREATE DATABASE flight_booking WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE flight_booking;
                postgres    false            �            1259    16574 	   _user_seq    SEQUENCE     s   CREATE SEQUENCE public._user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public._user_seq;
       public          postgres    false            �            1259    16551    payment_gateway    TABLE     �   CREATE TABLE public.payment_gateway (
    id bigint NOT NULL,
    details character varying(255),
    name character varying(255)
);
 #   DROP TABLE public.payment_gateway;
       public         heap    postgres    false            �            1259    16550    payment_gateway_id_seq    SEQUENCE     �   ALTER TABLE public.payment_gateway ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.payment_gateway_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216                      0    16551    payment_gateway 
   TABLE DATA           <   COPY public.payment_gateway (id, details, name) FROM stdin;
    public          postgres    false    216   �
                  0    0 	   _user_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public._user_seq', 151, true);
          public          postgres    false    217                       0    0    payment_gateway_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.payment_gateway_id_seq', 1, false);
          public          postgres    false    215            �           2606    16557 $   payment_gateway payment_gateway_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.payment_gateway
    ADD CONSTRAINT payment_gateway_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.payment_gateway DROP CONSTRAINT payment_gateway_pkey;
       public            postgres    false    216                  x������ � �     