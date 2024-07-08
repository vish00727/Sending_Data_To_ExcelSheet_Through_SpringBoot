package com.example.poiji.exceltodatabase.repo;

import com.example.poiji.exceltodatabase.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
}
