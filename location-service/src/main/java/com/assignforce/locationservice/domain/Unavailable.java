package com.assignforce.locationservice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("Unavailable")
public class Unavailable {

//    private int ID;

    @ApiModelProperty(notes = "The start date of unavailability", name = "startDate", dataType = "Timestamp")
    private Date startDate;

    @ApiModelProperty(notes = "The end date of unavailability", name = "endDate", dataType = "Timestamp")
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Unavailable{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}