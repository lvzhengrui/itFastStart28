package org.lvzr.fast.ml.text.word2vec.util;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.lvzr.fast.ml.text.word2vec.domain.HiddenNeuron;
import org.lvzr.fast.ml.text.word2vec.domain.Neuron;

/**
 * 构建Haffman编码树
 * 
 * @author ansj
 *
 */
public class Haffman {
	private int layerSize;

	public Haffman(int layerSize) {
		this.layerSize = layerSize;
	}

	private TreeSet<Neuron> set = new TreeSet<Neuron>();

	public void make(Collection<Neuron> neurons) {
		set.addAll(neurons);
		while (set.size() > 1) {
			merger();
		}
	}

	private void merger() {
		HiddenNeuron hn = new HiddenNeuron(layerSize);
		Neuron min1 = set.pollFirst();
		Neuron min2 = set.pollFirst();
		hn.category = min2.category;
		hn.freq = min1.freq + min2.freq;
		min1.parent = hn;
		min2.parent = hn;
		min1.code = 0;
		min2.code = 1;
		set.add(hn);
	}

}
