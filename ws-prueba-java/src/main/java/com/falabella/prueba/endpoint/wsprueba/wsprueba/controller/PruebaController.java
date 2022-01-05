package com.falabella.prueba.endpoint.wsprueba.wsprueba.controller;

import com.falabella.prueba.endpoint.wsprueba.wsprueba.model.Fuente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("prueba")
public class PruebaController {

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);

    public static final String digits = "0123456789";

    public static final String symbols = "!@#$%^&*()_+/-+.;'[]{}";



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/codificar")
    public String codificar(@RequestBody Fuente fuente){
        String[] split = fuente.getFuente().split("");
        String[] digs = digits.split("");
        String[] syms = symbols.split("");
        String respuesta = "";
        for (String s: split) {
            Random r1 = new Random();
            Random r2 = new Random();
            for (int i = 0; i < (r1.nextInt(5)); i++) {
                respuesta = respuesta + digs[r2.nextInt(9)] + syms[r2.nextInt(20)];
            }
            respuesta = respuesta + s;
            for (int i = 0; i < (r1.nextInt(5)); i++) {
                respuesta = respuesta + digs[r2.nextInt(9)] + syms[r2.nextInt(20)];
            }
        }
        return respuesta;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/decodificar")
    public String decodificar(@RequestBody Fuente fuente){
        return fuente.getFuente().replaceAll("[^A-Za-z ]", "");
    }
}
