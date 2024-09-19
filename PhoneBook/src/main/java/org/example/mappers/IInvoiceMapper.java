package org.example.mappers;

import org.example.dtos.InvoiceDto;
import org.example.entities.Invoice;
import org.example.dtos.InvoiceCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IInvoiceMapper {
    @Mapping(target = "fileName", ignore = true)
    Invoice fromCreateDto(InvoiceCreateDto model);
    Invoice fromDto(InvoiceDto invoiceDto);
    InvoiceDto toDto(Invoice invoice);
    Iterable<InvoiceDto> toDto(Iterable<Invoice> invoice);
}