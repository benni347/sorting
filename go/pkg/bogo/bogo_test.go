package bogo

import (
	"reflect"
	"testing"
)

func TestBogoSort(t *testing.T) {
	testCases := []struct {
		input    []int
		expected []int
	}{
		{input: []int{1, 2, 3, 6, 4, 5}, expected: []int{1, 2, 3, 4, 5, 6}},
		{input: []int{1000, 2, 3, 6, 4, 5}, expected: []int{2, 3, 4, 5, 6, 1000}},
	}

	for _, tc := range testCases {
		result := Bogo(tc.input)
		if !reflect.DeepEqual(result, tc.expected) {
			t.Errorf("Expected %v for input %v, got %v", tc.expected, tc.input, result)
		}
	}
}

func TestBogoAlreadySorted(t *testing.T) {
	testCases := []struct {
		input    []int
		expected []int
	}{
		{input: []int{1, 2, 3, 4, 5}, expected: []int{1, 2, 3, 4, 5}},
		{input: []int{2, 3, 6, 4, 5, 1000}, expected: []int{2, 3, 4, 5, 6, 1000}},
	}

	for _, tc := range testCases {
		result := Bogo(tc.input)
		if !reflect.DeepEqual(result, tc.expected) {
			t.Errorf("Expected %v for input %v, got %v", tc.expected, tc.input, result)
		}
	}
}

func TestEmptyBogoSort(t *testing.T) {
	testCases := []struct {
		input    []int
		expected []int
	}{
		{input: []int{}, expected: []int{}},
		{input: []int{}, expected: []int{}},
	}

	for _, tc := range testCases {
		result := Bogo(tc.input)
		if !reflect.DeepEqual(result, tc.expected) {
			t.Errorf("Expected %v for input %v, got %v", tc.expected, tc.input, result)
		}
	}
}
