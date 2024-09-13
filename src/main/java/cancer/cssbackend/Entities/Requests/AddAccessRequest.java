package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Access;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAccessRequest {
    @JsonProperty("ACCESS_CANENROLLPATIENT")
    private char accessCanEnrollPatient;

    @JsonProperty("ACCESS_CANEDITPATIENTINFO")
    private char accessCanEditPatientInfo;

    @JsonProperty("ACCESS_CANVIEWPATIENTINFO")
    private char accessCanViewPatientInfo;

    @JsonProperty("ACCESS_CANDELETEUSER")
    private char accessCanDeleteUser;

    @JsonProperty("ACCESS_CANDELETEPATIENTINFO")
    private char accessCanDeletePatientInfo;

    public Access mapToAccess(){
        Access access = new Access();
        access.setAccessCanEnrollPatient(this.accessCanEnrollPatient);
        access.setAccessCanEditPatientInfo(this.accessCanEditPatientInfo);
        access.setAccessCanViewPatientInfo(this.accessCanViewPatientInfo);
        access.setAccessCanDeleteUser(this.accessCanDeleteUser);
        access.setAccessCanDeletePatientInfo(this.accessCanDeletePatientInfo);

        return access;
    }
}
