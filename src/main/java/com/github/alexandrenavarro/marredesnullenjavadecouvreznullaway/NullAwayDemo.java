package com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway;


import org.springframework.util.StringUtils;

import java.util.Optional;

public final class NullAwayDemo {

    public static void main(String... args) {
        // Check if there is a compilation error because you can not pass null on not null parameter on a constructor or a method OK
//        final Person person1 = new Person(null, "lastname", null, null);
//        System.out.println(person1);

        // Check if you can pass null on mandatory field on the builder or any method OK
//        final Person person2 = Person.builder()
//                .firstName(null)
//                .lastName("lastName")
//                .build();
//        System.out.println(person2);

        // Check if you can pass null on optional field and call method on a nullable field OK
//        final Person person3 = Person.builder()
//                .firstName("firstname")
//                .lastName("lastname")
//                .middleName(null)
//                .build();
//        System.out.println(person3.getMiddleName().toString());

        // Check if there is a compilation error because calling with null a method accepting only NonNull KO
//        final String s = Collections.max(null);
//        System.out.println(s);

        // Check if there is a compilation error because calling with null a method accepting only NonNull methods added in LibraryModelsHandler OK
//        final Optional<Object> optional = Optional.of(null);
//        System.out.println(optional);

        // Check if there is a compilation error because you call a method on a potential null Spring Object OK
//        final String textQuoted = StringUtils.quote(null);
//        System.out.println(textQuoted.toString());

    }

}
