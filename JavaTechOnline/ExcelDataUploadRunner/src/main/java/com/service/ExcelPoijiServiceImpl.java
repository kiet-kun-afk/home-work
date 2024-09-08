package com.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.entity.Invoice;
import com.poiji.bind.Poiji;

@Service
public class ExcelPoijiServiceImpl implements ExcelPoijiService {

    @Value("${filePath}")
    public String FILE_PATH;

    @Override
    public List<Invoice> getListFromExcelData() {
        File file = new File(FILE_PATH);
        List<Invoice> invoices = Poiji.fromExcel(file, Invoice.class);
        return invoices;
    }

}
