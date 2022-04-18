package ru.clevertec.listBenchmark;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class BenchmarkTestsArrayList {

	private List<Integer> listArray;
	private BenchmarkListService ls = new BenchmarkListService();

	@Setup(Level.Iteration)
	public void setup() {
		listArray = new ArrayList<>();
		ls.fiilList(listArray);
	}

	// ArrayList Benchmark add
	@Benchmark
	public void addArrayListFirst() {
		listArray.add(0, BenchmarkListService.ELEMENT);
	}

	@Benchmark
	public void addArrayListMiddle() {
		listArray.add(BenchmarkListService.MIDDLE_NUMBER, BenchmarkListService.ELEMENT);
	}

	@Benchmark
	public void addArrayListEnd() {
		listArray.add(BenchmarkListService.ELEMENT);
	}

	// ArrayList Benchmark remove
	@Benchmark
	public void removeArrayListElement() {
		if (listArray.size() > 0)
			listArray.remove(BenchmarkListService.ELEMENT);
	}

	// ArrayList Benchmark remove for index
	@Benchmark
	public void removeArrayListFirst(Blackhole bh) {
		if (listArray.size() > 0)
			bh.consume(listArray.remove(0));
	}

	@Benchmark
	public void removeArrayListMiddle() {
		if (listArray.size() > 0)
			listArray.remove(listArray.size() / 2);
	}

	@Benchmark
	public void removeArrayListEnd() {
		if (listArray.size() > 0)
			listArray.remove(listArray.size() - 1);
	}

	// ArrayList Benchmark get
	@Benchmark
	public void getArrayListMiddle(Blackhole bh) {
		Integer s = listArray.get(BenchmarkListService.MIDDLE_NUMBER);
		bh.consume(s);
	}

	@Benchmark
	public void getArrayListFirst(Blackhole bh) {
		Integer s = listArray.get(0);
		bh.consume(s);
	}

	@Benchmark
	public void getArrayListEnd(Blackhole bh) {
		Integer s = listArray.get(BenchmarkListService.MAX - 1);
		bh.consume(s);
	}

	// ArrayList Benchmark contains
	@Benchmark
	public void containsArrayList(Blackhole bh) {
		Boolean s = listArray.contains(BenchmarkListService.ELEMENT);
		bh.consume(s);
	}

}
