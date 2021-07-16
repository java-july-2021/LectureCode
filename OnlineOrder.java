public class OnlineOrder extends Order {
  private int warehouseId;

  public OnlineOrder(int id, int total, String name) {
    super(id, total, name);
    this.warehouseId = 45;
  }

  public void cancel() {
    System.out.println("Order has been canceled from " + this.warehouseId);
  }

  public int getStoreId() {
    return this.warehouseId;
  }

  public void setStoreId(int warehouseId) {
    this.warehouseId = warehouseId;
  }
}