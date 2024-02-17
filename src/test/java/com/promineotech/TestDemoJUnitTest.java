package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {

			
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
			  else {
			  assertThatThrownBy(() ->

			    testDemo.addPositive(a, b))

			        .isInstanceOf(IllegalArgumentException.class);
			}
		
	}
	
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddNegative")
	void assertThatTwoNegativeNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {

			
			  assertThat(testDemo.addNegative(a, b)).isEqualTo(expected);
		}
			  else {
			  assertThatThrownBy(() ->

			    testDemo.addNegative(a, b))

			        .isInstanceOf(IllegalArgumentException.class);
			}
		
	}
	
	
	/* change this later */
	@Test
	static Stream<Arguments> argumentsForAddPositive() {
		
		//https://www.geeksforgeeks.org/generating-random-numbers-in-java/

		return Stream.of(arguments(1, 2, 3, false), arguments(1, 0, 1, true), arguments(-1, 0, -1, true));

	}
	
	static Stream<Arguments> argumentsForAddNegative() {
		
		//pass in the arguments for testing
		return Stream.of(arguments(-1, -2, -3, false), arguments(-1, 0, -1, true), arguments(1, 0, 1, true));

	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		
	}
	
	@Test
	void assertThatPairsOfNegativeNumbersAreAddedCorrectly() {
		//call the assertations that tell the systems what the function should return
		assertThat(testDemo.addNegative(-4,-5)).isEqualTo(-9);
		assertThat(testDemo.addNegative(-40,-50)).isEqualTo(-90);
		
	}
	
	@Test
	protected void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	//----------------------------------------------------------------------------
	}
