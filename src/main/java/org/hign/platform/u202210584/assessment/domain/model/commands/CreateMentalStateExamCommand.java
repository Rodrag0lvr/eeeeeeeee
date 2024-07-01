package org.hign.platform.u202210584.assessment.domain.model.commands;

import org.hign.platform.u202210584.personnel.domain.model.valueobjects.NationalProviderIdentifier;

import java.util.Date;

public record CreateMentalStateExamCommand(Long patientId, String examinerNationalProviderIdentifier, Date examDate, Integer orientationScore,
                                           Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
    public CreateMentalStateExamCommand{
        if( registrationScore < 0 || registrationScore > 3){
            throw new IllegalArgumentException("Registration score must be between 0 and 3");
        }
        if( orientationScore < 0 || orientationScore > 10){
            throw new IllegalArgumentException("Orientation score must be between 0 and 5");
        }
        if (examDate == null || examDate.after(new Date())) {
            throw new IllegalArgumentException("Exam date cannot be null");
        }
         if( attentionAndCalculationScore < 0 || attentionAndCalculationScore > 5) {
             throw new IllegalArgumentException("Attention and calculation score must be between 0 and 5");
         }
         if( recallScore < 0 || recallScore > 3){
            throw new IllegalArgumentException("Recall score must be between 0 and 3");
         }
         if(languageScore < 0 || languageScore > 9){
            throw new IllegalArgumentException("Language score must be between 0 and 2");
         }
    }

}