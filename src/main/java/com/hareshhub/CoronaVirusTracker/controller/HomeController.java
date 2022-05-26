package com.hareshhub.CoronaVirusTracker.controller;

import com.hareshhub.CoronaVirusTracker.model.LocationStat;
import com.hareshhub.CoronaVirusTracker.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStat> locationStats = coronaVirusDataService.getLocationStats();
        model.addAttribute("locationStats",locationStats);
        int totalReportedCases = locationStats.stream().mapToInt(LocationStat::getLatestTotalCases).sum();
        int totalNewCases = locationStats.stream().mapToInt(LocationStat::getDiffFromPrevDay).sum();
        model.addAttribute("totalReportedCases",totalReportedCases);
        model.addAttribute("totalNewCases",totalNewCases);
        model.addAttribute("date",CoronaVirusDataService.date);
        return "home";
    }
}
