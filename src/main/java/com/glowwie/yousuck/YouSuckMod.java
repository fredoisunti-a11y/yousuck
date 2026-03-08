package com.glowwie.yousuck;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import java.util.List;
import java.util.Random;

public class YouSuckMod implements ModInitializer {

    private static final List<String> ROASTS = List.of(
        "you suck get better lmao",
        "bro really died AGAIN",
        "skill issue detected",
        "L + ratio + touch grass",
        "certified garbage player",
        "delete the game already",
        "your grandma plays better",
        "imagine dying here lmaooo"
    );

    private final Random random = new Random();

    @Override
    public void onInitialize() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, source, amount) -> {
            if (entity instanceof ServerPlayerEntity player) {
                String roast = ROASTS.get(random.nextInt(ROASTS.size()));
                player.sendMessage(Text.literal("§c§l[YouSuck] §r" + roast), false);
            }
            return true;
        });
