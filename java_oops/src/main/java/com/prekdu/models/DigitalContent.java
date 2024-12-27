package com.prekdu.models;

import com.prekdu.enums.Format;
import com.prekdu.enums.ResourceStatus;
import com.prekdu.interfaces.Renewable;

public class DigitalContent extends LibraryResource implements Renewable {
  private double fileSize; // in MB
  private Format format;

  public DigitalContent(String resourceId, String title, double fileSize, Format format) {
    super(resourceId, title);
    this.fileSize = fileSize;
    this.format = format;
  }

  @Override
  public double calculateLateFee(int daysLate) {
    // TODO
    return daysLate * 0.25;
  }

  @Override
  public int getMaxLoanPeriod() {
    // TODO
    return 0;
  }

  @Override
  public boolean renewLoan(LibraryMember member) {
    if (this.availabilityStatus != ResourceStatus.BORROWED) {
      return false;
    }
    this.availabilityStatus = ResourceStatus.BORROWED;
    return true;
  }

  // getters abd setters
  public double getFileSize() {
    return fileSize;
  }

  public Format getFormat() {
    return format;
  }

  @Override
  public String toString() {
    return "DigitalContent{"
        + "resourceId='"
        + resourceId
        + '\''
        + ", title='"
        + title
        + '\''
        + ", fileSize="
        + fileSize
        + " MB"
        + ", format="
        + format
        + ", availabilityStatus="
        + availabilityStatus
        + '}';
  }
}
