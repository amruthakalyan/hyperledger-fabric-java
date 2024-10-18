package org.hyperledger.fabric.samples;

import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;

import org.json.JSONObject;

@Contract(name = "AssetContract")
@Default
public class AssetContract implements ContractInterface {

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void createAsset(Context ctx, String dealerId, String msisdn, String mpin, double balance, String status, String transAmount, String transType, String remarks) {
        JSONObject asset = new JSONObject();
        asset.put("dealerId", dealerId);
        asset.put("msisdn", msisdn);
        asset.put("mpin", mpin);
        asset.put("balance", balance);
        asset.put("status", status);
        asset.put("transAmount", transAmount);
        asset.put("transType", transType);
        asset.put("remarks", remarks);

        ctx.getStub().putStringState(dealerId, asset.toString());
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String readAsset(Context ctx, String dealerId) {
        String assetJSON = ctx.getStub().getStringState(dealerId);
        if (assetJSON == null || assetJSON.isEmpty()) {
            return "Asset not found";
        }
        return assetJSON;
    }

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void updateAsset(Context ctx, String dealerId, double newBalance, String status) {
        String assetJSON = ctx.getStub().getStringState(dealerId);
        if (assetJSON == null || assetJSON.isEmpty()) {
            throw new RuntimeException("Asset not found");
        }

        JSONObject asset = new JSONObject(assetJSON);
        asset.put("balance", newBalance);
        asset.put("status", status);

        ctx.getStub().putStringState(dealerId, asset.toString());
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String getAssetHistory(Context ctx, String dealerId) {
        Iterable<KeyModification> history = ctx.getStub().getHistoryForKey(dealerId);
        StringBuilder historyBuilder = new StringBuilder();
        for (KeyModification mod : history) {
            historyBuilder.append("Transaction: ")
                .append(mod.getTxId())
                .append(", Value: ")
                .append(mod.getStringValue())
                .append("\n");
        }
        return historyBuilder.toString();
    }
}
