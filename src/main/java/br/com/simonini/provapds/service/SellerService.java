package br.com.simonini.provapds.service;

import br.com.simonini.provapds.model.Seller;
import br.com.simonini.provapds.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private SellerRepository repository;

    @Autowired
    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    public Seller saveSeller(Seller seller) {
        return this.repository.save(seller);
    }

    public void deleteSeller(Integer id) {
        this.repository.delete(id);
    }

    public Seller findById(Integer id) {
        return this.repository.findOne(id);
    }

    public List<Seller> findAll() {
        return this.repository.findAll();
    }
}
