package org.example.services;

import org.example.entities.Invoice;
import org.example.DTOs.InvoiceCreateDto;
import org.example.DTOs.InvoiceItemDto;

import java.util.List;

public interface IInvoiceService {
    public Invoice saveInvoice(InvoiceCreateDto model);
    public List<InvoiceItemDto> getAllInvoices();
    public Invoice getInvoiceById(Long id);
    public void deleteInvoiceById(Long id);
    public void updateInvoice(Invoice invoice);
}