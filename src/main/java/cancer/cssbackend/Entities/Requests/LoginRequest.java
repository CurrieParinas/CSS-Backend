package cancer.cssbackend.Entities.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("PASSWORD")
    private String password;
}
