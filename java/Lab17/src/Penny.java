
public class Penny extends Coin {
	public Penny() {
		super(1);
	}
	@Override
	public String toString() {
		return "$ 0.0"+getValue();
	}
}
