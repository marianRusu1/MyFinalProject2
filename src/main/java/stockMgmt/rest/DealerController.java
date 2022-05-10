package stockMgmt.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stockMgmt.entity.Dealer;
import stockMgmt.repository.DealerRepository;
import java.util.List;



@Controller
public class DealerController {

    @Autowired
    DealerRepository dealerRepository;

    @GetMapping(value = "/dealer/all")
    public String getAllDealers(Model model) {
        model.addAttribute("dealers", dealerRepository.findAll());
        return "all-dealers";
    }

    @PostMapping(value = "/dealer/create")
    public void saveDealer(@RequestBody Dealer dealer) {
        dealerRepository.save(dealer);
    }

    @DeleteMapping(value = "/dealer/delete/all")
    public void deleteAllDealer(@PathVariable List<Dealer> dealers) {
        dealerRepository.deleteAll(dealerRepository.findAll());
        }
    }


