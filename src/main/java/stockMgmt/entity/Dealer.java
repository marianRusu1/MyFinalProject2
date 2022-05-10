package stockMgmt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Dealer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column (nullable = false, length = 20)
    private String bankAccount;

    @Column (nullable = true, length = 30)
    private String fiscalNumber;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "dealer")
    private Set<Invoice> invoices;

}
