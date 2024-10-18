# Hyperledger Fabric Java Project
<br>
This project implements a blockchain-based system using **Hyperledger Fabric** to manage and track assets for a financial institution. The system supports creating assets, updating asset values, querying the world state to read assets, and retrieving asset transaction history. The assets represent accounts with attributes such as DEALERID, MSISDN, MPIN, BALANCE, STATUS, TRANSAMOUNT, TRANSTYPE, and REMARKS.
<br>

<h4> Set Up the Hyperledger Fabric Test Network</h4> <br>
Go to the fabric-samples/test-network directory and bring up the network. <br>
cd fabric-samples/test-network <br>
./network.sh up createChannel -c mychannel -ca
<br>
Deploy the chaincode from the hyperledger-fabric-java/chaincode/java directory.
<br>
./network.sh deployCC -ccn assetcontract -ccp ../../hyperledger-fabric-java/chaincode/java -ccl java
<br>
Build the Chaincode <br>
Navigate to the chaincode directory:
<br> 
cd hyperledger-fabric-java/chaincode/java <br>
gradle build
<br> 
 Run the REST API <br>
Navigate to the rest-api directory and build the Spring Boot project: <br>
<br> cd hyperledger-fabric-java/rest-api <br>
mvn clean install 
<br> 
Run the REST API locally:<br>
mvn spring-boot:run  <br>
Dockerize the REST API  <br>
To run the REST API inside a Docker container:  <br>

1.Build the Docker image:  <br>
docker build -t hyperledger-rest-api .  <br>
2.Run the Docker container:  <br>
docker run -p 8080:8080 hyperledger-rest-api  <br>

