package sk.the0retico.textsearch;

import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

@BenchmarkMethodChart
public final class PerformanceTest extends AbstractBenchmark {

	@Test
	public final void thirtyMillis() throws Exception {
		Thread.sleep(30);
	}

	@Test
	public final void twentyMillis() throws Exception {
		Thread.sleep(20);
	}
}
