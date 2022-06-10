package models.lombok;

import lombok.Data;

@Data
public class CredentialsResponse {

    private long id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}