package bogo

import (
	"math/rand"
	"slices"
)

// Bogo func
// Using the bogo sorting algorithm sort a int slice
// DO NOT USE IN PROD REALLY REALLY INEFFICIENT
// ONLY USE FOR eductional experience
func Bogo(randomIntList []int) []int {
	sortedList := make([]int, len(randomIntList))
	copy(sortedList, randomIntList)

	for !slices.IsSorted(sortedList) {
		rand.Shuffle(len(sortedList), func(i, j int) {
			sortedList[i], sortedList[j] = sortedList[j], sortedList[i]
		})
	}

	return sortedList
}
