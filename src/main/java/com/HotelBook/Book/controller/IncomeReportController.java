package com.HotelBook.Book.controller;

import com.HotelBook.Book.entity.IncomeReport;
import com.HotelBook.Book.service.IncomeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncomeReportController {

    @Autowired(required = true)
    private IncomeReportService incomeReportService;

    @GetMapping("/incomes")
    public ResponseEntity<List<IncomeReport>> getIncomes() {
        List<IncomeReport> incomeReports = incomeReportService.getReports();
        return ResponseEntity.ok(incomeReports);
    }

}
