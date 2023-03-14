package com.example.consumingrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(CovidController.CHUCK)
public class CovidController {
    public static final String CHUCK = "/covid";

    @Autowired
    GreetingService grettingService;

    @GetMapping
    public String getCovidQuote(Model model) {
        List<CovidQuote> q = new ArrayList<>(Arrays.asList(grettingService.getCovidQuote()));
        List<String> dates = new ArrayList<>();
        List<Integer> newCasosDiaris = new ArrayList<>();
        List<Integer> defuncionsDiaries = new ArrayList<>();
        List<Integer> totalCasos = new ArrayList<>();
        List<Integer> totalDefuncions = new ArrayList<>();

        q.forEach(covid -> {
            dates.add(covid.data());
            newCasosDiaris.add(covid.nous_casos_diaris_confirmats());
            defuncionsDiaries.add(covid.defuncions_di_ries());
            totalCasos.add(covid.total_de_casos_confirmats());
            totalDefuncions.add(covid.total_de_defuncions());
        });

        model.addAttribute("dates", dates);
        model.addAttribute("newCasosDiaris", newCasosDiaris);
        model.addAttribute("defuncionsDiaries", defuncionsDiaries);
        model.addAttribute("totalCasos", totalCasos);
        model.addAttribute("totalDefuncions", totalDefuncions);
        return "covid";
    }
}
