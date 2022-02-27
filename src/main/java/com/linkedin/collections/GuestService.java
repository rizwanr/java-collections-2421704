package com.linkedin.collections;

import java.util.*;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */

		List<Guest> listOfGuest = guests.stream().filter(guest -> guest.getPreferredRooms().indexOf(room) == 0 ).collect(Collectors.toList());
		return listOfGuest;

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */

		if (guest.isLoyaltyProgramMember() && !checkinList.isEmpty()){

			int i =0;
			for (; i <this.checkinList.size(); i++) {
				if (checkinList.get(i).isLoyaltyProgramMember()){
					continue;
				}
				break;

			}
			this.checkinList.add(i, guest);
		}else{
			checkinList.add(guest);
		}

//		Comparator<Guest> programComp = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();
//		Queue<Guest> checkinQueue = new PriorityQueue<>(programComp);
//		checkinQueue.add(guest);
//		System.out.println(checkinQueue);


	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */

		if (checkinList.contains(guest1) && checkinList.contains(guest2)){
			int positionOfGuest1= checkinList.indexOf(guest1);
			int positionOfGuest2 = checkinList.indexOf(guest2);
			checkinList.set(positionOfGuest1,guest2);
			checkinList.set(positionOfGuest2,guest1);


		}

//		assertEquals(0, guests.indexOf(maria));
//		assertEquals(1, guests.indexOf(sonia));
//		assertEquals(2, guests.indexOf(siri));
//		assertEquals(3, guests.indexOf(bob));
//		assertEquals(4, guests.indexOf(john));




	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
