package src.JG;

public class ListOfEnemies {

    public int len = 12;
    public Enemy1 gang[] = new Enemy1[len];

    public ListOfEnemies() {

    }

    public Enemy1[] buildGang() {
        gang[0] = new Enemy1(0, 10, 20, 0);
        gang[1] = new Enemy1(68, 10, 20, 68);
        gang[2] = new Enemy1(136, 10, 20, 136);
        gang[3] = new Enemy1(204, 10, 20, 204);
        gang[4] = new Enemy1(272, 10, 20, 272);
        gang[5] = new Enemy1(340, 10, 20, 340);
        gang[6] = new Enemy1(408, 10, 20, 408);
        gang[7] = new Enemy1(476, 10, 20, 476);
        gang[8] = new Enemy1(544, 10, 20, 544);
        gang[9] = new Enemy1(612, 10, 20, 612);
        gang[10] = new Enemy1(680, 10, 20, 680);
        gang[11] = new Enemy1(748, 10, 20, 748);

        return gang;
    }
}
