package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ReservationController;
import com.boot.model.Reservation;
import com.boot.service.ReservationService;

public class ReservationControllerTest {
	
	@InjectMocks
	private ReservationController reservationController;
	
	@Mock
	private ReservationService reservationService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testIndex() {
		Reservation r1 = new Reservation();
		r1.setId(1L);
		Reservation r2 = new Reservation();
		r2.setId(2L);
		Reservation r3 = new Reservation();
		r3.setId(3L);
		Reservation[] actualReservations = {r1, r2, r3};
		when(reservationService.index()).thenReturn(Arrays.asList(actualReservations));
		List<Reservation> expectedReservations = reservationController.index();
		
		Reservation r1dup = new Reservation();
		r1dup.setId(1L);
		Reservation r2dup = new Reservation();
		r2dup.setId(2L);
		Reservation r3dup = new Reservation();
		r3dup.setId(3L);
		
		assertThat(expectedReservations, containsInAnyOrder(r3dup, r1dup, r2dup));
	}
	
	@Test
	public void testGet() {
		Reservation reservation = new Reservation();
		reservation.setId(1L);
		when(reservationService.get(1l)).thenReturn(reservation);
		Reservation sameReservation = reservationService.get(1L);
		assertEquals(1L, sameReservation.getId().longValue());
		sameReservation.setId(2L);
		assertTrue(1L != sameReservation.getId().longValue());
	}

	
	@Test
	public void testUpdate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Reservation actualReservation = new Reservation(1L, format.parse("2009-12-31"), format.parse ("2010-1-10"), 10L);
		Reservation expectedReservation = new Reservation(1L, format.parse("2010-1-31"), format.parse ("2010-2-10"), 10L);
		when(reservationService.update(1L, expectedReservation)).thenReturn(new Reservation(1L, format.parse("2010-1-31"), format.parse ("2010-2-10"), 10L));
		Reservation returnedReservation = reservationService.update(1L, expectedReservation);
//		System.out.println(returnedGuest.getId());
//		System.out.println(actualGuest.getId());
		assertEquals(returnedReservation, actualReservation);
		assertEquals(returnedReservation.getGuestId(),expectedReservation.getGuestId());
		assertEquals(returnedReservation.getCheckInDate(), expectedReservation.getCheckInDate());
		assertEquals(returnedReservation.getCheckOutDate(), expectedReservation.getCheckOutDate());
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		Reservation actualReservation = new Reservation();
		actualReservation.setId(1L);
		
		when(reservationService.deleteById(1L)).thenReturn(actualReservation).thenReturn(null);
		Reservation deletedReservation = reservationService.deleteById(1L);
		assertEquals(deletedReservation, actualReservation);
		Reservation nullGuest = reservationService.deleteById(1L);
		assertEquals(nullGuest, null);
	}
}
