package stockMgmt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Item {

    @Id
    @Column(name="id_Item")
    @GeneratedValue
    private Long id;

    @Column (nullable = true, length = 30)
    private String name;

    @Column (nullable = true)
    private Integer quantity;

    @ToString.Exclude
    @ManyToMany(mappedBy = "items")
    private Set<Invoice> invoices;



}
