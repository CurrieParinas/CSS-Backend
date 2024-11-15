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
public class SendMessageRequest {
    @JsonProperty("subject")
    private String subject;

    @JsonProperty("messageBody")
    private String message;

    @JsonProperty("recieverID") //patient
    private int recieverID;

    @JsonProperty("senderID") //doctor
    private int senderID;

    @JsonProperty("recieverEmail")
    private String receieverEmail;

    @JsonProperty("senderEmail")
    private String senderEmail;

    @JsonProperty("notificationType")
    private int notifType;
}
