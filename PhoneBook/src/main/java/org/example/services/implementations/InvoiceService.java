package org.example.services.implementations;

import org.example.DTOs.InvoiceItemDto;
import org.example.exceptions.InvoiceNotFoundException;
import org.example.entities.Invoice;
import org.example.mappers.InvoiceMapper;
import org.example.DTOs.InvoiceCreateDto;
import org.example.repositories.InvoiceRepository;
import org.example.storage.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService implements org.example.services.IInvoiceService {

    @Autowired
    private InvoiceRepository repo;
    @Autowired
    private IStorageService IStorageService;
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public Invoice saveInvoice(InvoiceCreateDto model) {
        try{
            Invoice invoice = new Invoice();
            invoice.setName(model.getName());
            invoice.setAmount(model.getAmount());
            invoice.setLocation(model.getLocation());
            var imageName = IStorageService.saveFile(model.getImage());
            invoice.setImage(imageName);
            return repo.save(invoice);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<InvoiceItemDto> getAllInvoices() {
        return invoiceMapper.MapInvoices(repo.findAll());
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new InvoiceNotFoundException("Invoice with Id : "+id+" Not Found");
        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
        repo.delete(getInvoiceById(id));
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        repo.save(invoice);
    }
}