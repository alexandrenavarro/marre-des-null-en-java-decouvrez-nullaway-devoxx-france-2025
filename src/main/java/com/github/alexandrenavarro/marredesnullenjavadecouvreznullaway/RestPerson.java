package com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jilt.Builder;
import org.jilt.BuilderStyle;
import org.jspecify.annotations.Nullable;


//@AllArgsConstructor(access = AccessLevel.PACKAGE) // Lombok does not copy @JsonProperty from field, it seems to be a bug
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(style = BuilderStyle.STAGED, factoryMethod = "builder", toBuilder = "toBuilder")
public final class RestPerson {

    @NotNull
    private final String firstName;

    @NotNull
    private final String lastName;

    @Nullable
    private final String middleName;

    RestPerson(@JsonProperty("firstName") @NotNull String firstName,
               @JsonProperty("lastName") @NotNull String lastName,
               @JsonProperty("middleName") @Nullable String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public static RestPersonBuilders.FirstName builder() {
        return RestPersonBuilder.builder();
    }

}
