package com.prekdu.models;

import com.prekdu.enums.MembershipType;
import com.prekdu.enums.ResourceStatus;
import java.util.HashSet;
import java.util.Set;
import com.prekdu.exceptions.MaximumLoanExceededException;
import com.prekdu.exceptions.ResourceNotAvailableException;

public class LibraryMember {
  private String memberId;
  private String name;
  private Set<LibraryResource> borrowedResources;
  private Set<LibraryResource> reservedResources;
  private MembershipType type;

  private static final int STANDARD_LOAN_LIMIT = 5;
  private static final int PREMIUM_LOAN_LIMIT = 10;

  private int getLoanLimit() {
    return (type == MembershipType.PREMIUM) ? PREMIUM_LOAN_LIMIT : STANDARD_LOAN_LIMIT;
  }

  // Constructor
  public LibraryMember(String memberId, MembershipType type) {
    this.memberId = memberId;
    this.type = type;
    this.borrowedResources = new HashSet<>();
    this.reservedResources = new HashSet<>();
  }

  // Methods to borrow and return resources
  public boolean borrowResource(LibraryResource resource) throws MaximumLoanExceededException, ResourceNotAvailableException{
    int limit = getLoanLimit();
    if (borrowedResources.size() >= limit) {
      throw new MaximumLoanExceededException("Loan limit exceeded for member " + memberId);
    }
    if (resource.getStatus() == ResourceStatus.AVAILABLE) {
      resource.setStatus(ResourceStatus.BORROWED);
      borrowedResources.add(resource);
      return true;
    }
    throw new ResourceNotAvailableException("Resource not available mone!");
//    return false;
  }


  public void returnResource(LibraryResource resource) {
    if (borrowedResources.contains(resource)) {
      resource.setStatus(ResourceStatus.AVAILABLE);
      borrowedResources.remove(resource);
    }
  }

  // Methods to reserve and cancel reservation
  public boolean reserveResource(LibraryResource resource) {
    if (resource.getStatus() == ResourceStatus.AVAILABLE) {
      resource.setStatus(ResourceStatus.RESERVED);
      reservedResources.add(resource);
      return true;
    }
    return false;
  }

  public void cancelReservation(LibraryResource resource) {
    if (reservedResources.contains(resource)) {
      resource.setStatus(ResourceStatus.AVAILABLE);
      reservedResources.remove(resource);
    }
  }

  // Getters and Setters
  public String getMemberId() {
    return memberId;
  }

  public String getName() {
    return name;
  }

  public Set<LibraryResource> getBorrowedResources() {
    return borrowedResources;
  }

  public Set<LibraryResource> getReservedResources() {
    return reservedResources;
  }

  // Method to print out the member's details
  @Override
  public String toString() {
    return "LibraryMember{"
        + "memberId='"
        + memberId
        + '\''
        + ", name='"
        + name
        + '\''
        + ", borrowedResources="
        + borrowedResources.size()
        + ", reservedResources="
        + reservedResources.size()
        + ", type='"
        + type
        + "\'"
        + '}';
  }
}
