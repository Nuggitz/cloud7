package cui;

import domein.DomeinController;
import exceptions.CritException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CloudApp {

    private DomeinController dc;

    public CloudApp(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        while (!dc.playerDead()) {
            dc.newFight();
            System.err.printf("%nNEW BOSS (level %.0f)%n%n", dc.bossStats()[0]);
            while (!dc.bossDead() && !dc.playerDead()) {
                System.out.println(dc.player());
                System.out.println(dc.boss());
                menu();
            }
            if (!dc.playerDead()) {
                System.err.println("BOSS IS DEAD");
                //dc.addPoint(1);
                System.out.println("Player hit " + dc.playerHits() + " times and gained " + dc.levelPlayer(1) + " points\n");
                menuBossDead();
            }
        }
        System.out.println("player is dead\n");
        System.out.println("Game over\nYou defeated " + dc.gameStats()[0] + " bosses, last boss was level " + dc.gameStats()[2] + "\n");
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        int k = 0;
        boolean g = false;
        while (!g || (k != 1 && k != 2)) {
            try {
                System.out.print("1 to damage\n2 to block\nchoice: ");
                k = s.nextInt();
                g = true;
            } catch (InputMismatchException e) {
                System.out.println("\nplease enter 1 or 2\n");
                s.nextLine();
            }
        }
        System.out.println();
        if (k == 1) {
            if (!dc.playerHit()[0]) {
                System.out.printf("Hit(%d) boss for %.1f damage%n", dc.playerHits(), dc.playerStats()[4]);
            } else {
                System.err.printf("Crit boss for %.1f damage%n", dc.playerStats()[4]);
            }
        } else if (k == 2) {
            dc.playerBlock();
            System.out.println("Blocking next attack");
        }

        if (dc.damagePlayer()[0]) {
            System.err.printf("%nBoss crit player for %.1f damage%n", dc.bossStats()[1]);
        } else {
            System.out.printf("%nBoss hit player for %.1f damage%n", dc.bossStats()[1]);
        }

        if (dc.isPlayerBlock()) {
            dc.playerBlocked();
            System.err.println("Player blocked the attack!\n");
        }

        System.out.println();
    }

    public void menuBossDead() {
        Scanner s = new Scanner(System.in);
        int c;
        boolean g = false;
        while (dc.getPoints() > 0 || !g) {
            try {
                System.out.println(dc.player());
                System.out.printf("Points: %d%n", dc.getPoints());
                System.out.printf("0: pass%n1: %.1f%% crit%n2: %"
                        + ".1f health%n3: %.1f damage%n4: level up%nChoice: ",
                        dc.playerLevelUpStats()[0], dc.playerLevelUpStats()[1], dc.playerLevelUpStats()[2]);
                c = s.nextInt();
                if (c == 0) {
                    break;
                }
                String[] stats = dc.upPlayerStats(c);
                System.out.printf("%nLeveled up %s by %s%n%n", stats[0], stats[1]);
                g = true;
            } catch (CritException e) {
                System.out.println("\n" + e.getMessage() + "\n");
                s.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("\nplease enter a correct value\n");
                s.nextLine();
            }
        }
    }
}
