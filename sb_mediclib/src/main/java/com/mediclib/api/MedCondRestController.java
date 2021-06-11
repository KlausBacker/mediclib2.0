package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.model.Address;
import com.mediclib.model.MedCondition;
import com.mediclib.projection.Views;
import com.mediclib.service.AdressService;
import com.mediclib.service.MedConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/medical-condition")
@CrossOrigin("*")
public class MedCondRestController {

    @Autowired
    private MedConditionService medConServ;

    @GetMapping
    @JsonView(Views.MedCond.class)
    public List<MedCondition> findAll() {

        return medConServ.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.MedCond.class)
    public MedCondition findById(@PathVariable int id) {

        return this.medConServ.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.MedCond.class)
    public boolean add(@Valid @RequestBody MedCondition medCondition, BindingResult result) {
    if(result.hasErrors()) {
        return false;
    }
        this.medConServ.add(medCondition);
        return true;
    }

    @PutMapping("/{id}")
    @JsonView(Views.MedCond.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody MedCondition medCondition,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        medCondition.setId(id);
        medConServ.update(medCondition);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        this.medConServ.deleteById(id);
        return true;
    }
}
