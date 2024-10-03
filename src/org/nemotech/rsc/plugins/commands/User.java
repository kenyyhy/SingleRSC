package org.nemotech.rsc.plugins.commands;

import org.nemotech.rsc.client.mudclient;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.plugins.Plugin;
import org.nemotech.rsc.plugins.listeners.action.CommandListener;

public class User extends Plugin implements CommandListener {

    @Override
    public void onCommand(String command, String[] args, Player player) {
        if(command.equals("help")) {
            mudclient.getInstance().showAlert("@yel@Single Player RSC Help %" + "@whi@Type ::stuck if your character gets stuck. % "
                + "Type ::pos to list your current location in the world."+"%@whi@Type ::tele(nameofBoss) ie:teleKBD"+"%@whi@Type ::tele(nameofCity) ie: telelumbridge", false);
            return;
        }
        //CITIES
        if(command.equals("telelumbridge")) {
            player.teleport(122, 647, true);
            player.getSender().sendMessage("You teleport to Lumbridge");
            return;
        }
        if(command.equals("televarrock")) {
            player.teleport(134, 507, true);
            player.getSender().sendMessage("You teleport to Varrock");
            return;
        }
        if(command.equals("telefalador")) {
            player.teleport(315, 542, true);
            player.getSender().sendMessage("You teleport to Falador");
            return;
        }
        if(command.equals("teleportsarim")) {
            player.teleport(269, 637, true);
            player.getSender().sendMessage("You teleport to Port Sarim");
            return;
        }
        if(command.equals("teletaverly")) {
            player.teleport(364, 500, true);
            player.getSender().sendMessage("You teleport to Taverly");
            return;
        }
        if(command.equals("telecatherby")) {
            player.teleport(421, 492, true);
            player.getSender().sendMessage("You teleport to Catherby");
            return;
        }
        if(command.equals("telecamelot")) {
            player.teleport(467, 456, true);
            player.getSender().sendMessage("You teleport to Camelot");
            return;
        }
        if(command.equals("teleseersvillage")) {
            player.teleport(520, 456, true);
            player.getSender().sendMessage("You teleport to Seer's Village");
            return;
        }
        if(command.equals("teleardougne")) {
            player.teleport(548, 590, true);
            player.getSender().sendMessage("You teleport to Ardougne");
            return;
        }
        if(command.equals("telealkharid")) {
            player.teleport(73,684, true);
            player.getSender().sendMessage("You teleport to Al Kharid");
            return;
        }
        //Bosses
        
        if(command.equals("stuck")) {
            player.teleport(122, 647, true);
            return;
        }
        if(command.equals("reload")) {
            //mudclient.getInstance().loadSection(mudclient.getInstance().sectionX, mudclient.getInstance().sectionY );
            return;
        }
        if(command.equals("pos") || command.equals("coords") || command.equals("sector")) {
            int x = player.getX();
            int y = player.getY();
            int sectorH = 0;
            int sectorX = 0;
            int sectorY = 0;
            if (x != -1 && y != -1) {
                if (y >= 0 && y <= 1007)
                    sectorH = 0;
                else if (y >= 1007 && y <= 1007 + 943) {
                    sectorH = 1;
                    y -= 943;
                } else if (y >= 1008 + 943 && y <= 1007 + (943 * 2)) {
                    sectorH = 2;
                    y -= 943 * 2;
                } else {
                    sectorH = 3;
                    y -= 943 * 3;
                }
                sectorX = (x / 48) + 48;
                sectorY = (y / 48) + 37;
            }
            player.getSender().sendMessage(String.format("@whi@X: %d Y: %d (Sector h%dx%dy%d)@que@", player.getX(), player.getY(), sectorH, sectorX, sectorY));
            return;
        }
    }

}