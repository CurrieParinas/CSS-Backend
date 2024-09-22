package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Access;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddAccessRequest {
    @JsonProperty("ACCESS_CANENROLLPATIENT")
    private char accessCanenrollpatient;

    @JsonProperty("ACCESS_CANEDITPATIENTINFO")
    private char accessCaneditpatientinfo;

    @JsonProperty("ACCESS_CANVIEWPATIENTINFO")
    private char accessCanviewpatientinfo;

    @JsonProperty("ACCESS_CANDELETEUSER")
    private char accessCandeleteuser;

    @JsonProperty("ACCESS_CANDELETEPATIENTINFO")
    private char accessCandeletepatientinfo;

    public Access mapToAccess(){
        Access access = new Access();
        access.setAccessCanenrollpatient(this.accessCanenrollpatient);
        access.setAccessCaneditpatientinfo(this.accessCaneditpatientinfo);
        access.setAccessCanviewpatientinfo(this.accessCanviewpatientinfo);
        access.setAccessCandeleteuser(this.accessCandeleteuser);
        access.setAccessCandeletepatientinfo(this.accessCandeletepatientinfo);

        return access;
    }
}
