package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.exception.PatientNotvalidException;
import com.mediclib.model.Patient;
import com.mediclib.projection.Views;
import com.mediclib.service.PatientService;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/patient")
@CrossOrigin("*")
public class PatientRestController {

    @Autowired
    private PatientService patServ;


    @GetMapping
    @JsonView(Views.Patient.class)
    public List<Patient> findAll() {
        return patServ.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.PatientmedCondtion.class)
    public Patient findById(@PathVariable int id) {
        return this.patServ.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.PatientmedCondtion.class)
    public Patient add(@Valid @RequestBody Patient patient, BindingResult result) {
    if(result.hasErrors()) {
        throw new PatientNotvalidException();
    }
    return this.patServ.addPatient(patient);
    }


    @PutMapping("/{id}")
    @JsonView(Views.PatientmedCondtion.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody Patient patient,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        patient.setId(id);
//        patMedCondService.add(patMedCondition);
        patServ.updatePatient(patient);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        this.patServ.deleteById(id);
        return true;
    }
}
