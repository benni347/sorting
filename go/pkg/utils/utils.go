// Package utils is used for functions that are used in multiple locations
package utils

import (
	"math/rand"
	"os"
	"runtime"
	"time"

	"github.com/benni347/sorting/go/pkg/bogo"
	log "github.com/sirupsen/logrus"
)

var Logger *log.Logger

func getCaller() string {
	pc, _, _, _ := runtime.Caller(2)
	f := runtime.FuncForPC(pc)
	return f.Name()
}

// LogErrorDefaultFormat is used to print errors in a uniform way
func LogErrorDefaultFormat(packageName string, err error, action string) {
	Logger.WithFields(log.Fields{"package": packageName, "method": getCaller(), "error": err}).Error(action)
}

// LogPanicDefaultFormat is used to print errors in a uniform way, and exit with a Panic
func LogPanicDefaultFormat(packageName string, err error, action string) {
	Logger.WithFields(log.Fields{"package": packageName, "method": getCaller(), "error": err}).Panic(action)
}

// LogFatalDefaultFormat is used to print errors in a uniform way, and exit with a Panic
func LogFatalDefaultFormat(packageName string, err error, action string) {
	Logger.WithFields(log.Fields{"package": packageName, "method": getCaller(), "error": err}).Fatal(action)
}

// NewLogger follows this stack overflow post:
// https://stackoverflow.com/a/52923899/15410622
func NewLogger() *log.Logger {
	var level log.Level
	level, _ = LogLevel("info")
	logger := &log.Logger{
		Out:   os.Stdout,
		Level: level,
		Formatter: &log.TextFormatter{
			TimestampFormat: "2009-10-31T01:48:52Z",
			PadLevelText:    true,
		},
	}
	Logger = logger
	return Logger
}

// LogLevel Sets the log level for log
func LogLevel(lvl string) (log.Level, error) {
	return log.ParseLevel(lvl)
}

func logExecution(duration time.Duration, method string) {
	Logger.WithFields(log.Fields{
		"package":        "utils",
		"Execution Time": duration,
		"Sorter": method,
	}).Info("Sorted")
}

const (
	randomIntListLength = 10
	upperBoundList      = randomIntListLength * 10
)

var randomIntList []int

// RunAndLogPerformance runs the different algorithms
func RunAndLogPerformance() {
	for len(randomIntList) < randomIntListLength {
		randomIntList = append(randomIntList, rand.Intn(upperBoundList))
	}

	startTime := time.Now()
	bogo.Bogo(randomIntList)
	timeDuration := time.Since(startTime)
	logExecution(timeDuration, "bogo")
}
