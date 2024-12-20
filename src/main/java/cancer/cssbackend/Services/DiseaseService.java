package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Entities.Requests.AddDiseaseRequest;
import cancer.cssbackend.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private final PatientService patientService;

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

        if (addDiseaseRequest.getDiseaseOtherSites() != null) {
            for (Long bodySiteId : addDiseaseRequest.getDiseaseOtherSites()) {
                DiseaseOtherSite diseaseOtherSite = new DiseaseOtherSite();
                diseaseOtherSite.setDisease(disease);

                Optional<BodySite> optionalOtherBodySite = bodySiteRepository.findById(bodySiteId);
                if (optionalOtherBodySite.isPresent()) {
                    BodySite otherBodySite = optionalOtherBodySite.get();
                    diseaseOtherSite.setBodySite(otherBodySite);
                    diseaseOtherSiteRepository.save(diseaseOtherSite);
                }
            }
        }
        return disease;
    }

    public Disease updateDisease(AddDiseaseRequest addDiseaseRequest, Long diseaseId) {
        Optional<Disease> optionalDisease = diseaseRepository.findById(diseaseId);
        if (optionalDisease.isPresent()) {
            Disease disease = optionalDisease.get();
            disease = addDiseaseRequest.mapToDisease(pathologyDimService, disease, disease.getDiseaseHistology(), disease.getDiseaseMetastaticSite(), disease.getDiseaseStatus());
            Histology histology = disease.getDiseaseHistology();
            MetastaticSite metastaticSite = disease.getDiseaseMetastaticSite();
            DiseaseStatus diseaseStatus = disease.getDiseaseStatus();

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

            List<DiseaseOtherSite> diseaseOtherSites = diseaseOtherSiteRepository.fetchOtherSitesByDiseaseID(diseaseId);
            diseaseOtherSiteRepository.deleteAll(diseaseOtherSites);

            if (addDiseaseRequest.getDiseaseOtherSites() != null) {
                for (Long bodySiteId : addDiseaseRequest.getDiseaseOtherSites()) {
                    DiseaseOtherSite diseaseOtherSite = new DiseaseOtherSite();
                    diseaseOtherSite.setDisease(disease);

                    Optional<BodySite> optionalOtherBodySite = bodySiteRepository.findById(bodySiteId);
                    if (optionalOtherBodySite.isPresent()) {
                        BodySite otherBodySite = optionalOtherBodySite.get();
                        diseaseOtherSite.setBodySite(otherBodySite);
                        diseaseOtherSiteRepository.save(diseaseOtherSite);
                    }
                }
            }
            return disease;
        }
        return null;
    }

    public Disease findByPatientID(Long patientID) {
//        Patient patient = patientService.findPatient(patientID);
//        if (patient == null) {
//            throw new RuntimeException("Patient not found with ID " + patientID);
//        }
        return diseaseRepository.fetchByPatientID(patientID);
    }
}
