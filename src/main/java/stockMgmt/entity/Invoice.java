package stockMgmt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString


public class Invoice {


    @Id
    @Column(name="id_Invoice")
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private Long invoiceNo;

        @Column
        @DateTimeFormat(pattern = "DD-YYYY-MM")
        private LocalDate issueDate = LocalDate.now();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private Dealer dealer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "invoice_item",
            joinColumns = { @JoinColumn(name = "id_Item") },
            inverseJoinColumns = { @JoinColumn(name = "id_Invoice") })
    private Set<Item> items;

    @ManyToOne
    private MyUser user;

/*    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = BudgetArticle.class)
    private BudgetArticle budgetArticle;*/

}
