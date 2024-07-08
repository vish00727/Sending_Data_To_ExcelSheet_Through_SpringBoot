package com.example.poiji.exceltodatabase.service;

import com.example.poiji.exceltodatabase.entity.Invoice;

import java.util.List;

public interface InvoiceDataService {

    List<Invoice> getExcelDataAsList();

    int saveExcelData(List<Invoice> invoices);
}
