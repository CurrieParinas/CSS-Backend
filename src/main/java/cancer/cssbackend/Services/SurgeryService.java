package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddSurgeryRequest;
import cancer.cssbackend.Repositories.HospitalRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import cancer.cssbackend.Repositories.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final HospitalService hospitalService;
    private final PatientRepository patientRepository;

    public Surgery addSurgery(AddSurgeryRequest addSurgeryRequest){
        Surgery surgery = addSurgeryRequest.mapToSurgery(patientService, doctorService, hospitalService, userService);
        surgeryRepository.save(surgery);
        return surgery;
    }

    public List<Hospital> fetchSurgeryHospitals(){
        List<Long> facilityIDs = surgeryRepository.fetchSurgeryHospitals();
        List<Hospital> hospitalList = new ArrayList<>();

        for(Long id : facilityIDs){
            Optional<Hospital> x = hospitalRepository.findById(id);
            x.ifPresent(hospitalList::add);
        }

        return hospitalList;
    }

    public List<Surgery> findByPatientID(Long patientID){
        Optional<Patient> patient = patientRepository.findById(patientID);

        if (patient.isPresent()){
            return surgeryRepository.findByPatient(patient.get());
        } else {
            throw new RuntimeException("Surgery records not found with patient ID " + patientID);
        }
    }

    public Surgery fetchLatestByPatient(Long patientID){
        List<Long> treatmentIDs = surgeryRepository.fetchLatestByPatient(patientID);
        treatmentIDs.sort(Comparator.reverseOrder());

        if(treatmentIDs.isEmpty()){
            throw new RuntimeException("Surgery records not found with patient ID " + patientID);
        }

        Optional<Surgery> latest = surgeryRepository.findById(treatmentIDs.get(0));

        if(latest.isPresent()) {
            return latest.get();
        } else {
            throw new RuntimeException("Surgery records not found with patient ID " + patientID);
        }
    }
}
