#!/bin/bash

mvn clean install
mvn exec:java -Dexec.mainClass="main.java.com.example.controller.Queue_array"