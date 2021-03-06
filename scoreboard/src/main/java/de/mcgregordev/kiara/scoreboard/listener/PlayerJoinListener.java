package de.mcgregordev.kiara.scoreboard.listener;

import de.mcgregordev.kiara.scoreboard.ScoreboardModule;
import de.mcgregordev.kiara.scoreboard.scoreboard.SidebarBuilder;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoinListener implements Listener {
    
    private ScoreboardModule module;
    
    public PlayerJoinListener( ScoreboardModule module ) {
        this.module = module;
    }
    
    @EventHandler
    public void onJoin( PlayerJoinEvent event ) {
        Player player = event.getPlayer();
        String[] lines = replaceVariables( player, module.getScoreboardContent() ).toArray( new String[ 0 ] );
        String title = replaceVariables( player, module.getScoreboardTitle() );
        new SidebarBuilder().add( lines ).setTitle( title ).send( player );
    }
    
    private String replaceVariables( Player player, String string ) {
        return ChatColor.translateAlternateColorCodes( '&', module.getVariableStorage().translate( player, string ) );
    }
    
    private List<String> replaceVariables( Player player, List<String> list ) {
        List<String> newList = new ArrayList<>();
        for ( String s : list ) {
            newList.add( replaceVariables( player, s ) );
        }
        return newList;
    }
}
