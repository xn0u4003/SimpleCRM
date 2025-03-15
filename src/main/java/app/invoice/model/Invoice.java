package app.invoice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "invoices")
    public class Invoice {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long invoiceNumber;

        @Column(nullable = false, unique = true)
        private String clientCompanyName;

        private String clientAddress;

        @Column(unique = true)
        private String vatNumber;

        @Column(nullable = false)
        private LocalDateTime invoiceDate;

        private String paymentTerms;

        @Column(nullable = false)
        private LocalDateTime paymentDueDate;

        @Column(nullable = false)
        private String contractNumber;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private DeliveryTerms deliveryTerms;

        @Column(nullable = false)
        private String deliveryLocation;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private Product product;

        @Column(nullable = false)
        private Currency currency;

        @Column(nullable = false)
        private BigDecimal unitPrice;

        @Column(nullable = false)
        private BigDecimal invoiceValue;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private VatStatus vatStatus;

        @Column
        private String comment;


//    TODO: Link to User
        /*
        @ManyToOne
        private User owner;*/

//    TODO: Link to Clients

//    TODO: Link to Contracts

    }