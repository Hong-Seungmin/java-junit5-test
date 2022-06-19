package com.example.javatest;

import org.junit.jupiter.api.DisplayName;

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
}