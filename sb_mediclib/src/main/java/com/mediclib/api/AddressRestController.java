package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.model.Address;
import com.mediclib.projection.Views;
import com.mediclib.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/address")
@CrossOrigin("*")
public class AddressRestController {

    @Autowired
    private AdressService adrServ;

    @GetMapping
    @JsonView(Views.Address.class)
    public List<Address> findAll() {

        return adrServ.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.Address.class)
    public Address findById(@PathVariable int id) {

        return this.adrServ.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.AddressComplete.class)
    public boolean add(@Valid @RequestBody Address address, BindingResult result) {
    if(result.hasErrors()) {
        return false;
    }
        this.adrServ.add(address);
        return true;
    }

    @PutMapping("/{id}")
    @JsonView(Views.AddressComplete.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody Address address,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        address.setId(id);
        adrServ.update(address);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        this.adrServ.deleteById(id);
        return true;
    }
}
