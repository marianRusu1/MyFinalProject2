//package stockMgmt.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.Set;
//
//@Entity
//@Setter
//@Getter
//@ToString
//public class DueDate {
//
////        @Id
////        @GeneratedValue
////        private Long id;
////
//////        @Column
//////        @DateTimeFormat(pattern = "DD-MM-YYYY")
//////        public static LocalDate issueDate = LocalDate.now();
//////
//////        @Column
//////        @DateTimeFormat(pattern="dd/MM/yyyy")
//////        private LocalDate dueDate =  issueDate.plusDays(30);
////
////        @Column
////        public static String issueDate = LocalDate.now().toString();
////
//////        @Column
//////        private String dueDate = LocalDate.now().plusDays(30).toString();
////
////
////        @OneToMany(mappedBy = "issueDate")
////        private Set<Invoice> invoices;
//
//    }
//
//
