package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CovidQuote(String data, int nous_casos_diaris_confirmats,int defuncions_di_ries, int total_de_casos_confirmats, int total_de_defuncions) {
}
