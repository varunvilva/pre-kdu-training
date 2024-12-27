package com.prekdu.interfaces;

import com.prekdu.models.LibraryMember;

public interface Reservable {
  public void reserve(LibraryMember member);

  public void cancelReservation(LibraryMember member);
}
