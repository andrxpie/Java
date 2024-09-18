package org.example.mappers;

import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.example.DTOs.InvoiceCreateDto;
import org.example.DTOs.InvoiceDto;
import org.example.entities.Invoice;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T18:58:21+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice fromCreateDto(InvoiceCreateDto model) {
        if ( model == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setId( model.getId() );
        invoice.setName( model.getName() );
        invoice.setLocation( model.getLocation() );
        invoice.setAmount( model.getAmount() );

        return invoice;
    }

    @Override
    public Invoice fromDto(InvoiceDto invoiceDto) {
        if ( invoiceDto == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setId( invoiceDto.getId() );
        invoice.setName( invoiceDto.getName() );
        invoice.setLocation( invoiceDto.getLocation() );
        invoice.setAmount( invoiceDto.getAmount() );

        return invoice;
    }

    @Override
    public InvoiceDto toDto(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceDto invoiceDto = new InvoiceDto();

        invoiceDto.setId( invoice.getId() );
        invoiceDto.setName( invoice.getName() );
        invoiceDto.setLocation( invoice.getLocation() );
        invoiceDto.setAmount( invoice.getAmount() );

        return invoiceDto;
    }

    @Override
    public Iterable<InvoiceDto> toDto(Iterable<Invoice> invoice) {
        if ( invoice == null ) {
            return null;
        }

        ArrayList<InvoiceDto> iterable = new ArrayList<InvoiceDto>();
        for ( Invoice invoice1 : invoice ) {
            iterable.add( toDto( invoice1 ) );
        }

        return iterable;
    }
}
