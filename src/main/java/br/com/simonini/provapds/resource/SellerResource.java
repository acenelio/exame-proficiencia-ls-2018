package br.com.simonini.provapds.resource;

import br.com.simonini.provapds.model.Seller;
import br.com.simonini.provapds.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController("/seller")
public class SellerResource {

    private SellerService service;

    @Autowired
    public SellerResource(SellerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> saveSeller(@Valid @RequestBody Seller seller) {
        Seller savedSeller = this.service.saveSeller(seller);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSeller.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Seller> updateSeller(@Valid @RequestBody Seller seller) {
        Seller updatedSeller = this.service.saveSeller(seller);
        return ResponseEntity.ok().body(updatedSeller);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Seller> findOneSeller(@PathVariable Integer id) {
        Seller seller = this.service.findById(id);
        return ResponseEntity.ok().body(seller);
    }

    @GetMapping
    public ResponseEntity<List<Seller>> findAll() {
        List<Seller> sellerList = this.service.findAll();
        return ResponseEntity.ok().body(sellerList);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSeller(Integer id) {
        this.service.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}
