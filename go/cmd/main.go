package main

import (
	"os"
	"time"

	"github.com/benni347/sorting/go/pkg/utils"

	log "github.com/sirupsen/logrus"
	cli "github.com/urfave/cli/v2"
	"github.com/urfave/cli/v2/altsrc"
)

const appName = "sorting"

var (
	logLevel = log.InfoLevel
	logger   *log.Logger
)

func main() {
	app := cli.NewApp()
	app.Name = appName
	app.Usage = "Different sorting algorithms implemented in go"
	app.Authors = []*cli.Author{
		{
			Name:  "Cédric Skwar",
			Email: "cedric@eyevip.com",
		},
	}
	flags := []cli.Flag{
		altsrc.NewStringFlag(&cli.StringFlag{
			Name:  "level",
			Value: "info",
			Usage: "Log level",
		}),
	}
	app.Suggest = true
	app.Compiled = time.Now()

	app.Action = func(c *cli.Context) error {
		logLevel, _ = log.ParseLevel(c.String("level"))
		initApp(c)
		runApp()
		return nil
	}

	app.Flags = flags
	err := app.Run(os.Args)
	if err != nil {
		panic(err)
	}
}

func initApp(*cli.Context) {
	// logging
	initLogging()
	logger.SetLevel(logLevel)
}

// initLogging
func initLogging() {
	logger = utils.NewLogger()
	logger.WithField("log-level", logLevel).Debug("logger setup")
}

func runApp() {
	logger.WithFields(log.Fields{}).Debug("Programm Arguments")
	utils.RunAndLogPerformance()
}
