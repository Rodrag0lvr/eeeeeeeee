package org.hign.platform.u202210584.assessment.interfaces.rest.resources;

import org.hign.platform.u202210584.personnel.domain.model.valueobjects.NationalProviderIdentifier;

import java.util.Date;

public record MentalStateExamResource(Long id,
                                      Long patientId,
                                      String examinerNationalProviderIdentifier,
                                      Date examDate,
                                      Integer orientationScore,
                                      Integer registrationScore,
                                      Integer attentionAndCalculationScore,
                                      Integer recallScore,
                                      Integer languageScore){
}