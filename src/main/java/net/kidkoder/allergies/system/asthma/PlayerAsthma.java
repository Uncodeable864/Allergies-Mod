package net.kidkoder.allergies.system.asthma;

import net.kidkoder.allergies.system.allergy.Allergen;
import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.Collections;

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
        return true;
    }
}
