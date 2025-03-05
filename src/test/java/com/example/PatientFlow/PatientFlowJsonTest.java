package com.example.PatientFlow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;


@JsonTest//annotation marks as a test class using the jackson framework
public class PatientFlowJsonTest {
    @Autowired//annotation that directs Spring to create an object of requested type
    private JacksonTester<Patient> json;//jacksontester is a convenience wrapper to the jackson JSON parsing library to handle serialization and deserialization of JSON objects

    @Test
    void patientSerializationTest() throws IOException {
        Patient patient = new Patient("Linda Brown", 92, 101);


        assertThat(json.write(patient)).isStrictlyEqualToJson("/expected.json");
        assertThat(json.write(patient)).hasJsonPathStringValue("@.name");
        assertThat(json.write(patient)).extractingJsonPathStringValue("@.name")
                        .isEqualTo("Linda Brown");
        assertThat(json.write(patient)).hasJsonPathNumberValue("@.age");
        assertThat(json.write(patient)).extractingJsonPathNumberValue("@.age")
                        .isEqualTo(92);
        assertThat(json.write(patient)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(patient)).extractingJsonPathNumberValue("@.id")
                        .isEqualTo(101);


    }

    @Test
    void patientDeserializationTest()throws IOException {
       String expected = """
               {
                    "name": "Linda Brown",
                    "age": 91,
                    "id": 102
               }
               """;
        Patient patient = json.parseObject(expected);

        assertThat(patient.getName()).isEqualTo("Linda Brown");
        assertThat(patient.getAge()).isEqualTo(91);
        assertThat(patient.getId()).isEqualTo(102);
    }
}
