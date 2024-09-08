package com.service;

import java.util.List;
import com.entity.Invoice;

/**
 * ExcelPoijiService
 */
public interface ExcelPoijiService {
    List<Invoice> getListFromExcelData();
}