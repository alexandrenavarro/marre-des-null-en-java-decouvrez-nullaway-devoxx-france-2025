package com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jspecify.annotations.Nullable;

import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public final class Price {
    private final BigDecimal value;
    private final String unit;


    @Nullable
    public static Price ofNullable(@Nullable BigDecimal value, @Nullable String unit) {
        return value != null && unit != null
                ? new Price(value, unit)
                : null;
    }

}
