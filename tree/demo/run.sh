 #!/bin/bash

mvn clean install

mvn exec:java -Dexec.mainClass="com.example.controller.MyTree"