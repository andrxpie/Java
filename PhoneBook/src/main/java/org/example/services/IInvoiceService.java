package org.example.services;

import org.example.DTOs.InvoiceDto;
import org.example.DTOs.InvoiceCreateDto;
import org.example.DTOs.PaginationResponse;

public interface IInvoiceService {
    public Long saveInvoice(InvoiceCreateDto invoiceModel);
    public PaginationResponse<InvoiceDto> getInvoices(int page, int size);
    public InvoiceDto getInvoiceById(Long id);
    public boolean deleteInvoiceById(Long id);
    public boolean updateInvoice(InvoiceCreateDto invoiceModel);
}