/*
package com.mediclib.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.mediclib.exception.PatientNotvalidException;
import com.mediclib.model.PatMedCondID;
import com.mediclib.model.PatMedCondition;
import com.mediclib.model.Patient;
import com.mediclib.projection.Views;
import com.mediclib.service.PatMedCondService;
import com.mediclib.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;

@RestController
@RequestMapping("api/pat-medcon")
@CrossOrigin("*")
public class PatMedConRestController {

    @Autowired
    private PatMedCondService patMedCondService;

  */
/*  private PatMedCondID id;

    @Override
    public String toString() {
        return "PatMedConRestController [id=" + id + "]";
    }*//*


    @GetMapping
    @JsonView(Views.SickPatient.class)
    public List<PatMedCondition> findAll() {

        return patMedCondService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.SickPatient.class)
    public PatMedCondition findById(@PathVariable PatMedCondID id) {
        return this.patMedCondService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(Views.PatientmedCondtion.class)
    public boolean add(@Valid @RequestBody PatMedCondition patMedCondition, BindingResult result) {
        if (result.hasErrors()) {
            return false;
        }
        return true;
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

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(PatMedCondID.class, new PropertyEditorSupport() {
            Object value;

            @Override
            public Object getValue() {
                return value;
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                value = new Gson().fromJson((String) text, PatMedCondID.class);
            }
        });
    }
//    @DeleteMapping("/{id}")
//    public boolean deleteById(@PathVariable int id) {
//        this.patMedCondService.deleteById(id);
//        return true;
//    }

    }

*/
