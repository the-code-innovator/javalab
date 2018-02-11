package pkbanking.pkinterface;

public interface Transaction{
  public final double min_balance = 500;
  public void deposit(double depositAmount);
  public void withdraw(double withdrawAmount);
}
