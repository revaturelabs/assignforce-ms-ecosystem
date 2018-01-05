package com.revature.assignforce.settingsService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * Created by lazar on 2/8/2017.
 */

@Document(collection = "settings")
public class Setting {
    @Id
    private int settingId;

    private String alias;

    private Integer trainersPerPage;

    private Integer reportGrads;

    private Integer batchLength;

    private Integer reportIncomingGrads;

    private Integer minBatchSize;

    private Integer maxBatchSize;

    private Integer trainerBreakDays;

    private Integer defaultLocation;

    private Integer defaultBuilding;

    private String defaultNamePattern;

    public Setting() {
    	//noarg constructor
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getTrainersPerPage() {
        return trainersPerPage;
    }

    public void setTrainersPerPage(Integer trainersPerPage) {
        this.trainersPerPage = trainersPerPage;
    }

    public Integer getReportGrads() {
        return reportGrads;
    }

    public void setReportGrads(Integer reportGrads) {
        this.reportGrads = reportGrads;
    }

    public Integer getBatchLength() {
        return batchLength;
    }

    public void setBatchLength(Integer batchLength) {
        this.batchLength = batchLength;
    }

    public Integer getReportIncomingGrads() {
        return reportIncomingGrads;
    }

    public void setReportIncomingGrads(Integer reportIncomingGrads) {
        this.reportIncomingGrads = reportIncomingGrads;
    }

    public Integer getMinBatchSize() {
        return minBatchSize;
    }

    public void setMinBatchSize(Integer minBatchSize) {
        this.minBatchSize = minBatchSize;
    }

    public Integer getMaxBatchSize() {
        return maxBatchSize;
    }

    public void setMaxBatchSize(Integer maxBatchSize) {
        this.maxBatchSize = maxBatchSize;
    }

    public Integer getTrainerBreakDays() {
        return trainerBreakDays;
    }

    public void setTrainerBreakDays(Integer trainerBreakDays) {
        this.trainerBreakDays = trainerBreakDays;
    }

    public Integer getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(Integer defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public Integer getDefaultBuilding() {
        return defaultBuilding;
    }

    public void setDefaultBuilding(Integer defaultBuilding) {
        this.defaultBuilding = defaultBuilding;
    }

    public String getDefaultNamePattern() {
        return defaultNamePattern;
    }

    public void setDefaultNamePattern(String defaultNamePattern) {
        this.defaultNamePattern = defaultNamePattern;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
