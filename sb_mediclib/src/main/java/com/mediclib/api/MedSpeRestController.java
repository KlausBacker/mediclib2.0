package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.model.Address;
import com.mediclib.model.MedSpeciality;
import com.mediclib.projection.Views;
import com.mediclib.service.AdressService;
import com.mediclib.service.MedSpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/medical-spec")
@CrossOrigin("*")
public class MedSpeRestController {

    @Autowired
    private MedSpecialityService medSpeServ;

    @GetMapping
    @JsonView(Views.MedSpe.class)
    public List<MedSpeciality> findAll() {

        return medSpeServ.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.MedSpe.class)
    public MedSpeciality findById(@PathVariable int id) {

        return this.medSpeServ.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.MedSpe.class)
    public boolean add(@Valid @RequestBody MedSpeciality medSpeciality, BindingResult result) {
    if(result.hasErrors()) {
        return false;
    }
        this.medSpeServ.add(medSpeciality);
        return true;
    }

    @PutMapping("/{id}")
    @JsonView(Views.MedSpe.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody MedSpeciality medSpeciality,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        medSpeciality.setId(id);
        medSpeServ.update(medSpeciality);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        this.medSpeServ.delete(id);
        return true;
    }
}
