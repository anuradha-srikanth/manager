package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
		
		Guest g1dup = new Guest();
		g1dup.setId(1L);
		Guest g2dup = new Guest();
		g2dup.setId(2L);
		Guest g3dup = new Guest();
		g3dup.setId(3L);
		
		assertThat(expectedGuests, containsInAnyOrder(g3dup, g1dup, g2dup));
	}
	
	@Test
	public void testGet() {
		Guest guest = new Guest();
		guest.setId(1L);
		when(guestService.get(1l)).thenReturn(guest);
		Guest sameGuest = guestService.get(1L);
		assertEquals(1L, sameGuest.getId().longValue());
		sameGuest.setId(2L);
		assertTrue(1L != sameGuest.getId().longValue());
	}

	
	@Test
	public void testUpdate() {
		Guest actualGuest = new Guest(1L, "John", "Smith");
		Guest expectedGuest = new Guest(1L, "Jack", "Black");
		when(guestService.update(1L, expectedGuest)).thenReturn(new Guest(1L, "Jack", "Black"));
		Guest returnedGuest = guestService.update(1L, expectedGuest);
//		System.out.println(returnedGuest.getId());
//		System.out.println(actualGuest.getId());
		assertEquals(returnedGuest, actualGuest);
		assertEquals(returnedGuest.getFirst_name(),expectedGuest.getFirst_name());
		assertEquals(returnedGuest.getLast_name(), expectedGuest.getLast_name());
	}
	
	@Test
	public void testDelete() {
		Guest actualGuest = new Guest();
		actualGuest.setId(1L);
		
		when(guestService.deleteById(1L)).thenReturn(actualGuest).thenReturn(null);
		Guest deletedGuest = guestService.deleteById(1L);
		assertEquals(deletedGuest, actualGuest);
		Guest nullGuest = guestService.deleteById(1L);
		assertEquals(nullGuest, null);
	}
}
