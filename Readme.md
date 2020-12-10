# CSVReader
A simple project to extract data from a CSV file for analytics

## Compile
>sbt compile

## Test
>sbt test

## Run
>stb --error run

# Requirements
- [ ] Written in Scala/SBT
- [ ] Takes input from CLI
    - [ ] CSV or JSON simple datasets
    - [ ] Flags/environment variables
    - [ ] arguments
- [ ] Parses datasets into a Collection
    - [ ] Every line parsed into arrays
    - [ ] Every item in a line is gathered into a Map
- [ ] Analysis
    - [ ] Count every instance of a key from the Map
- [ ] Output analysis
    - [ ] Output to STDOUT
    - [ ] Output to File
    - [ ] Output to MongoDB

# Features
- [ ] CLI that takes dataset as file input
- [ ] Use Scala Map to map values from dataset as keys
- [ ] Aggregate and count (Reduce) all keys
- [ ] Return list of counts
- [ ] Well documented and extensive code coverage with unit tests
- [ ] Logs events and output to files and NoSQL databases