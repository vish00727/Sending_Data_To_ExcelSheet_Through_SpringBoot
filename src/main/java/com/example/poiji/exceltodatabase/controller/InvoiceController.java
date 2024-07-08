package com.example.poiji.exceltodatabase.controller;

import com.example.poiji.exceltodatabase.entity.Invoice;
import com.example.poiji.exceltodatabase.repo.InvoiceRepo;
import com.example.poiji.exceltodatabase.service.InvoiceDataService;
import com.example.poiji.exceltodatabase.service.InvoiceFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
@CrossOrigin("*")
public class InvoiceController {

    @Autowired
    private InvoiceDataService invoiceDataService;

    @Autowired
    private InvoiceFileUpload invoiceFileUpload;

    @Autowired
    private InvoiceRepo invoiceRepo; // Assuming this is an interface extending JpaRepository

    @GetMapping("/")
    public String index() {
        return "uploadPage";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        invoiceFileUpload.uploadfile(file);

        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '" + file.getOriginalFilename() + "' !");
        return "redirect:/";
    }

    @GetMapping("/saveData")
    public String saveExcelData(Model model) {
        List<Invoice> excelDataAsList = invoiceDataService.getExcelDataAsList();
        List<Invoice> savedInvoices = invoiceRepo.saveAll(excelDataAsList); // Assuming saveAll returns the saved entities
        model.addAttribute("noOfRecords", savedInvoices.size());
        return "success";
    }
}