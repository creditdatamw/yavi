/*
 * Copyright (C) 2018-2021 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.constraint;

import am.ik.yavi.constraint.base.ConstraintBase;

import java.time.LocalDate;
import java.util.function.Predicate;

public class LocalDateConstraint<T> extends ConstraintBase<T, LocalDate, LocalDateConstraint<T>> {

	@Override
	public LocalDateConstraint<T> cast() {
		return this;
	}

	protected Predicate<LocalDate> isAfter(LocalDate other) {
		return x -> x.isAfter(other);
	}

	protected Predicate<LocalDate> isBefore(LocalDate other) {
		return x -> x.isBefore(other);
	}

	protected Predicate<LocalDate> isGreaterThanYears(int years) {
		return isGreaterThanYearsAfter(years, LocalDate.now());
	}


	protected Predicate<LocalDate> isLessThanYears(int years) {
		return isLessThanYearsBefore(years, LocalDate.now());
	}

	protected Predicate<LocalDate> isLessThanYearsBefore(int years, LocalDate base) {
		return x -> x.minusYears(years).isBefore(base);
	}

	protected Predicate<LocalDate> isGreaterThanYearsAfter(int years, LocalDate base) {
		return x -> x.minusYears(years).isAfter(base);
	}

	protected Predicate<LocalDate> isSame(LocalDate other) {
		return x -> x.equals(other);
	}

}
