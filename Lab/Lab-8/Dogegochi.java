public class Dogegochi {
  int energy;

  int activityRepeat = 0;
  String lastActivity;

  public Dogegochi() {
    this.energy = 50;
    lastActivity = "";
  }

  public void reduceEnergy() throws HungerException {
    // TO-DO: Implementasi method untuk reduce energy
    if (this.energy <= 0) {
      throw new HungerException("[FAILED: Dogenya lemes butuh makan:()]");
    } else {
      this.energy -= 20;
      if (this.energy < 0)
        this.energy = 0;
    }

  }

  public void addEnergy(int quantity) throws FullException {
    // TO-DO: Implementasi method untuk add energy
    if (this.energy >= 100) {
      throw new FullException("[FAILED: Dogenya sudah buncit tidak kuat makan lagi :(]");
    } else {
      this.energy += 2 * quantity;
      if (this.energy > 100)
        this.energy = 100;
    }

  }

  public void checkActivity(String activity) throws BoredException {
    if (this.activityRepeat == 2 && activity.equals(lastActivity)) {
      throw new BoredException("[FAILED: Dogenya bosan nih, gak mau melakukan hal lain saja?]");
    }
  }

  public void eat(String food, int quantity) {
    // TO-DO: Implementasi method untuk eat
    try {
      checkActivity("Makan");
      this.addEnergy(quantity);

      if (this.lastActivity.equals("Makan")) {
        activityRepeat++;
      } else {
        activityRepeat = 1;
      }
      this.lastActivity = "Makan";
      System.out.println(String.format("[SUCCESS : Dogenya makan %s sebanyak %d dengan gembira]", food, quantity));
    } catch (FullException e) {
      System.out.println(e.getMessage());
    } catch (BoredException e) {
      System.out.println(e.getMessage());
    }

  }

  public void play() {
    // TO-DO: Implementasi method untuk play
    try {
      checkActivity("Main");
      this.reduceEnergy();
      if (this.lastActivity.equals("Main")) {
        activityRepeat++;
      } else {
        activityRepeat = 1;
      }
      this.lastActivity = "Main";
      System.out.println("[SUCCESS: Dogenya bermain dengan senang hati]");
    } catch (HungerException e) {
      System.out.println(e.getMessage());
    } catch (BoredException e) {
      System.out.println(e.getMessage());
    }

  }

  public void getStatus() {
    System.out.println("Status Doge:");
    System.out.println("Energy = " + this.energy);
  }

}
