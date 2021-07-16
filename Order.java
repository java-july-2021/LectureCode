public abstract class Order {
  private int id;
  private int total;
  private String name;

  public Order(int id, int total, String name) {
    this.id = id;
    this.total = total;
    this.name = name;
  }

  public String displayOrder() {
    return this.name;
  }

  public abstract void cancel();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}