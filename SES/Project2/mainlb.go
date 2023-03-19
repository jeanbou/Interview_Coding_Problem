package main

import (
	"encoding/csv"
	"log"
	"net/http"
	"net/http/httputil"
	"net/url"
	"os"
	"time"
)

// 1 Column - path, Rest columns - servers with port (as many as you want solution is scalable)
var (
	records [][]string = readCsvFile("map1line.csv") // filepath to 1 line comma sep.csv
)

/*var (
	serverList = []*httputil.ReverseProxy{
		createHost("http://127.0.0.1:5001"),
		createHost("http://127.0.0.1:5002"),
	}
)*/

func main() {
	http.HandleFunc(records[0][0], forwardRequest) // path
	log.Fatal(http.ListenAndServe(":8000", nil))
}

func readCsvFile(filePath string) [][]string {
	f, err := os.Open(filePath)
	if err != nil {
		log.Fatal("Unable to read input file "+filePath, err)
	}
	defer f.Close()

	csvReader := csv.NewReader(f)
	records, err := csvReader.ReadAll()
	if err != nil {
		log.Fatal("Unable to parse file as CSV for "+filePath, err)
	}

	return records
}

func forwardRequest(res http.ResponseWriter, req *http.Request) {
	server := getServer()
	server.ServeHTTP(res, req)
}

func getServer() *httputil.ReverseProxy {
	secBasedIndex := (time.Now().Unix())%int64(len(records[0])-1) + 1 // 1 column is path so mod size-1
	server := createHost(records[0][secBasedIndex])
	//server := serverList[secBasedIndex]
	return server
}

func createHost(urlStr string) *httputil.ReverseProxy {
	u, _ := url.Parse(urlStr)
	//log.Printf("Routing the request to the URL %s", urlStr)
	return httputil.NewSingleHostReverseProxy(u)
}
