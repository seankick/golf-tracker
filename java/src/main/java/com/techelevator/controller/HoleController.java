package com.techelevator.controller;

import com.techelevator.dao.HoleDao;

import com.techelevator.model.Hole;
import com.techelevator.model.Match;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "")
public class HoleController {

    private HoleDao holeDao;

    public HoleController(HoleDao holeDao) {this.holeDao = holeDao;}

    //CREATE METHOD FOR ONE HOLE
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/holes", method = RequestMethod.POST)
    public Hole createHole(@PathVariable Integer courseId, @Valid @RequestBody Hole hole) {
        return holeDao.createHole(courseId, hole);
    }

    //GET METHOD FOR GET ALL HOLES
    @RequestMapping(value = "/holes", method = RequestMethod.GET)
    public List<Hole> getAllHoles() {
        return holeDao.getAllHoles();
    }

    //GET METHOD FOR GET ONE HOLE OF A GIVEN "{holeId}"
    @RequestMapping(value = "/holes/{holeId}", method = RequestMethod.GET)
    public Hole getHole(@PathVariable Integer holeId) {
        return holeDao.getHole(holeId);
    }

    //GET METHOD FOR ALL HOLES OF A GIVEN "{courseId}"
    @RequestMapping(value = "/courses/{courseId}/holes", method = RequestMethod.GET)
    public List<Hole> getHolesByCourseId(@PathVariable Integer courseId) {
        return holeDao.getHolesByCourseId(courseId);
    }


    //GET METHOD FOR ONE HOLE OF A GIVEN "{courseId}" AND "{holeNumber}"
    @RequestMapping(value = "/courses/{courseId}/holes/{holeNumber}", method = RequestMethod.GET)
    public Hole getHoleByCourseId(@PathVariable Integer courseId, @PathVariable Integer holeNumber) {
        return holeDao.getHoleByCourseId(courseId, holeNumber);
    }


    //DELETE METHOD TO DELETE ONE HOLE BY HOLE ID
    @RequestMapping(value ="/holes/{holeId}", method = RequestMethod.DELETE)
    public void deleteHole(@PathVariable Integer holeId) {
        holeDao.deleteHole(holeId);
    }


    //UPDATE METHOD TO UPDATE ONE HOLE BY HOLE ID
    @RequestMapping(value = "/holes/{holeId}", method = RequestMethod.PUT)
    void updateHole(@Valid @RequestBody Hole hole, @PathVariable Integer holeId) {
        holeDao.updateHole(hole, holeId);
    };



}
