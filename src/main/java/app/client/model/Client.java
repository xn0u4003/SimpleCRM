package app.client.model;

import app.contract.model.Contract;
import app.invoice.model.Invoice;
import app.shipment.model.Shipment;
import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String companyName;

    private String companyAddress;

    @Column(unique = true)
    private String vatNumber;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @ManyToOne
    private User owner;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Invoice> clientInvoices = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Contract> clientContracts = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Shipment> clientShipments = new ArrayList<>();

}
