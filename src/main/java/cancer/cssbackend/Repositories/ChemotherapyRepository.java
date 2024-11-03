package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Chemotherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemotherapyRepository extends JpaRepository<Chemotherapy, Long> {
    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN CHEMOTHERAPY c ON c.CHEMO_DOCTOR = d.DOCTOR_ID", nativeQuery = true)
    public List<Long> fetchAllDoctors();

    @Query(value = "SELECT DISTINCT d.DOCTOR_ID FROM DOCTOR d JOIN CHEMOTHERAPY c ON c.CHEMO_DOCTOR = d.DOCTOR_ID WHERE c.CHEMO_FACILITY= :facilityID", nativeQuery = true)
    public List<Long> fetchDoctorsByFacility(@Param("facilityID") Long facilityID);

    @Query(value = "SELECT DISTINCT H.HOSPITAL_ID FROM HOSPITAL H JOIN CHEMOTHERAPY C ON H.HOSPITAL_ID = C.CHEMO_FACILITY", nativeQuery = true)
    public List<Long> fetchChemotherapyFacilities();

}
