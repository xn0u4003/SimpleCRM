package app.invoice.repository;

import app.invoice.model.Invoice;
import app.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<User, Long> {

//    Optional<Invoice> findByClientCompanyName(String companyName);
}
