package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.StationLine;
import com.example.demo.entity.StationQuery;

@Repository
@Mapper
public interface StationLineMapper {
    List<StationLine> getAll();
    List<StationLine> ListByLine(String subway);
    List<StationLine> ListByStation(String station);
    StationLine getInfo(StationQuery stationQuery);
}
