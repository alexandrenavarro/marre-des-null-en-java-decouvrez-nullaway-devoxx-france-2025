package com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestPersonTest {

    @Test
    void should_serialize_person_and_deserialize() throws JsonProcessingException {
        final RestPerson srcPerson = RestPerson.builder()
                .firstName("firstName")
                .lastName("lastName")
                .build();
        final ObjectMapper objectMapper = new ObjectMapper();
        final String serializedRestPerson = objectMapper.writeValueAsString(srcPerson);
        final RestPerson destPerson = objectMapper.readValue(serializedRestPerson, RestPerson.class);
        assertThat(destPerson).isEqualTo(srcPerson);
    }

}