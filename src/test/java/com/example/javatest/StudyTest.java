package com.example.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StudyTest {

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study() {

        Study actual = new Study(10);
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again() {

        Study actual = new Study(10);
    }

    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println(
                "test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());

    }

    @DisplayName("스터디 만들기")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20, 40})
    void parameterizedTest(Integer message) {
        System.out.println("message = " + message);
    }

    @DisplayName("스터디 만들기2")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest2(Integer limit, String name) {
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
    }
}