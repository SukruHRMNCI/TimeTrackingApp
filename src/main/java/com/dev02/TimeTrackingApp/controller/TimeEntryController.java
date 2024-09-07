package com.dev02.TimeTrackingApp.controller;

import com.dev02.TimeTrackingApp.payload.request.TimeEntryRequest;
import com.dev02.TimeTrackingApp.payload.response.ResponseMessage;
import com.dev02.TimeTrackingApp.payload.response.TimeResponse;
import com.dev02.TimeTrackingApp.service.business.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    //todo: günlük, aylık ve haftalık filtrelerle spesifik bi kursa ait saat bilgilerini getiren method lazım.
    //todo:update, delete

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseMessage<TimeResponse> addNewTimeEntry(@RequestBody @Valid TimeEntryRequest timeEntryRequest
    , HttpServletRequest httpRequest){

        return timeEntryService.addNewTimeEntry(timeEntryRequest, httpRequest);

    }

    @GetMapping("/getAllDailyTimeEntriesByUser")
    @PreAuthorize("hasAnyAuthority('ADMIN,'USER')")
    public ResponseMessage<List<TimeResponse>> getAllDailyTimeEntriesByUser(HttpServletRequest request){

        return timeEntryService.getAllDailyTimeEntriesByUser(request);
    }

    @GetMapping("/getAllWeeklyTimeEntriesByUser")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseMessage<List<TimeResponse>> getAllWeeklyTimeEntriesByUser(HttpServletRequest request){
        return timeEntryService.getAllWeeklyTimeEntriesByUser(request);
    }

    @GetMapping("/getAllMonthlyTimeEntriesByUser")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseMessage<List<TimeResponse>> getAllMonthlyTimeEntriesByUser(HttpServletRequest request){
        return timeEntryService.getAllMonthlyTimeEntriesByUser(request);
    }

    @GetMapping("/getAllPreviousDayTimeEntriesByUser")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseMessage<List<TimeResponse>> getAllPreviousDayTimeEntriesByUser(HttpServletRequest request) {
        return timeEntryService.getAllPreviousDayTimeEntriesByUser(request);
    }

    @GetMapping("/getAllPreviousWeekTimeEntriesByUser")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseMessage<List<TimeResponse>> getAllPreviousWeekTimeEntriesByUser(HttpServletRequest request) {
        return timeEntryService.getAllPreviousWeekTimeEntriesByUser(request);
    }

    @GetMapping("/getAllPreviousMonthTimeEntriesByUser")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseMessage<List<TimeResponse>> getAllPreviousMonthTimeEntriesByUser(HttpServletRequest request) {
        return timeEntryService.getAllPreviousMonthTimeEntriesByUser(request);
    }



}
