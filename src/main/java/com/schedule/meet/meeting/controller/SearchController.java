package com.schedule.meet.meeting.controller;

import com.schedule.meet.meeting.domain.SearchRequest;
import com.schedule.meet.meeting.domain.SearchResponse;
import com.schedule.meet.meeting.entity.Enrollment;
import com.schedule.meet.meeting.service.EnrolmentService;
import com.schedule.meet.meeting.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchResponse>> getRoomsForUser(@RequestBody SearchRequest  searchRequest) {
        List<SearchResponse> searchResponseList = searchService.search(searchRequest);
        return ResponseEntity.ok(searchResponseList);
    }


}
