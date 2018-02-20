package cn.bdqn.single;

public class Single {


	public static Single s = null;

	private Single() {

	}

	public static Single newInstance() {
		s = new Single();
		return s;
	}
	
}
