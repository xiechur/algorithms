package designPattern.builder.test;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class MyHome {
    private String door;
    private String kitchen;
    private String toilet;
    private String bathRoom;


    public void setDoor(String door) {
        this.door = door;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }


    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public void setBathRoom(String bathRoom) {
        this.bathRoom = bathRoom;
    }

    @Override
    public String toString() {
        return "MyHome{" +
                "door='" + door + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", toilet='" + toilet + '\'' +
                ", bathRoom='" + bathRoom + '\'' +
                '}';
    }

    public void entering() {
        System.out.println("I entering in myHome "+toString());
    }

}
