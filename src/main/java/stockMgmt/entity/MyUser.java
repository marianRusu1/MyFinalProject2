package stockMgmt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MyUser implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(nullable = false, length = 30)
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;

    @Column(nullable = false, length = 30, unique = true)
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Invoice> invoices;

    @Transient
    private String passwordConfirm;

      public MyUser(MyUser user) {
         this.enabled = user.isEnabled();
         this.contactDetails = user.getContactDetails();
         this.roles = user.getRoles();
         this.username = user.getUsername();
         this.fullName = user.getFullName();
         this.id = user.getId();
         this.accountNonExpired = user.isAccountNonExpired();
         this.accountNonLocked = user.isAccountNonLocked();
         this.credentialsNonExpired = user.isCredentialsNonExpired();
         this.invoices = user.getInvoices();
         this.email = user.getEmail();
//         this.password = user.getPassword();
//         this.passwordConfirm = user.getPasswordConfirm();

     }
    /*public MyUser(MyUser user) {
        this.enabled = user.isEnabled();
        this.contactDetails = user.getContactDetails();
        this.roles = user.getRoles();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.id = user.getId();
        this.accountNonExpired = user.isAccountNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.email = user.getEmail();

    }

    public MyUser(String username, String password, boolean accountNonExpired, boolean accountNonLocked,
                  boolean credentialsNonExpired, boolean enabled, String fullName, ContactDetails contactDetails,
                  String email, Set<Role> roles, String passwordConfirm) {
        this.username = username;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.fullName = fullName;
        this.contactDetails = contactDetails;
        this.email = email;
        this.roles = roles;
        this.passwordConfirm = passwordConfirm;
    }*/


    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }

    /*public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<Invoice> getInvoices() {
        return getInvoices();
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {

        this.passwordConfirm = passwordConfirm;*/
    }
