package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookingTest {

    @Test
    void basePrice() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

        Booking booking = Booking.createBooking(lionKing, weekday);
        assertEquals(120, booking.basePrice());

        Booking premium = Booking.createPremiumBook(lionKing, weekday, new PremiumExtra(List.of(), 50));
        assertEquals(170, premium.basePrice());
    }

    @Test
    void basePrice_on_peakDay() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

        Booking booking = Booking.createBooking(lionKing, weekend);
        assertEquals(138, booking.basePrice());

        Booking premium = Booking.createPremiumBook(lionKing, weekend, new PremiumExtra(List.of(), 50));
        assertEquals(188, premium.basePrice());
    }

    @Test
    void talkback() {
        Show noTalkbackShow = new Show(List.of(), 120);
        Show talkbackShow = new Show(List.of("talkback"), 120);
        LocalDateTime nonPeekDay = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime peekDay = LocalDateTime.of(2022, 1, 15, 19, 0);

        assertFalse(Booking.createBooking(noTalkbackShow, nonPeekDay).hasTalkback());
        assertTrue(Booking.createBooking(talkbackShow, nonPeekDay).hasTalkback());
        assertFalse(Booking.createBooking(talkbackShow, peekDay).hasTalkback());

        PremiumExtra premiumExtra = new PremiumExtra(List.of(), 50);
        assertTrue(Booking.createPremiumBook(talkbackShow, peekDay, premiumExtra).hasTalkback());
        assertFalse(Booking.createPremiumBook(noTalkbackShow, peekDay, premiumExtra).hasTalkback());
    }

    @Test
    void hasDinner() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
        PremiumExtra premiumExtra = new PremiumExtra(List.of("dinner"), 50);

        assertTrue(Booking.createPremiumBook(lionKing, weekday, premiumExtra).hasDinner());
        assertFalse(Booking.createPremiumBook(lionKing, weekend, premiumExtra).hasDinner());
        assertFalse(Booking.createBooking(lionKing, weekday).hasDinner());
        assertFalse(Booking.createBooking(lionKing, weekend).hasDinner());
    }

}