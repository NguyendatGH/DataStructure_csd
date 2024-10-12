 #!/bin/bash

mvn clean install

# mvn exec:java -Dexec.mainClass="com.example.controller.Stack_ArrayList"

mvn exec:java -Dexec.mainClass="com.example.controller.Stack_LinkedList"
