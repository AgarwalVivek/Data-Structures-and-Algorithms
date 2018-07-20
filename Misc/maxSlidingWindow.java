import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class maxSlidingWindow{
	public int[] maxSlidingWindow(int[] nums, int k) {

	if ((nums.length) == 0) {
		return nums;
	}
	int[] result = new int[nums.length - k + 1];
	Map<Integer, Integer> dataMap = new TreeMap<>(Collections.reverseOrder());
	ArrayList<Integer> indexValue = new ArrayList<Integer>();

	int resultIndex = 0;
	for (int i = 0; i < nums.length; i++) {
		addElementToMap(dataMap, nums, i);
		indexValue.add(nums[i]);
		if (i > k) {
			result[resultIndex++] = dataMap.entrySet().iterator().next().getKey();
			removeElementFromMap(dataMap, indexValue.get(0));
			indexValue.remove(0);
		}
	}
	return result;
}

private void addElementToMap(Map<Integer, Integer> dataMap, int[] nums, int i) {
	if (dataMap.get(nums[i]) == null) {
		dataMap.put(nums[i], 1);
	} else {
		dataMap.put(nums[i], dataMap.get(nums[i]) + 1);
	}
}

private void removeElementFromMap(Map<Integer, Integer> dataMap, int val) {
	if (1 == dataMap.get(val)) {
		dataMap.remove(val);
	} else {
		dataMap.put(val, dataMap.get(val) - 1);
	}

}
}