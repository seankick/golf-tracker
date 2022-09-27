package com.techelevator.dao;

import com.techelevator.model.Hole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface HoleDao {

     Hole createHole(Integer courseId, Hole hole);
     List<Hole> getAllHoles();
     Hole getHole(Integer holeId);
     List<Hole> getHolesByCourseId(Integer courseId);
     Hole getHoleByCourseId(Integer courseId, Integer holeNumber);
     void updateHole(Hole hole, Integer holeId);
     void deleteHole(Integer holeId);
}
