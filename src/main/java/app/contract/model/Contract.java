package app.contract.model;

import app.client.model.Client;
import app.invoice.model.Invoice;
import app.shipment.model.Shipment;
import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Product product;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryTerms deliveryTerms;

    @Column(nullable = false)
    private String qoutationalPeriod;

    @Column(nullable = false)
    private String deliveryPeriod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contract")
    private List<Invoice> contractInvoices = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contract")
    private List<Shipment> contractShipments = new ArrayList<>();

}
