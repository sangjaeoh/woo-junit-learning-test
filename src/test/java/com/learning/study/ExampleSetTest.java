package com.learning.study;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class ExampleSetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void Set_크기_확인_테스트(){
        // given && when
        int size = ExampleSet.size(numbers);

        // then
        int mock = 3;
        assertEquals(size, mock);
    }

    @DisplayName("Set안에 해당 값이 존재하는지 확인 테스트 1")
    @Test
    void set_contains_1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("Set안에 해당 값이 존재하는지 확인 테스트 2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_contains_2(int input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("Set안에 해당 값이 존재하는지 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void set_contains_true_false(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}