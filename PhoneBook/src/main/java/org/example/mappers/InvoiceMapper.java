package org.example.mappers;

import org.example.DTOs.InvoiceItemDto;
import org.example.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(source = "image", target = "image", qualifiedByName = "pathToFile")
    InvoiceItemDto MapInvoice(Invoice invoice);
    List<InvoiceItemDto> MapInvoices(List<Invoice> invoices);

    @Named("pathToFile")
    public static String pathToFile(String image) {
        return "/uploading/"+image;
    }
}