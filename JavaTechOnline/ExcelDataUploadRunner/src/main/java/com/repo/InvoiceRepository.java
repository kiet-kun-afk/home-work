package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
