package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Access;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAccessRequest {
    @JsonProperty("accessCanEnrollPatient")
    private char accessCanEnrollPatient;

    @JsonProperty("accessCanEditPatientInfo")
    private char accessCanEditPatientInfo;

    @JsonProperty("accessCanViewPatientInfo")
    private char accessCanViewPatientInfo;

    @JsonProperty("accessCanDeleteUser")
    private char accessCanDeleteUser;

    @JsonProperty("accessCanDeletePatientInfo")
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
