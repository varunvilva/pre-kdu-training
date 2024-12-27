package com.prekdu.models;

import com.prekdu.enums.Frequency;
import com.prekdu.enums.ResourceStatus;
import com.prekdu.interfaces.Renewable;
import com.prekdu.interfaces.Reservable;

public class Periodical extends LibraryResource implements Renewable, Reservable {

  private String issueNumber;
  private Frequency frequency;

  public Periodical(String resourceId, String title, String issueNumber, Frequency frequency) {
    super(resourceId, title);
    this.issueNumber = issueNumber;
    this.frequency = frequency;
  }

  @Override
  public double calculateLateFee(int daysLate) {
    // TODO
    return 0;
  }

  @Override
  public int getMaxLoanPeriod() {
    // TODO
    return 0;
  }

  @Override
  public void reserve(LibraryMember member) throws  IllegalStateException{
    // Logic for reserving the book for a library member
    if (this.availabilityStatus == ResourceStatus.BORROWED) {
      this.availabilityStatus = ResourceStatus.RESERVED;
      System.out.println("Book reserved by member: " + member.getMemberId());
    } else {
//      System.out.println("Book is not available for reservation.");
      throw new IllegalStateException("Book is not available for reservation.");
    }
  }

  @Override
  public void cancelReservation(LibraryMember member) {
    // Logic to cancel a reservation
    if (this.availabilityStatus == ResourceStatus.RESERVED) {
      this.availabilityStatus = ResourceStatus.AVAILABLE;
      System.out.println("Reservation canceled by member: " + member.getMemberId());
    } else {
      System.out.println("No reservation to cancel.");
    }
  }

  @Override
  public boolean renewLoan(LibraryMember member) {
    if (this.availabilityStatus != ResourceStatus.BORROWED) {
      return false;
    }
    this.availabilityStatus = ResourceStatus.BORROWED;
    return true;
  }

  // getters and setters
  public String getIssueNumber() {
    return this.issueNumber;
  }

  public Frequency getFrequency() {
    return frequency;
  }

  @Override
  public String toString() {
    return "Periodical{"
        + "resourceId='"
        + resourceId
        + '\''
        + ", title='"
        + title
        + '\''
        + ", issueNumber="
        + issueNumber
        + ", frequency="
        + frequency
        + ", availabilityStatus="
        + availabilityStatus
        + '}';
  }
}
