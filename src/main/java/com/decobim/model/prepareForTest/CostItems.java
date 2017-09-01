package com.decobim.model.prepareForTest;

/**
 * 使用前要设置projectId,billId,billVersion,processId
 * Created by Administrator on 2017/8/31.
 */
public class CostItems {
    private String projectId;
    private String billId;
    private String billVersion;
    private String contractType;
    private String purchaseType;
    private String processId;
    private String materialLevel = "major";
    private String actualQuantity = "341";
    private String actualQuantityFormulas = "341";
    private String area = "商场入口";

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillVersion() {
        return billVersion;
    }

    public void setBillVersion(String billVersion) {
        this.billVersion = billVersion;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getMaterialLevel() {
        return materialLevel;
    }

    public void setMaterialLevel(String materialLevel) {
        this.materialLevel = materialLevel;
    }

    public String getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(String actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public String getActualQuantityFormulas() {
        return actualQuantityFormulas;
    }

    public void setActualQuantityFormulas(String actualQuantityFormulas) {
        this.actualQuantityFormulas = actualQuantityFormulas;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBidMeasurement() {
        return bidMeasurement;
    }

    public void setBidMeasurement(String bidMeasurement) {
        this.bidMeasurement = bidMeasurement;
    }

    public String getBidMeasurementUnit() {
        return bidMeasurementUnit;
    }

    public void setBidMeasurementUnit(String bidMeasurementUnit) {
        this.bidMeasurementUnit = bidMeasurementUnit;
    }

    public String getBillEncoding() {
        return billEncoding;
    }

    public void setBillEncoding(String billEncoding) {
        this.billEncoding = billEncoding;
    }

    public String getDirectCost() {
        return directCost;
    }

    public void setDirectCost(String directCost) {
        this.directCost = directCost;
    }

    public String getIntegrativeUnitPrice() {
        return integrativeUnitPrice;
    }

    public void setIntegrativeUnitPrice(String integrativeUnitPrice) {
        this.integrativeUnitPrice = integrativeUnitPrice;
    }

    public String getLabourCost() {
        return labourCost;
    }

    public void setLabourCost(String labourCost) {
        this.labourCost = labourCost;
    }

    public String getMachineCost() {
        return machineCost;
    }

    public void setMachineCost(String machineCost) {
        this.machineCost = machineCost;
    }

    public String getManagementCost() {
        return managementCost;
    }

    public void setManagementCost(String managementCost) {
        this.managementCost = managementCost;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(String materialCost) {
        this.materialCost = materialCost;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialLossRate() {
        return materialLossRate;
    }

    public void setMaterialLossRate(String materialLossRate) {
        this.materialLossRate = materialLossRate;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(String measureTime) {
        this.measureTime = measureTime;
    }

    public String getMeasuredLossRate() {
        return measuredLossRate;
    }

    public void setMeasuredLossRate(String measuredLossRate) {
        this.measuredLossRate = measuredLossRate;
    }

    public String getModelQuantity() {
        return modelQuantity;
    }

    public void setModelQuantity(String modelQuantity) {
        this.modelQuantity = modelQuantity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getSecondMaterial() {
        return secondMaterial;
    }

    public void setSecondMaterial(String secondMaterial) {
        this.secondMaterial = secondMaterial;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    private String bidMeasurement = "1";
    private String bidMeasurementUnit = "m2";
    private String billEncoding = "1";
    private String directCost = "341";
    private String integrativeUnitPrice = "7.2";
    private String labourCost = "199";
    private String machineCost = "3421";
    private String managementCost = "431";
    private String materialCode = "1";
    private String materialCost = "1232";
    private String materialId = "1";
    private String materialLossRate = "13434";
    private String materialName = "20mm水泥砂浆找平";
    private String materialTypeCode = "1";
    private String materialTypeName = "38砂浆及混凝土";
    private String measureTime = "2017-07-13 16:20";
    private String measuredLossRate = "341";
    private String modelQuantity = "4575212";
    private String position = "地面";
    private String profit = "431";
    private String projectDescribe = "基层材料种类、规格:1:2.5干拌砂浆，厚度根据现场情况综合考虑";
    private String ratio = "134";
    private String secondMaterial = "1434";
    private String teamName = "水泥砂浆";
    private String totalPrice = "410.4";

    public CostItems(String contractType, String purchaseType) {
        this.contractType = contractType;
        this.purchaseType = purchaseType;
    }

    public static CostItems shuangBao(){
        return new CostItems("双包",null);
    }

    public static CostItems danBao(){
        return new CostItems("单包",null);
    }

    public static CostItems laoWuFuCai(){
        return new CostItems("劳务辅材",null);
    }

    public static CostItems ziGou(){
        return new CostItems("材料项","自购");
    }

    public static CostItems jiaGong(){
        return new CostItems("材料项","甲供");
    }

    public static CostItems jiCai(){
        return new CostItems("材料项","集采");
    }
}
