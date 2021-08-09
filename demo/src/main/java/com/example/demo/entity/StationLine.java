package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationLine {
    private int id;
    private int subwayid;
    private String subway;
    private int stationid;
    private String station;
    private int interval;
}
