package tn.esprit.tpfoyer.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.service.ReservationServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceImplTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    private Reservation reservation;

    @BeforeEach
    public void setup() {
        reservation = new Reservation();

    }

    @Test
    public void testRetrieveReservation() {
        when(reservationRepository.findById(anyString())).thenReturn(Optional.of(reservation));

        Reservation result = reservationService.retrieveReservation("1");

        assertNotNull(result);

        verify(reservationRepository, times(1)).findById("1");
    }

    @Test
    public void testAddReservation() {
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation result = reservationService.addReservation(reservation);

        assertNotNull(result);

        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testRemoveReservation() {
        doNothing().when(reservationRepository).deleteById(anyString());

        reservationService.removeReservation("1");

        verify(reservationRepository, times(1)).deleteById("1");
    }
}
