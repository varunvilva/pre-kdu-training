package com.prekdu.models;

import com.prekdu.enums.ResourceStatus;

public abstract class LibraryResource {
  // Protected fields to allow subclasses to access them directly
  protected String resourceId;
  protected String title;
  protected ResourceStatus availabilityStatus;

  // constructor
  public LibraryResource(String resourceId, String title) {
    this.resourceId = resourceId;
    this.title = title;
    this.availabilityStatus = ResourceStatus.AVAILABLE;
  }

  // Abstract method to calculate the late fee based on the number of days late
  public abstract double calculateLateFee(int daysLate);

  // Abstract method to get the maximum loan period for the resource
  public abstract int getMaxLoanPeriod();

  // Getters and setters
  public String getResourceId() {
    return resourceId;
  }

  public String getTitle() {
    return title;
  }

  public ResourceStatus getStatus() {
    return availabilityStatus;
  }

  public void setStatus(ResourceStatus status) {
    this.availabilityStatus = status;
  }

  // jsonify
  @Override
  public String toString() {
    return "LibraryResource{"
        + "resourceId='"
        + resourceId
        + '\''
        + ", title='"
        + title
        + '\''
        + ", availabilityStatus="
        + availabilityStatus
        + '}';
  }
}
