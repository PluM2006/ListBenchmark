package ru.clevertec.listBenchmark;

import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class BenchmarkTestsLinkedList {

	private List<Integer> listLinked;
	private BenchmarkListService ls = new BenchmarkListService();

	@Setup(Level.Iteration)
	public void setup() {
		listLinked = new LinkedList<>();
		ls.fiilList(listLinked);
	}

	// LinkedList Benchmark add
	@Benchmark
	public void addLinkedListFirst() {
		listLinked.add(0, BenchmarkListService.ELEMENT);
	}

	@Benchmark
	public void addLinkedListMiddle() {
		listLinked.add(BenchmarkListService.MIDDLE_NUMBER, BenchmarkListService.ELEMENT);
	}

	@Benchmark
	public void addLinkedListEnd() {
		listLinked.add(BenchmarkListService.ELEMENT);
	}

	// LinkedList Benchmark remove
	@Benchmark
	public void removeLinkedListElement() {
		if (listLinked.size() > 0)
			listLinked.remove(BenchmarkListService.ELEMENT);
	}

	// LinkedList Benchmark remove for index
	@Benchmark
	public void removeLinkedListFirst() {
		if (listLinked.size() > 0)
			listLinked.remove(0);
	}

	@Benchmark
	public void removeLinkedListMiddle() {
		if (listLinked.size() > 0)
			listLinked.remove(listLinked.size() / 2);
	}

	@Benchmark
	public void removeLinkedListEnd() {
		if (listLinked.size() > 0)
			listLinked.remove(listLinked.size() - 1);
	}

	// LinkedList Benchmark add
	@Benchmark
	public void getLinkedListMiddle(Blackhole bh) {
		Integer s = listLinked.get(BenchmarkListService.MIDDLE_NUMBER);
		bh.consume(s);
	}

	@Benchmark
	public void getLinkedListFirst(Blackhole bh) {
		Integer s = listLinked.get(0);
		bh.consume(s);
	}

	@Benchmark
	public void getLinkedListEnd(Blackhole bh) {
		Integer s = listLinked.get(BenchmarkListService.MAX-1);
		bh.consume(s);
	}

	// LinkedList Benchmark contains
	@Benchmark
	public void containsLinkedList(Blackhole bh) {
		Boolean s = listLinked.contains(BenchmarkListService.ELEMENT);
		bh.consume(s);
	}

}
