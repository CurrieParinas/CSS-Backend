package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddDiseaseRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiseaseService {
    private final DiseaseRepository diseaseRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final HistologyRepository histologyRepository;
    private final MetastaticSiteRepository metastaticSiteRepository;
    private final DiseaseStatusRepository diseaseStatusRepository;
    private final BasisRepository basisRepository;
    private final BodySiteRepository bodySiteRepository;
    private final DiseaseOtherSiteRepository diseaseOtherSiteRepository;
    private final PathologyDimService pathologyDimService;

    public Disease addDisease(AddDiseaseRequest addDiseaseRequest) {
        Disease disease = addDiseaseRequest.mapToDisease(pathologyDimService);
        Histology histology = disease.getDiseaseHistology();
        MetastaticSite metastaticSite = disease.getDiseaseMetastaticSite();
        DiseaseStatus diseaseStatus = disease.getDiseaseStatus();

        Optional<Patient> optionalPatient = patientRepository.findById(addDiseaseRequest.getPatientID());
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            disease.setPatient(patient);
            histology.setPatient(patient);
            metastaticSite.setPatient(patient);
            diseaseStatus.setPatient(patient);
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(addDiseaseRequest.getDiseaseEncoder());
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            disease.setDiseaseEncoder(doctor);
            histology.setHistoEncoder(doctor);
            metastaticSite.setMetsEncoder(doctor);
        }

        Optional<Basis> optionalBasis = basisRepository.findById(addDiseaseRequest.getBasisID());
        if (optionalBasis.isPresent()) {
            Basis basis = optionalBasis.get();
            disease.setBasis(basis);
        }

        Optional<BodySite> optionalBodySite = bodySiteRepository.findById(addDiseaseRequest.getBodySiteID());
        if (optionalBodySite.isPresent()) {
            BodySite bodySite = optionalBodySite.get();
            disease.setBodySite(bodySite);
        }

        disease.setDiseaseHistology(histology);
        disease.setDiseaseMetastaticSite(metastaticSite);
        disease.setDiseaseStatus(diseaseStatus);

        histologyRepository.save(histology);
        metastaticSiteRepository.save(metastaticSite);
        diseaseStatusRepository.save(diseaseStatus);
        diseaseRepository.save(disease);

        // Handle diseaseOtherSites
        if (addDiseaseRequest.getDiseaseOtherSites() != null) {
            for (Long bodySiteId : addDiseaseRequest.getDiseaseOtherSites()) {
                DiseaseOtherSite diseaseOtherSite = new DiseaseOtherSite();
                diseaseOtherSite.setDisease(disease);

                Optional<BodySite> optionalOtherBodySite = bodySiteRepository.findById(bodySiteId);
                if (optionalOtherBodySite.isPresent()) {
                    BodySite otherBodySite = optionalOtherBodySite.get();
                    diseaseOtherSite.setBodySite(otherBodySite);
                    // Save each DiseaseOtherSite as needed
                    // You may need to create a repository for DiseaseOtherSite if it doesn't exist
                    diseaseOtherSiteRepository.save(diseaseOtherSite);
                }
            }
        }
        return disease;
    }
}
