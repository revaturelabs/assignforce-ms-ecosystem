//package com.revature.assignforce.settingsservice.domain;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.hateoas.ResourceSupport;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import java.util.regex.Pattern;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//@ApiModel( "Settings")
//public class Settings {
//
//	public class BatchSettings {
//
//		@ApiModelProperty( notes="Default building to create batches from.")
//		private String defaultBatchBuilding;
//		@ApiModelProperty( notes="Default location to create batches from.")
//		private String defaultBatchLocation;
//		@ApiModelProperty( notes="Default regular expression pattern to create names from.")
//		private Pattern defaultBatchNamePattern;
//		@ApiModelProperty( notes="Default maximum size of batch.")
//		private Short defaultMaxBatchSize;
//		@ApiModelProperty( notes="Default minimum size of batch.")
//		private Short defaultMinBatchSize;
//
//		public BatchSettings() {}
//
//		public BatchSettings( String batchBuilding, String batchLocation,
//				Pattern namePattern, Short maxBatchSize, Short minBatchSize) {
//			this.defaultBatchBuilding = batchBuilding;
//			this.defaultBatchLocation = batchLocation;
//			this.defaultBatchNamePattern = namePattern;
//			this.defaultMaxBatchSize = maxBatchSize;
//			this.defaultMinBatchSize = minBatchSize;
//		}
//
//		public String getDefaultBatchBuilding() {
//			return this.defaultBatchBuilding;
//		}
//		public void setDefaultBatchBuilding( String defaultBatchBuilding) {
//			this.defaultBatchBuilding = defaultBatchBuilding;
//		}
//
//		public String getDefaultBatchLocation() {
//			return this.defaultBatchLocation;
//		}
//		public void setDefaultBatchLocation( String defaultBatchLocation) {
//			this.defaultBatchLocation = defaultBatchLocation;
//		}
//
//		public Pattern getDefaultNamePattern() {
//			return this.defaultBatchNamePattern;
//		}
//		public void setDefaultNamePattern( Pattern defaultNamePattern) {
//			this.defaultBatchNamePattern = defaultNamePattern;
//		}
//
//		public Short getDefaultMaxBatchSize() {
//			return this.defaultMaxBatchSize;
//		}
//		public void setDefaultMaxBatchSize( Short defaultMaxBatchSize) {
//			this.defaultMaxBatchSize = defaultMaxBatchSize;
//		}
//
//		public Short getDefaultMinBatchSize() {
//			return defaultMinBatchSize;
//		}
//		public void setDefaultMinBatchSize( Short defaultMinBatchSize) {
//			this.defaultMinBatchSize = defaultMinBatchSize;
//		}
//
//		@Override
//		public String toString() {
//			return "BatchSettings [" +
//				", defaultBatchBuilding: " + this.defaultBatchBuilding +
//				", defaultBatchLocation: " + this.defaultBatchLocation +
//				", defaultBatchNamePattern: " + this.defaultBatchNamePattern +
//				", defaultMaxBatchSize: " + this.defaultMaxBatchSize +
//				", defaultMinBatchSize: " + this.defaultMinBatchSize +
//				"]";
//		}
//	}
//
//	public class ReportSettings {
//
//		@ApiModelProperty( notes="Duration of batch training.")
//		private Short defaultBatchLength;
//		@ApiModelProperty( notes="Number of graduates reported.")
//		private Short defaultGradsPerBatch;
//		@ApiModelProperty( notes="Number of incoming graduates reported.")
//		private Short defaultIncomingTraineesPerBatch;
//
//		public ReportSettings() {}
//
//		public ReportSettings( Short batchLength, Short gradsPerBatch,
//				Short traineesPerBatch) {
//			this.defaultBatchLength = batchLength;
//			this.defaultGradsPerBatch = gradsPerBatch;
//			this.defaultIncomingTraineesPerBatch = traineesPerBatch;
//		}
//
//		public Short getDefaultBatchLength() {
//			return this.defaultBatchLength;
//		}
//		public void setDefaultBatchLength( Short batchLength) {
//			this.defaultBatchLength = batchLength;
//		}
//
//		public Short getDefaultGradsPerBatch() {
//			return this.defaultGradsPerBatch;
//		}
//		public void setDefaultGradsPerBatch( Short gradsPerBatch) {
//			this.defaultGradsPerBatch = gradsPerBatch;
//		}
//
//		public Short getDefaultIncomingTraineesPerBatch() {
//			return this.defaultIncomingTraineesPerBatch;
//		}
//		public void setDefaultIncomingTraineesPerBatch( Short traineesPerBatch) {
//			this.defaultIncomingTraineesPerBatch = traineesPerBatch;
//		}
//
//		@Override
//		public String toString() {
//			return "ReportSettings [" +
//				" defaultBatchLength: " + this.defaultBatchLength +
//				", defaultGradsPerBatch: " + this.defaultGradsPerBatch +
//				", defaultIncomingTraineesPerBatch: " +
//				this.defaultIncomingTraineesPerBatch + "]";
//		}
//	}
//
//	public class TrainerSettings {
//		@ApiModelProperty( notes="Minimum allowance of time off for trainers.")
//		private Short minDayBtwBatches;
//		@ApiModelProperty( notes="Number of trainers viewed per page.")
//		private Short timelineTrainersPerPage;
//
//		public TrainerSettings() {}
//
//		public TrainerSettings( Short minDayBtwBatches, Short trainersPerPage) {
//			this.minDayBtwBatches = minDayBtwBatches;
//			this.timelineTrainersPerPage  = trainersPerPage;
//		}
//
//		public Short getMinDayBtwBatches() {
//			return this.minDayBtwBatches;
//		}
//		public void setMinDayBtwBatces( Short minDayBtwBatches) {
//			this.minDayBtwBatches = minDayBtwBatches;
//		}
//
//		public Short getTimelineTrainersPerPage() {
//			return this.timelineTrainersPerPage;
//		}
//		public void setTimelineTrainersPerPage( Short trainersPerPage) {
//			this.timelineTrainersPerPage = trainersPerPage;
//		}
//
//		@Override
//		public String toString() {
//		return "TrainerSettings [ minDayBtwBatches: " + this.minDayBtwBatches +
//			", timelineTrainersPerPage: " + this.timelineTrainersPerPage + "]";
//		}
//	}
//
//	@Id
//	@ApiModelProperty( notes="Id value for settings, defaulted to 1")
//	private static String id = "1";
//	private BatchSettings batchSettings;
//	private ReportSettings reportSettings;
//	private TrainerSettings trainerSettings;
//
//	public Settings() {}
//
//	public static String getId() {
//		return id;
//	}
//
//	public Settings( String id, BatchSettings batchSettings,
//			ReportSettings reportSettings, TrainerSettings trainerSettings) {
//		this.batchSettings = batchSettings;
//		this.reportSettings = reportSettings;
//		this.trainerSettings = trainerSettings;
//	}
//
//	public BatchSettings getBatchSettings() {
//		return this.batchSettings;
//	}
//	public void setBatchSettings( BatchSettings batchSettings) {
//		this.batchSettings = batchSettings;
//	}
//
//	public ReportSettings getReportSettings() {
//		return this.reportSettings;
//	}
//	public void setReportSettings( ReportSettings reportSettings) {
//		this.reportSettings = reportSettings;
//	}
//
//	public TrainerSettings getTrainerSettings() {
//		return this.trainerSettings;
//	}
//	public void setTrainerSettings( TrainerSettings trainerSettings) {
//		this.trainerSettings = trainerSettings;
//	}
//
//	@Override
//	public String toString() {
//		return "Settings [ " + this.batchSettings + this.reportSettings +
//			this.trainerSettings + "]";
//	}
//}
