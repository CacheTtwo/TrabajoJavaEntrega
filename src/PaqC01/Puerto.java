package PaqC01;

public class Puerto {
    private HUB[] hubs;

    public Puerto(HUB[] hubs) {
        this.hubs = new HUB[3];
    }

    public HUB[] getHubs() {
        return hubs;
    }

    public void setHubs(HUB[] hubs) {
        this.hubs = hubs;
    }
}
