package app.shipment.model;

import app.client.model.Client;
import app.contract.model.Contract;
import app.contract.model.DeliveryTerms;
import app.invoice.model.Invoice;
import app.contract.model.Product;
import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Contract contract;

    @ManyToOne
    private User owner;

    @ManyToOne
    private Invoice invoice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Product product;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryTerms deliveryTerms;

    @Column(nullable = false)
    private LocalDateTime shipmentDate;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

}
