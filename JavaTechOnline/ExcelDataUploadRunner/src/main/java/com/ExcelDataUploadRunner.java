package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.repo.InvoiceRepository;
import com.service.ExcelPoijiService;

@Component
public class ExcelDataUploadRunner implements CommandLineRunner {

    @Autowired
    InvoiceRepository repo;

    @Autowired
    ExcelPoijiService excelPoijiService;

    @Override
    public void run(String... args) throws Exception {
        repo.saveAll(excelPoijiService.getListFromExcelData());
    }

}
