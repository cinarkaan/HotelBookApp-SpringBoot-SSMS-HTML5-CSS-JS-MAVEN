package com.HotelBook.Book.service;

import com.HotelBook.Book.entity.IncomeReport;
import com.HotelBook.Book.repository.IncomeReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeReportService {

    @Autowired(required = true)
    private IncomeReportRepository incomeReportRepositorye;


    public List<IncomeReport> getReports () {
        return incomeReportRepositorye.findAll();
    }

}
