package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.StationLine;
import com.example.demo.entity.StationQuery;

public interface IStationLineService {
    List<StationLine> getAll();
    List<StationLine> ListByLine(String subway);
    List<StationLine> ListByStation(String station);
    StationLine getInfo(StationQuery stationQuery);
}
