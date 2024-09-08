package org.example.service.implement;

import org.example.exception.InvoiceNotFoundException;
import org.example.entities.Invoice;
import org.example.models.InvoiceCreateModel;
import org.example.repo.InvoiceRepository;
import org.example.service.InvoiceService;
import org.example.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImplement implements InvoiceService {

    @Autowired
    private InvoiceRepository repo;
    @Autowired
    private StorageService storageService;

    @Override
    public Invoice saveInvoice(InvoiceCreateModel model) {
        try{
            Invoice invoice = new Invoice();
            invoice.setName(model.getName());
            invoice.setAmount(model.getAmount());
            invoice.setLocation(model.getLocation());
            var imageName = storageService.saveImage(model.getImage());
            invoice.setImage(imageName);
            return repo.save(invoice);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repo.findAll();
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