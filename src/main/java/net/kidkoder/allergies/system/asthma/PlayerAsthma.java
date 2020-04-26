package net.kidkoder.allergies.system.asthma;

import net.minecraft.entity.player.PlayerEntity;

public class PlayerAsthma {

    AsthmaSeverity severity;
    String playerName;

    public PlayerAsthma(PlayerEntity player, AsthmaSeverity severity) {
        this.severity = severity;
        playerName = player.getName().getString();
    }

    public AsthmaSeverity getSeverity() {
        return severity;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setSeverity(AsthmaSeverity severity) {
        this.severity = severity;
    }

    public boolean hasAsthma() {
            if (severity.equals(AsthmaSeverity.NULL)) {
                return false;
            } else {
                return true;
            }
    }
}

