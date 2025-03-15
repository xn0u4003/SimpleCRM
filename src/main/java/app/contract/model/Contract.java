package app.contract.model;

import app.client.model.Client;
import app.invoice.model.DeliveryTerms;
import app.invoice.model.Invoice;
import app.invoice.model.Product;
import app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Currency;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String contractNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Product product;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryTerms deliveryTerms;

    //    TODO: Check if this works

    @Column(nullable = false)
    private String qoutationPeriod;

    @Column(nullable = false)
    private String deliveryPeriod;


    //    TODO: Check and create relations!
/*

    @ManyToOne
    private Client client;

    @ManyToOne
    private User owner;

    @ManyToOne
    private Invoice invoice;
*/




}
