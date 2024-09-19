package org.example.interfaces;

import org.example.dtos.InvoiceDto;
import org.example.dtos.InvoiceCreateDto;
import org.example.dtos.PaginationResponse;

public interface IInvoiceService {
    public Long saveInvoice(InvoiceCreateDto invoiceModel);
    public PaginationResponse<InvoiceDto> getInvoices(int page, int size);
    public InvoiceDto getInvoiceById(Long id);
    public boolean deleteInvoiceById(Long id);
    public boolean updateInvoice(InvoiceCreateDto invoiceModel);
}