package org.folio.calendar.unit.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import org.folio.calendar.domain.dto.Weekday;
import org.folio.calendar.testconstants.Dates;
import org.folio.calendar.utils.WeekdayUtils;
import org.junit.jupiter.api.Test;

class WeekdayUtilsTest {

  /**
   * Exhaustively test previous weekdays (due to the small cases and the switch usage in the code)
   */
  @Test
  void testPreviousWeekday() {
    assertThat(
      "Sunday is before Monday",
      WeekdayUtils.previous(Weekday.MONDAY),
      is(Weekday.SUNDAY)
    );
    assertThat(
      "Monday is before Tuesday",
      WeekdayUtils.previous(Weekday.TUESDAY),
      is(Weekday.MONDAY)
    );
    assertThat(
      "Tuesday is before Wednesday",
      WeekdayUtils.previous(Weekday.WEDNESDAY),
      is(Weekday.TUESDAY)
    );
    assertThat(
      "Wednesday is before Thursday",
      WeekdayUtils.previous(Weekday.THURSDAY),
      is(Weekday.WEDNESDAY)
    );
    assertThat(
      "Thursday is before Friday",
      WeekdayUtils.previous(Weekday.FRIDAY),
      is(Weekday.THURSDAY)
    );
    assertThat(
      "Friday is before Saturday",
      WeekdayUtils.previous(Weekday.SATURDAY),
      is(Weekday.FRIDAY)
    );
    assertThat(
      "Saturday is before Sunday",
      WeekdayUtils.previous(Weekday.SUNDAY),
      is(Weekday.SATURDAY)
    );
    assertThrows(
      "Invalid weekdays have no previous weekday",
      IllegalArgumentException.class,
      () -> WeekdayUtils.previous(Weekday.INVALID)
    );
  }

  /**
   * Exhaustively test next weekdays (due to the small cases and the switch usage in the code)
   */
  @Test
  void testNextWeekday() {
    assertThat("Monday is after Sunday", WeekdayUtils.next(Weekday.SUNDAY), is(Weekday.MONDAY));
    assertThat("Tuesday is after Monday", WeekdayUtils.next(Weekday.MONDAY), is(Weekday.TUESDAY));
    assertThat(
      "Wednesday is after Tuesday",
      WeekdayUtils.next(Weekday.TUESDAY),
      is(Weekday.WEDNESDAY)
    );
    assertThat(
      "Thursday is after Wednesday",
      WeekdayUtils.next(Weekday.WEDNESDAY),
      is(Weekday.THURSDAY)
    );
    assertThat("Friday is after Thursday", WeekdayUtils.next(Weekday.THURSDAY), is(Weekday.FRIDAY));
    assertThat("Saturday is after Friday", WeekdayUtils.next(Weekday.FRIDAY), is(Weekday.SATURDAY));
    assertThat("Sunday is after Saturday", WeekdayUtils.next(Weekday.SATURDAY), is(Weekday.SUNDAY));
    assertThrows(
      "Invalid weekdays have no next weekday",
      IllegalArgumentException.class,
      () -> WeekdayUtils.next(Weekday.INVALID)
    );
  }

  @Test
  void testSingleWeekdayRange() {
    assertThat(
      "Monday to Monday is {Monday}",
      WeekdayUtils.getRange(Weekday.MONDAY, Weekday.MONDAY),
      is(Arrays.asList(Weekday.MONDAY))
    );
    assertThat(
      "Saturday to Saturday is {Saturday}",
      WeekdayUtils.getRange(Weekday.SATURDAY, Weekday.SATURDAY),
      is(Arrays.asList(Weekday.SATURDAY))
    );
  }

  @Test
  void testMultipleWeekdayRange() {
    assertThat(
      "Monday to Friday is {Monday, Tuesday, Wednesday, Thursday, Friday}",
      WeekdayUtils.getRange(Weekday.MONDAY, Weekday.FRIDAY),
      is(
        Arrays.asList(
          Weekday.MONDAY,
          Weekday.TUESDAY,
          Weekday.WEDNESDAY,
          Weekday.THURSDAY,
          Weekday.FRIDAY
        )
      )
    );
    assertThat(
      "Friday to Tuesday is {Friday, Saturday, Sunday, Monday, Tuesday}",
      WeekdayUtils.getRange(Weekday.FRIDAY, Weekday.TUESDAY),
      is(
        Arrays.asList(
          Weekday.FRIDAY,
          Weekday.SATURDAY,
          Weekday.SUNDAY,
          Weekday.MONDAY,
          Weekday.TUESDAY
        )
      )
    );
  }

  @Test
  void testWeekdayConversion() {
    assertThat(
      "Jan 1 2021 is a Friday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_01_01),
      is(Weekday.FRIDAY)
    );
    assertThat(
      "Jan 2 2021 is a Saturday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_01_02),
      is(Weekday.SATURDAY)
    );
    assertThat(
      "Jan 3 2021 is a Sunday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_01_03),
      is(Weekday.SUNDAY)
    );
    assertThat(
      "Jan 4 2021 is a Monday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_01_04),
      is(Weekday.MONDAY)
    );
    assertThat(
      "Mar 16 2021 is a Tuesday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_03_16),
      is(Weekday.TUESDAY)
    );
    assertThat(
      "Sep 22 2021 is a Wednesday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_09_22),
      is(Weekday.WEDNESDAY)
    );
    assertThat(
      "Dec 30 2021 is a Thursday",
      WeekdayUtils.toWeekday(Dates.DATE_2021_12_30),
      is(Weekday.THURSDAY)
    );
  }
}
