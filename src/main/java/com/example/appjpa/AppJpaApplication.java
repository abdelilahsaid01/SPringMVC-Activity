package com.example.appjpa;

import com.example.appjpa.entities.Patient;
import com.example.appjpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppJpaApplication {
    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {

        SpringApplication.run(AppJpaApplication.class, args);
    }


//use public class AppJpaApplication implements CommandLineRunner
/*    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 10; i++) {
            patientRepository.save(new Patient(i, "hassannn", new Date(), false, (int)(Math.random()*1000)));
        }
        System.out.println("-----------Query all patients-----------");
       // List<Patient> patients = patientRepository.findAll();
     List <Patient> patients=  patientRepository.findByMalade(false);

        System.out.println("-----------patient by Malade-----------");

        //   Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,2));
        patients.forEach(patient -> {
            System.out.println(patient);
        });

        System.out.println("-----------patient by id-----------");
        Patient patient = patientRepository.findById(1L).get();
        System.out.println(patient);

        System.out.println("-----------update patient-----------");
        patient.setScore(333);
        patientRepository.save(patient);

        System.out.println("-----------delete patient-----------");
        patientRepository.deleteById(2L);
    }*/
@Bean  //method executed on inisialize project
    CommandLineRunner commandLineRunner () {
        return  args -> {
          /* for (int i = 0; i < 10; i++) {
                patientRepository.save(new Patient(i, "hassannn", new Date(), false, (int)(Math.random()*1000)));
            }*/
            System.out.println("-----------all Patients----------");
            List<Patient> patients = patientRepository.findAll();
            patients.forEach(patient -> {
                System.out.println(patient);
            });
        };
    }
}
