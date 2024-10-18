# Hyperledger Fabric Java Project
<br>
This project implements a blockchain-based system using **Hyperledger Fabric** to manage and track assets for a financial institution. The system supports creating assets, updating asset values, querying the world state to read assets, and retrieving asset transaction history. The assets represent accounts with attributes such as DEALERID, MSISDN, MPIN, BALANCE, STATUS, TRANSAMOUNT, TRANSTYPE, and REMARKS.
<br>
## Project Structure <br> 
hyperledger-fabric-java/ │ ├── chaincode/ # Contains Java-based chaincode for Hyperledger Fabric │ └── java/ │ ├── build.gradle │ └── src/main/java/org/hyperledger/fabric/samples/ │ └── AssetContract.java │ ├── rest-api/ # Contains Spring Boot REST API │ ├── Dockerfile │ ├── pom.xml │ └── src/main/java/com/hyperledger/restapi/ │ ├── Application.java │ ├── controller/ │ │ └── AssetController.java │ └── service/ │ └── ChaincodeService.java │ ├── test-network/ # Hyperledger Fabric test network scripts └── README.md # Project documentation
<br>

hyperledger-fabric-java/ │ ├── chaincode/ # Contains Java-based chaincode for Hyperledger Fabric │ └── java/ │ ├── build.gradle │ └── src/main/java/org/hyperledger/fabric/samples/ │ └── AssetContract.java │ ├── rest-api/ # Contains Spring Boot REST API │ ├── Dockerfile │ ├── pom.xml │ └── src/main/java/com/hyperledger/restapi/ │ ├── Application.java │ ├── controller/ │ │ └── AssetController.java │ └── service/ │ └── ChaincodeService.java │ ├── test-network/ # Hyperledger Fabric test network scripts └── README.md # Project documentation

<h4> Set Up the Hyperledger Fabric Test Network</h4> <br>
Go to the fabric-samples/test-network directory and bring up the network. <br>
cd fabric-samples/test-network
./network.sh up createChannel -c mychannel -ca
<br>
Deploy the chaincode from the hyperledger-fabric-java/chaincode/java directory.
<br>
./network.sh deployCC -ccn assetcontract -ccp ../../hyperledger-fabric-java/chaincode/java -ccl java
<br>
Build the Chaincode
Navigate to the chaincode directory:
<br> 
cd hyperledger-fabric-java/chaincode/java
gradle build
<br>
 Run the REST API
Navigate to the rest-api directory and build the Spring Boot project:
<br> cd hyperledger-fabric-java/rest-api
mvn clean install
<br> 
Run the REST API locally:<br>
mvn spring-boot:run
Dockerize the REST API
To run the REST API inside a Docker container:

1.Build the Docker image:
docker build -t hyperledger-rest-api .
2.Run the Docker container:
docker run -p 8080:8080 hyperledger-rest-api

