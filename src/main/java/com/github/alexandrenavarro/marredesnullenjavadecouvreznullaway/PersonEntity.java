package com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jilt.Builder;
import org.jilt.BuilderStyle;
import org.jspecify.annotations.Nullable;


@Entity(name = "person")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Builder(style = BuilderStyle.STAGED, factoryMethod = "builder", toBuilder = "toBuilder")
public class PersonEntity {

    @Column(name = "firstName", nullable = false)
    @ToString.Include
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @ToString.Include
    private String lastName;

    @Nullable
    @Column(name = "middleName", nullable = true)
    @ToString.Include
    private String middleName;

    public static PersonBuilders.FirstName builder() {
        return PersonBuilder.builder();
    }
}
