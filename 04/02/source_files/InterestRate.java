//initializing package pkbanking.pkinterface and nesting interface InterestRate in it :
package pkbanking.pkinterface;

//interface InterestRate definition :
public interface InterestRate{
	//savings account's Interest Rate :
  public final double sbrate = 0.04;

	//recurring deposit account's Interest Rate :
	public final double rdrate = 0.06;

	//fixed deposit account's Interest Rate :
  public final double fdrate = 0.0825;
}
//interface InterestRate end ...
