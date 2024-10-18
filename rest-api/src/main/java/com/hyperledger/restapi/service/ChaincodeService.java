package main.java.com.hyperledger.restapi.service;

import org.springframework.stereotype.Service;

@Service
public class ChaincodeService {
    public String createAsset(String assetDetails) {
        // Call chaincode logic here
        return "Asset created: " + assetDetails;
    }

    public String readAsset(String dealerId) {
        // Call chaincode logic here
        return "Reading asset with dealerId: " + dealerId;
    }

    public String updateAsset(String updateDetails) {
        // Call chaincode logic here
        return "Updated asset: " + updateDetails;
    }

    public String getAssetHistory(String dealerId) {
        // Call chaincode logic here
        return "History of asset with dealerId: " + dealerId;
    }
}
