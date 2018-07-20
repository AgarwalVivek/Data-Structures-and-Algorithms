public class DDNode{
	int key;
	int freq;
	int value;
	DDNode left;
	DDNode right;
	
	public DDNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.freq = 1;
		left = right = null;
	}

	public int getFrequency() {
		// TODO Auto-generated method stub
		return freq;
	}

	public void incrementFrequency() {
		// TODO Auto-generated method stub
		freq++;
		
	}
}