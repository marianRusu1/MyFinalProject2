package stockMgmt.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;

@Entity
@Setter
@Getter
@ToString
public class ContactDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true, length = 10)
    private String phoneNumber;

    @Column(nullable = true, length = 30)
    private String city;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true, length = 20, unique = true)
    private String email; // de cautat cum se implementeaza exceptie pentru acelasi mail de 2 ori


    @Column (nullable = true, length = 30)
    private String site;

   // @ToString.Exclude
    @OneToOne(mappedBy = "contactDetails")
    private Dealer dealer;
}
