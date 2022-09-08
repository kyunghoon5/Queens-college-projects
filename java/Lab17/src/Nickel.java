
public class Nickel extends Coin{
	public Nickel() {
		super(5);
	}
	@Override
	public String toString() {
		return "$ 0.0"+getValue();
	}
}
