package org.example.services.implementations;

import org.example.DTOs.InvoiceDto;
import org.example.entities.Invoice;
import org.example.exceptions.InvoiceNotFoundException;
import org.example.services.IInvoiceService;
import org.example.storage.IStorageService;
import org.example.repositories.InvoiceRepository;
import org.example.mappers.InvoiceMapper;
import org.example.DTOs.InvoiceCreateDto;
import org.example.DTOs.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private InvoiceRepository repo;
    @Autowired
    private IStorageService storageService;
    @Autowired
    private InvoiceMapper mapper;

    @Override
    public Long saveInvoice(InvoiceCreateDto invoiceModel) {
        try {
            Invoice invoice = mapper.fromCreateDto(invoiceModel);
            invoice.setFileName(storageService.saveFile(invoiceModel.getFile()));
            Invoice savedInvoice = repo.save(invoice);
            return savedInvoice.getId();
        } catch (Exception e) { throw new RuntimeException("Invoice save error"); }
    }

    @Override
    public PaginationResponse<InvoiceDto> getInvoices(int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page, size, Sort.by("name").descending());
        Page<Invoice> invoicesPage = repo.findAll(pageRequest);
        Iterable<InvoiceDto> invoices = mapper.toDto(invoicesPage.getContent());
        return  new PaginationResponse<InvoiceDto>(invoices,invoicesPage.getTotalElements());
    }

    @Override
    public InvoiceDto getInvoiceById(Long id) {
        Optional<Invoice> invoice = repo.findById(id);
        if(invoice.isPresent()) { return mapper.toDto(invoice.get()); }
        else { throw new InvoiceNotFoundException("Invalid invoice id"); }
    }

    @Override
    public boolean deleteInvoiceById(Long id) {
        Optional<Invoice> optInvoice =  repo.findById(id);
        boolean isPresent = optInvoice.isPresent();
        if(isPresent) {
            Invoice invoice = optInvoice.get();
            repo.delete(invoice);
            storageService.deleteFile(invoice.getFileName());
        } return isPresent;
    }

    @Override
    public boolean updateInvoice(InvoiceCreateDto invoiceModel) {
        Optional<Invoice> optInvoice = repo.findById(invoiceModel.getId());
        boolean isPresent = optInvoice.isPresent();
        if(isPresent) {
            Invoice invoice = mapper.fromCreateDto(invoiceModel);
            if(!invoiceModel.getFile().isEmpty() ){
                storageService.deleteFile(optInvoice.get().getFileName());
                invoice.setFileName(storageService.saveFile(invoiceModel.getFile()));
            } repo.save(invoice);
        } return isPresent;
    }
}