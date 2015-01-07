package com.nespresso.sofa.recruitment.labyrinth;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class GatesFactory {

	public static List<Gate> create(String... gates) {
		Function<String, Gate> gateTransformer = new Function<String, Gate>() {
			public Gate apply(String gateId) {
				char[] elements = gateId.toCharArray();
				Room r1 = new Room(String.valueOf(elements[0]));
				Room r2 = new Room(String.valueOf(elements[2]));
				return new Gate(r1, r2, elements[1] == '$');
			};
		};
		return Lists.newArrayList(Iterables.transform(Arrays.asList(gates), gateTransformer));
	}
}
