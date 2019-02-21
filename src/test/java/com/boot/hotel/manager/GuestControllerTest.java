package com.boot.hotel.manager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.GuestController;
import com.boot.model.Guest;
import com.boot.service.GuestService;

public class GuestControllerTest {
	
	@InjectMocks
	private GuestController guestController;
	
	@Mock
	private GuestService guestService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGet() {
		Guest guest = new Guest();
		guest.setId(1L);
		when(guestService.get(1l)).thenReturn(guest);
		Guest sameGuest = guestService.get(1L);
		assertEquals(1L, sameGuest.getId().longValue());
	}
	
	@Test
	public void testIndex() {
		Guest g1 = new Guest();
		g1.setId(1L);
		Guest g2 = new Guest();
		g2.setId(2L);
		Guest g3 = new Guest();
		g3.setId(3L);
		Guest[] actualGuests = {g1, g2, g3};
		when(guestService.index()).thenReturn(Arrays.asList(actualGuests));
		List<Guest> expectedGuests = guestService.index();
//		Assert.assertThat(guests.equals(sameGuests));
		assertThat(expectedGuests, containsInAnyOrder(g1, g2, g3));
	}
}
