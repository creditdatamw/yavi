package am.ik.yavi.constraint.array;

import java.util.function.Predicate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FloatArrayConstraintTest {
	private FloatArrayConstraint<float[]> constraint = new FloatArrayConstraint<>();

	@Test
	public void notEmpty() {
		Predicate<float[]> predicate = constraint.notEmpty().holders().get(0).predicate();
		assertThat(predicate.test(new float[] { 100.0f })).isTrue();
		assertThat(predicate.test(new float[] {})).isFalse();
	}

	@Test
	public void lessThan() {
		Predicate<float[]> predicate = constraint.lessThan(2).holders().get(0)
				.predicate();
		assertThat(predicate.test(new float[] { 100.0f })).isTrue();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f })).isFalse();
	}

	@Test
	public void lessThanOrEquals() {
		Predicate<float[]> predicate = constraint.lessThanOrEquals(2).holders().get(0)
				.predicate();
		assertThat(predicate.test(new float[] { 100.0f })).isTrue();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f })).isTrue();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f, 102.0f })).isFalse();
	}

	@Test
	public void greaterThan() {
		Predicate<float[]> predicate = constraint.greaterThan(2).holders().get(0)
				.predicate();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f })).isFalse();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f, 102.0f })).isTrue();
	}

	@Test
	public void greaterThanOrEquals() {
		Predicate<float[]> predicate = constraint.greaterThanOrEquals(2).holders().get(0)
				.predicate();
		assertThat(predicate.test(new float[] { 100.0f })).isFalse();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f })).isTrue();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f, 102.0f })).isTrue();
	}

	@Test
	public void contains() {
		Predicate<float[]> predicate = constraint.contains(100.0f).holders().get(0)
				.predicate();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f })).isTrue();
		assertThat(predicate.test(new float[] { 101.0f, 102.0f })).isFalse();
	}

	@Test
	public void fixedSize() {
		Predicate<float[]> predicate = constraint.fixedSize(2).holders().get(0)
				.predicate();
		assertThat(predicate.test(new float[] { 100.0f })).isFalse();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f })).isTrue();
		assertThat(predicate.test(new float[] { 100.0f, 101.0f, 102.0f })).isFalse();
	}
}