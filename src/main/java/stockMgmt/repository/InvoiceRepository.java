package stockMgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import stockMgmt.entity.Invoice;
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

    Invoice findByInvoiceNo(Long invoiceNo);

    }
