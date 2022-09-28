package com.learning.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class ExampleStringTest {

    @Test
    void 문자열_나누기_테스트_1(){
        // given
        String str = "1,2";
        ExampleString exampleString = new ExampleString();

        // when
        String[] result = exampleString.split(str);

        // then
        String[] mock = new String[]{"1","2"};
        assertArrayEquals(result, mock);
        assertThat(result).contains(mock);
        assertThat(result).containsExactly(mock);
    }

    @Test
    void 문자열_나누기_테스트_2(){
        // given
        String str = "1,";
        ExampleString exampleString = new ExampleString();

        // when
        String[] result = exampleString.split(str);

        // then
        String[] mock = new String[]{"1"};
        assertArrayEquals(result, mock);
        assertThat(result).contains(mock);
        assertThat(result).containsExactly(mock);
    }

    @Test
    void 문자열_반환_테스트(){
        // given
        String str = "(1,2)";
        ExampleString exampleString = new ExampleString();

        // when
        String result = exampleString.substring(str);

        // then
        String mock = "1,2";
        assertEquals(result, mock);
        assertThat(result).isEqualTo(mock);

    }

    @Test
    @DisplayName("특정 위치의 문자 반환 테스트")
    void 특정_위치의_문자_반환_테스트_1(){
        // given
        String str = "우테캠";
        int index = 1;
        ExampleString exampleString = new ExampleString();

        // when
        char result = exampleString.chatAt(str, index);

        // then
        char mock = '테';
        assertEquals(result, mock);
    }

    @Test
    @DisplayName("특정 위치의 문자 반환 에러 발생 테스트")
    void 특정_위치의_문자_반환_테스트_2(){
        // given
        String str = "우테캠";
        int index = 3;
        ExampleString exampleString = new ExampleString();

        // expect
        assertThrows(StringIndexOutOfBoundsException.class, () -> exampleString.chatAt(str, index));
        assertThatThrownBy(() -> exampleString.chatAt(str, index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index 3,length 3");
    }

}