package com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jilt.Builder;
import org.jilt.BuilderStyle;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(style = BuilderStyle.STAGED, factoryMethod = "builder")
public final class DriverLicense {
    private final String id;

    public static DriverLicenseBuilders.Id builder() {
        return DriverLicenseBuilder.builder();
    }
}
