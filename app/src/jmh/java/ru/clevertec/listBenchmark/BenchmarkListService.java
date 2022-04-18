package ru.clevertec.listBenchmark;

import java.util.List;

public class BenchmarkListService {

	public final static int MAX = 100_000;

	public final static int MAX_NUMBER = 150;

	public final static int MIDDLE_NUMBER = MAX / 2;

	public final static Integer ELEMENT = 46;

	public void fiilList(List<Integer> list) {
		for (int i = 0; i < MAX; i++) {
			list.add(i);
		}
	}

}
