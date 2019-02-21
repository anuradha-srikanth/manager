package com.boot.hotel.manager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
	public void testGuest() {
		Guest guest = new Guest();
		guest.setId(1L);
		when(guestService.get(1l)).thenReturn(guest);
		Guest sameGuest = guestService.get(1L);
		assertEquals(1L, sameGuest.getId().longValue());
		
	}
}
