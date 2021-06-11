package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.exception.PatientNotvalidException;
import com.mediclib.model.PatMedCondition;
import com.mediclib.model.Patient;
import com.mediclib.projection.Views;
import com.mediclib.service.PatMedCondService;
import com.mediclib.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/pat-medcon")
@CrossOrigin("*")
public class PatMedConRestController {

    @Autowired
    private PatMedCondService patMedCondService;

    @GetMapping
    @JsonView(Views.PatientmedCondtion.class)
    public List<PatMedCondition> findAll() {

        return patMedCondService.findAll();
    }

//    @GetMapping("/{id}")
//    @JsonView(Views.PatientmedCondtion.class)
//    public Patient findById(@PathVariable int id) {
//
//        return this.patMedCondService.findById(id);
//    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.PatientmedCondtion.class)
    public PatMedCondition add(@Valid @RequestBody PatMedCondition patMedCondition, BindingResult result) {
    if(result.hasErrors()) {
        throw new PatientNotvalidException();
    }
    return this.patMedCondService.add(patMedCondition);
    }

    @PutMapping("/{id}")
    @JsonView(Views.PatientmedCondtion.class)
    public boolean update(@PathVariable int id, @Valid @RequestBody PatMedCondition patMedCondition,
                          BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        patMedCondService.update(patMedCondition);
        return true;
    }

//    @DeleteMapping("/{id}")
//    public boolean deleteById(@PathVariable int id) {
//        this.patMedCondService.deleteById(id);
//        return true;
//    }
}
