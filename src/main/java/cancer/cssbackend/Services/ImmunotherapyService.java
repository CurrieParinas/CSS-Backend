package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddImmunotherapyRequest;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.HospitalRepository;
import cancer.cssbackend.Repositories.ImmunotherapyRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImmunotherapyService {
    private final ImmunotherapyRepository immunotherapyRepository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final HospitalService hospitalService;
    private final PatientRepository patientRepository;

    public Immunotherapy addImmunotherapy(AddImmunotherapyRequest addImmunotherapyRequest){
        Immunotherapy immunotherapy = addImmunotherapyRequest.mapToImmunotherapy(patientService, doctorService, userService, hospitalService);
        immunotherapyRepository.save(immunotherapy);
        return immunotherapy;
    }

    public List<Doctor> fetchAllDoctors(){
        List<Long> doctorIDs = immunotherapyRepository.fetchAllDoctors();
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }

    public List<Doctor> fetchDoctorsByFacility(Long facilityID){
        List<Long> doctorIDs = immunotherapyRepository.fetchImmunotherapyDoctorsByFacility(facilityID);
        List<Doctor> doctorList = new ArrayList<>();

        for(Long id : doctorIDs){
            Optional<Doctor> x = doctorRepository.findById(id);
            x.ifPresent(doctorList::add);
        }

        return doctorList;
    }

    public List<Hospital> fetchImmunotherapyFacilities(){
        List<Long> facilityIDs = immunotherapyRepository.fetchImmunotherapyFacilities();
        List<Hospital> hospitalList = new ArrayList<>();

        for(Long id : facilityIDs){
            Optional<Hospital> x = hospitalRepository.findById(id);
            x.ifPresent(hospitalList::add);
        }

        return hospitalList;
    }

    public List<Immunotherapy> findByPatientID(Long patientID){
        Optional<Patient> patient = patientRepository.findById(patientID);

        if (patient.isPresent()){
            return immunotherapyRepository.findByPatient(patient.get());
        } else {
            throw new RuntimeException("Immunotherapy records not found with patient ID " + patientID);
        }
    }

    public Immunotherapy fetchLatestByPatient(Long patientID){
        List<Long> treatmentIDs = immunotherapyRepository.fetchLatestByPatient(patientID);
        treatmentIDs.sort(Comparator.reverseOrder());

        if(treatmentIDs.isEmpty()){
            throw new RuntimeException("Immunotherapy records not found with patient ID " + patientID);
        }

        Optional<Immunotherapy> latest = immunotherapyRepository.findById(treatmentIDs.get(0));

        if(latest.isPresent()) {
            return latest.get();
        } else {
            throw new RuntimeException("Immunotherapy records not found with patient ID " + patientID);
        }
    }

    public Immunotherapy updateIsCompleted(Long immunotherapyID ,char completed){
        Optional<Immunotherapy> immunotherapy = immunotherapyRepository.findById(immunotherapyID);

        if(immunotherapy.isPresent()){
            immunotherapy.get().setImmunorxIscompleted(completed);
            immunotherapy.get().setImmunorxUpdatedon(Timestamp.valueOf(LocalDateTime.now()));
            return immunotherapy.get();
        } else {
            throw new RuntimeException("Immunotherapy records not found with ID " + immunotherapyID);
        }
    }
}
