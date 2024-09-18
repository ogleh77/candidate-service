package org.ogleh.candinatesservices.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Objectives {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int objectiveId;
    private String objective;
    private String objectiveProfile;
}
