package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.StationLine;
import com.example.demo.entity.StationQuery;
import com.example.demo.service.IStationLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/stationline")
public class StationLineController {
    @Autowired 
    IStationLineService iStationLineService;
    
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<StationLine> getAll(){
        return iStationLineService.getAll();
    }
    @RequestMapping(value = "/listByLine",method = RequestMethod.GET)
    public List<StationLine> ListByLine(@RequestParam("subway") String subway){
        return iStationLineService.ListByLine(subway);
    }
    @RequestMapping(value = "/listByStation",method = RequestMethod.GET)
    public List<StationLine> ListByStation(@RequestParam("station") String station){
        return iStationLineService.ListByStation(station);
    }
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public StationLine getInfo(@RequestParam("subway") String subway , @RequestParam("station") String station){
        StationQuery stationQuery = new StationQuery(subway,station);
        return iStationLineService.getInfo(stationQuery);
    }
    @RequestMapping(value="/getInfo1", method=RequestMethod.GET)
    public StationLine getInfo1(@RequestBody StationQuery stationQuery){
        return iStationLineService.getInfo(stationQuery);
    }
    
}