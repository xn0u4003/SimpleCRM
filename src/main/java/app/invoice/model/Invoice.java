package app.invoice.model;

import app.client.model.Client;
import app.contract.model.Contract;
import app.contract.model.Product;
import app.shipment.model.Shipment;
import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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

    @ManyToOne
    private Client client;

    @ManyToOne
    private Contract contract;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    private LocalDateTime invoiceDate;

    private String paymentTerms;

    @Column(nullable = false)
    private LocalDateTime paymentDueDate;

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

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice")
    private List<Shipment> invoiceShipments = new ArrayList<>();


}