package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.StationLine;
import com.example.demo.entity.StationQuery;
import com.example.demo.service.IStationLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.StationLineMapper;

@Service
public class StationLineService implements IStationLineService{

    @Autowired
    private StationLineMapper stationLineMapper;

    @Override
    public List<StationLine> getAll() {
        return stationLineMapper.getAll();
    }

    @Override
    public List<StationLine> ListByLine(String subway) {
        return stationLineMapper.ListByLine(subway);
    }

    @Override
    public List<StationLine> ListByStation(String station) {
        return stationLineMapper.ListByStation(station);
    }

    @Override
    public StationLine getInfo(StationQuery stationQuery){
        return stationLineMapper.getInfo(stationQuery);
    }
    
}
