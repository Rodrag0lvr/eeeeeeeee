package org.hign.platform.u202210584.personnel.domain.model.valueobjects;

import java.util.UUID;

public record NationalProviderIdentifier(String nationalProvider) {
    public NationalProviderIdentifier() {
        this(UUID.randomUUID().toString());
    }
    @Override
    public String toString() {
        return nationalProvider;
    }

    public NationalProviderIdentifier {
        if (nationalProvider == null || nationalProvider.isBlank()) {
            throw new IllegalArgumentException("NationalProvider cannot be null or blank");
        }
    }

}
