package gia.utp.primerproyecto.primerproyecto.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Embeddable
public class UserPK implements Serializable {

    private String documentType;
    private Integer documentNumber;

}
