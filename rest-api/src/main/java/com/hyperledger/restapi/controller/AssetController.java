package main.java.com.hyperledger.restapi.controller;

import com.hyperledger.restapi.service.ChaincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/assets")
public class AssetController {
    @Autowired
    private ChaincodeService chaincodeService;

    @PostMapping("/create")
    public ResponseEntity<String> createAsset(@RequestBody String assetDetails) {
        return ResponseEntity.ok(chaincodeService.createAsset(assetDetails));
    }

    @GetMapping("/read/{dealerId}")
    public ResponseEntity<String> readAsset(@PathVariable String dealerId) {
        return ResponseEntity.ok(chaincodeService.readAsset(dealerId));
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateAsset(@RequestBody String updateDetails) {
        return ResponseEntity.ok(chaincodeService.updateAsset(updateDetails));
    }

    @GetMapping("/history/{dealerId}")
    public ResponseEntity<String> getHistory(@PathVariable String dealerId) {
        return ResponseEntity.ok(chaincodeService.getAssetHistory(dealerId));
    }
}
