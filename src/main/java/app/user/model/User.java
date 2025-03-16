package app.user.model;

import app.client.model.Client;
import app.contract.model.Contract;
import app.invoice.model.Invoice;
import app.shipment.model.Shipment;
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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String profilePicture;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Client> clients = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Invoice> invoices = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Contract> contracts = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private List<Shipment> shipments = new ArrayList<>();

}
