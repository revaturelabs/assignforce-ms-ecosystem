package com.revature.assignforce.settingService.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by lazar on 2/8/2017.
 */

@ApiModel( "Settings")
@Document( collection = "Settings")
public class Setting {

    @Id
    private static String id;
    //private String alias;

	//	Batch Settings
	@ApiModelProperty( notes="Default minimum size of batch.")
	private Short defaultMinBatchSize;
	@ApiModelProperty( notes="Default maximum size of batch.")
	private Short defaultMaxBatchSize;
	@ApiModelProperty( notes="Default building to create batches from.")
	private String defaultBatchBuilding;
	@ApiModelProperty( notes="Default location to create batches from.")
    private Short defaultBatchLocation;
	@ApiModelProperty( notes="Default regular expression pattern to create names from.")
    private String defaultBatchNamePattern;

	//	Report Settings
	@ApiModelProperty( notes="Number of incoming graduates reported.")
	private Short defaultIncomingTraineesPerBatch;
	@ApiModelProperty( notes="Default number of graduates reported.")
	private Short defaultGradsPerBatch;
 	@ApiModelProperty( notes="Default duration of batch training.")
	private Short defaultBatchLength;

	//	Trainer Settings
	@ApiModelProperty( notes="Minimum allowance of time off for trainers.")
	private Short minDayBtwBatches;
	@ApiModelProperty( notes="Number of trainers viewed per page.")
	private Short timelineTrainersPerPage;

    public Setting() { }

    public static String getId() {
        return id;
    }
	public void setId() {
		this.id = "1";
	}

//    public String getAlias() {
//        return alias;
//    }
//
//    public void setAlias(String alias) {
//        this.alias = alias;
//    }

	// Batch Settings getters & setters
	public String getDefaultBatchBuilding() {
		return this.defaultBatchBuilding;
	}
	public void setDefaultBatchBuilding( String defaultBatchBuilding) {
		this.defaultBatchBuilding = defaultBatchBuilding;
	}

	public Short getDefaultBatchLocation() {
		return this.defaultBatchLocation;
	}
	public void setDefaultBatchLocation( Short defaultBatchLocation) {
		this.defaultBatchLocation = defaultBatchLocation;
	}

	public String getDefaultNamePattern() {
		return this.defaultBatchNamePattern;
	}
	public void setDefaultNamePattern( String defaultNamePattern) {
		this.defaultBatchNamePattern = defaultNamePattern;
	}

	public Short getDefaultMaxBatchSize() {
		return this.defaultMaxBatchSize;
	}
	public void setDefaultMaxBatchSize( Short defaultMaxBatchSize) {
		this.defaultMaxBatchSize = defaultMaxBatchSize;
	}

	public Short getDefaultMinBatchSize() {
		return defaultMinBatchSize;
	}
	public void setDefaultMinBatchSize( Short defaultMinBatchSize) {
		this.defaultMinBatchSize = defaultMinBatchSize;
	}

	//Report Settings getters & setters
	public Short getDefaultBatchLength() {
		return this.defaultBatchLength;
	}
	public void setDefaultBatchLength( Short batchLength) {
		this.defaultBatchLength = batchLength;
	}

	public Short getDefaultGradsPerBatch() {
		return this.defaultGradsPerBatch;
	}
	public void setDefaultGradsPerBatch( Short gradsPerBatch) {
		this.defaultGradsPerBatch = gradsPerBatch;
	}

	public Short getDefaultIncomingTraineesPerBatch() {
		return this.defaultIncomingTraineesPerBatch;
	}
	public void setDefaultIncomingTraineesPerBatch( Short traineesPerBatch) {
		this.defaultIncomingTraineesPerBatch = traineesPerBatch;
	}

	// Trainer Settings getters & setters
	public Short getMinDayBtwBatches() {
			return this.minDayBtwBatches;
	}
	public void setMinDayBtwBatces( Short minDayBtwBatches) {
		this.minDayBtwBatches = minDayBtwBatches;
	}

	public Short getTimelineTrainersPerPage() {
		return this.timelineTrainersPerPage;
	}
	public void setTimelineTrainersPerPage( Short trainersPerPage) {
		this.timelineTrainersPerPage = trainersPerPage;
	}

	public String toString() {
		return "Settings [" +
			", defaultBatchBuilding: " + this.defaultBatchBuilding +
			", defaultBatchLocation: " + this.defaultBatchLocation +
			", defaultBatchNamePattern: " + this.defaultBatchNamePattern +
			", defaultMaxBatchSize: " + this.defaultMaxBatchSize +
			", defaultMinBatchSize: " + this.defaultMinBatchSize +
			" defaultBatchLength: " + this.defaultBatchLength +
			", defaultGradsPerBatch: " + this.defaultGradsPerBatch +
			", defaultIncomingTraineesPerBatch: " +
			this.defaultIncomingTraineesPerBatch +
			"minDayBtwBatches: " + this.minDayBtwBatches +
			", timelineTrainersPerPage: " + this.timelineTrainersPerPage + "]";
	}
}
