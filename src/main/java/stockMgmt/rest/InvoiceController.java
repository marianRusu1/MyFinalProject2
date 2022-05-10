package stockMgmt.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stockMgmt.entity.Dealer;
import stockMgmt.entity.Invoice;
//import stockMgmt.repository.DateRepository;
import stockMgmt.exeption.InvoiceNumberException;
import stockMgmt.repository.ContactDetailsRepository;
import stockMgmt.repository.DealerRepository;
import stockMgmt.repository.InvoiceRepository;
import stockMgmt.repository.ItemRepository;

import java.util.Set;

//@NoRepositoryBean
@Controller
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;


    @PostMapping(value = "/invoice")
    public String saveInvoice(@RequestBody Invoice invoice) {
        final Dealer dealer = dealerRepository.findByName(invoice.getDealer().getName());
        if (dealer != null) {
            invoice.setDealer(dealer);
        } else {
            invoice.setDealer(dealerRepository.save(invoice.getDealer()));
        }
        invoiceRepository.save(invoice);
        return "all-invoices";
    }
    //        @DeleteMapping(value = "/invoice/{id}")
//        public void deleteInvoice(@PathVariable Long id) {
//            //TODO Handle delete
//            invoiceRepository.deleteById(id);
//        }

//        @GetMapping(value = "/invoice/number")
//        public Set<Invoice> getInvoiceByNumber(@RequestParam(name = "number") String invoiceNumber) {
//            return invoiceRepository.findAByBookTitleContaining(bookTitle);
//        }

    @GetMapping(value = "/invoice/save")
    public String saveInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "add-invoice";
    }

    @PostMapping(value = "/invoice/save")
    public String saveInvoice(@ModelAttribute("invoice") @RequestBody Invoice invoice, RedirectAttributes redirectAttributes) {
//        invoiceRepository.save(invoice);
//            redirectAttributes.addFlashAttribute("message", "The invoice has been saved successfully.");
//            return "redirect:/invoice/save";
        final Dealer dealer = dealerRepository.findByName(invoice.getDealer().getName());
        if (dealer != null) {
            invoice.setDealer(dealer);
        } else {
            invoice.setDealer(dealerRepository.save(invoice.getDealer()));
        }
        Invoice foundInvoice = invoiceRepository.findByInvoiceNo(invoice.getInvoiceNo());
        try{
            if(foundInvoice != null) {
                throw new InvoiceNumberException("An invoice with this number already exists");
            }
            invoiceRepository.save(invoice);
            redirectAttributes.addFlashAttribute("message", "The invoice has been saved successfully.");
        }
        catch (InvoiceNumberException ine) {
            System.out.println(ine);
            redirectAttributes.addFlashAttribute("messageError", "An invoice with this number already exists");
        }
        return "redirect:/invoice/save";
    }

    @GetMapping(value = "/invoice/all")
    public String getAllInvoices(Model model) {
        model.addAttribute("invoices", invoiceRepository.findAll());
        return "all-invoices";
    }

//    @DeleteMapping(value = "/invoice/{id}")
//    public void deleteInvoice(@PathVariable Long id) {
//        invoiceRepository.deleteById(id);
//    }

    @GetMapping("/invoice/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id, Model model) {
        invoiceRepository.deleteById(id);
        return "redirect:/invoice/all";
    }

}




