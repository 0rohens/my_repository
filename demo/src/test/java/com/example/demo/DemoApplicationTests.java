package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import com.example.demo.entity.StationLine;
import com.example.demo.mapper.StationLineMapper;

@SpringBootTest
class DemoApplicationTests {
	
	StationLineMapper stationLineMapper;
	
	@Test
	void contextLoads() {
		System.out.println("stationLine.get(i).toString()");
		List<StationLine> stationLine = stationLineMapper.getAll();
		 System.out.println(stationLine.size());
		// for(int i=0;i<stationLine.size();i++){
		// 	System.out.println(stationLine.get(i).toString());
		// }
	}

}
