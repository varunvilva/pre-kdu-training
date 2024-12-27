// package com.prekdu.models;

// import com.prekdu.enums.ResourceStatus;
// import com.prekdu.interfaces.Renewable;
// import com.prekdu.interfaces.Reservable;

// public class Book extends LibraryResource implements Renewable, Reservable {
//   private String author;
//   private String ISBN;

//   public Book(String resourceId, String title, String author, String ISBN) {
//     super(resourceId, title);
//     this.author = author;
//     this.ISBN = ISBN;
//   }

//   @Override
//   public double calculateLateFee(int daysLate) {
//     // TODO
//     return 0;
//   }

//   @Override
//   public int getMaxLoanPeriod() {
//     // TODO
//     return 0;
//   }

//   @Override
//   public void reserve(LibraryMember member) {}

//   @Override
//   public void cancelReservation(LibraryMember member) {}

//   @Override
//   public boolean renewLoan(LibraryMember member) {
//     if (this.availabilityStatus != ResourceStatus.BORROWED) {
//       return false;
//     }
//     this.availabilityStatus = ResourceStatus.BORROWED;
//     return true;
//   }

//   // Getters for author and ISBN
//   public String getAuthor() {
//     return author;
//   }

//   public String getIsbn() {
//     return ISBN;
//   }

//   @Override
//   public String toString() {
//     return "Book{"
//         + "resourceId='"
//         + resourceId
//         + '\''
//         + ", title='"
//         + title
//         + '\''
//         + ", author="
//         + author
//         + ", ISBN="
//         + ISBN
//         + ", availabilityStatus="
//         + availabilityStatus
//         + '}';
//   }
// }

package com.prekdu.models;

import com.prekdu.enums.ResourceStatus;
import com.prekdu.interfaces.Renewable;
import com.prekdu.interfaces.Reservable;

public class Book extends LibraryResource implements Renewable, Reservable {
  private String author;
  private String ISBN;

  public Book(String resourceId, String title, String author, String ISBN) {
    super(resourceId, title);
    this.author = author;
    this.ISBN = ISBN;
  }

  @Override
  public double calculateLateFee(int daysLate) {
    // Example late fee logic: $1 per day late
    return daysLate * 0.5;
  }

  @Override
  public int getMaxLoanPeriod() {
    // Example max loan period: 14 days for a book
    return 14;
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
    // Can only renew if the book is currently borrowed
    if (availabilityStatus != ResourceStatus.BORROWED) {
      return false;
    }
    availabilityStatus = ResourceStatus.BORROWED; // Renew the loan
    return true;
  }

  // Getters for author and ISBN
  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return ISBN;
  }

  @Override
  public String toString() {
    return "Book{"
        + "resourceId='"
        + resourceId
        + '\''
        + ", title='"
        + title
        + '\''
        + ", author='"
        + author
        + '\''
        + ", ISBN='"
        + ISBN
        + '\''
        + ", availabilityStatus="
        + availabilityStatus
        + '}';
  }
}
