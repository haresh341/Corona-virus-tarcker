package com.hareshhub.CoronaVirusTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationStat {
    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;
}
