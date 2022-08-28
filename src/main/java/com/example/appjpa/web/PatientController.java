package com.example.appjpa.web;

import com.example.appjpa.entities.Patient;
import com.example.appjpa.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    PatientRepository patientRepository;
    @GetMapping("/")
    public String Patients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("listPatients",patients);
        return "patients";
    }

    @GetMapping("/search")
    public String searchPatients(Model model, String keyword) {
        List<Patient> patients = patientRepository.findByNomContains(keyword);
        model.addAttribute("listPatients",patients);
        model.addAttribute("keyword",keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "redirect:/";
    }

  @GetMapping("/editPatient")
    public String deletePatient(Long id, Model model) {
      Patient patient=  patientRepository.findById(id).get();
      if(patient==null) throw new RuntimeException("Patient not found");
        model.addAttribute("patient",patient);
        return "editPatient";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        model.addAttribute("patient",new Patient());
        return "editPatient";
    }

    @PostMapping(path = "/save")
    public String save(@Valid Patient patient, BindingResult bindingResult) {
      if(bindingResult.hasErrors()) return "editPatient";
        patientRepository.save(patient);
        return "redirect:/";
    }


}
