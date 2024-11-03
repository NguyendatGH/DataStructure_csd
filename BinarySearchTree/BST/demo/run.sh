#!/bin/bash

mvn clean install
# mvn exec:java -Dexec.mainClass="com.example.controller.SinglyLinkedList"
mvn exec:java -Dexec.mainClass="com.example.Main"   