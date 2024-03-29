package plus.hideaway.mod.feat.location;

import net.minecraft.entity.boss.BossBar;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import plus.hideaway.mod.HideawayPlus;
import plus.hideaway.mod.feat.discord.PresenceImage;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public enum Location {

    // Locations
    ASTRAL_AUDITORIUM(
            "At the Astral Auditorium",
            "The show must go on! 🎭",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    ISLAND_EMPORIUM(
        "At the Island Emporium",
        "Ready to glam up my room 💺",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    FURNITURE_FUNCTIONATOR(
        "At the Furniture Functionator",
        "Designing a swanky hotel room 😎",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    MARKETPLACE_PIER(
            "On Marketplace Pier",
            "Il ove a shopping spree! 🛍️",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    MONKEY_BROTHERS(
            "With the Monkey Brothers",
            "Hey... you got the goods? 🥭",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    TINTS_N_TEXTURES(
        "At Tints'N'Textures",
        "That colour really suits you! 🎨",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    SKULL_ISLAND(
            "On Skull Island",
            "There's no turning back now. 💀",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL

    ),
    WARDROBE_WHEEL(
            "At the Wardrobe Wonder Wheel",
            "Chilling with the Wonder Squid 🍹",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),

    // Activities
    HOTEL_ROOM_SELF(
        "In their room",
        "Look at that view! 🏝️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    HOTEL_ROOM_OTHER(
            "In <player>'s room",
            "Look at that view! 🏝️",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    // 12AM = 2PM
    POOL_PARTY(
            "At a Pool Party",
            "Look at that view! 🏝️",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),

    WARDROBE(
        "In the Wardrobe",
        "Don't look! 👚",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),

    // Minigames
    BONFIRE(
            "At a bonfire",
            "... *crackle*",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    BOUNCE_BATTLE(
        "Playing Bounce Battle",
        "... *boing*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    BREAKFAST(
            "Eating breakfast",
            "... *crunch*",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    JETSKI(
        "In a Jetski Race",
        "... *nyoom*",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    KING_OF_CASTLE(
            "Playing King of the Castle",
            "... *royal noises*",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    TREASURE_DIVING(
            "Diving for treasure",
            "... *clink*",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    VOLLEYBALL(
            "Playing Beach Volleyball",
            "... *thwap*",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),

    // Miscellaneous
    BANANA(
            "By the Banana",
            "P O T A S S I U M",
            PresenceImage.Large.SCENE,
            PresenceImage.Small.ROUNDEL
    ),
    GENERIC(
        "On Hideaway Island",
        "Relaxing in the sun ☀️",
        PresenceImage.Large.SCENE,
        PresenceImage.Small.ROUNDEL
    ),
    SECRET(
        "You saw nothing...",
        "This is all just a dream... 😵‍💫",
        PresenceImage.Large.SCENE_DARK,
        PresenceImage.Small.ROUNDEL
    ),
    UNKNOWN(
        "Using Hideaway+",
        "Somewhere in the metaverse... 🚀",
        PresenceImage.Large.SCENE_DARK,
        PresenceImage.Small.ROUNDEL
    ),
    ;

    public final String name;
    public final String description;
    public final PresenceImage.Large largeIcon;
    public final PresenceImage.Small smallIcon;

    Location(
        String name,
        String description,
        PresenceImage.Large largeIcon,
        PresenceImage.Small smallIcon
    ) {
        this.name = name;
        this.description = description;
        this.largeIcon = largeIcon;
        this.smallIcon = smallIcon;
    }

    // Lord have mercy on my soul for the amount of intense,
    // messy and complicated hardcoding you are about to be
    // subjected to. Grab a paper bag if you get sick easily.
    public static void check() {
        if (!HideawayPlus.connected()) HideawayPlus.setLocation(UNKNOWN);

        // Location-based
        else if (playerIsInRadius(new Vec3d(13.5f, 7f, -115f), 5)) {
            HideawayPlus.setLocation(WARDROBE_WHEEL);
        }
        else if (playerIsInRadius(new Vec3d(-77.5f, 6f, -263.5f), 7)) {
            HideawayPlus.setLocation(MONKEY_BROTHERS);
        }
        else if (playerIsInRadius(new Vec3d(54.5f, 5f, -119.5f), 20)) {
            HideawayPlus.setLocation(ISLAND_EMPORIUM);
        }
        else if (playerIsInRadius(new Vec3d(59.5f, 15f, -82.5f), 20)) {
            HideawayPlus.setLocation(TINTS_N_TEXTURES);
        }
        else if (playerIsInRadius(new Vec3d(148.5f, 15f, -403.5f), 20)) {
            HideawayPlus.setLocation(BANANA);
        }
        else if (playerIsInRadius(new Vec3d(234.5f, 0f, -361.5f), 50)) {
            HideawayPlus.setLocation(BONFIRE);
        }
        else if (playerIsInRadius(new Vec3d(317.5f, 4f, -193.5f), 50)) {
            HideawayPlus.setLocation(BREAKFAST);
        }
        else if (playerIsInRadius(new Vec3d(145.5f, 0f, -203.5f), 50)) {
            HideawayPlus.setLocation(ASTRAL_AUDITORIUM);
        }
        else if (playerIsInRadius(new Vec3d(-319.5f, 9f, -236.5f), 65)) {
            HideawayPlus.setLocation(SKULL_ISLAND);
        }
        else if (playerIsInRadius(new Vec3d(122.5f, 3f, -94.5f), 65)) {
            HideawayPlus.setLocation(MARKETPLACE_PIER);
        }

        else if (HideawayPlus.player().getServer() != null) {
            // Sidebar/Bossbar-based
            if (Objects.requireNonNull(HideawayPlus.player().getServer()).getScoreboard() != null) {
                if (scoreboardContains("\ue4d5")) {
                    HideawayPlus.setLocation(KING_OF_CASTLE);
                }
                else if (scoreboardContains("\ue4db")) {
                    HideawayPlus.setLocation(BOUNCE_BATTLE);
                }
                else if (scoreboardContains("\ue4dc")) {
                    HideawayPlus.setLocation(TREASURE_DIVING);
                }
                else if (scoreboardContains("\ue523")) {
                    HideawayPlus.setLocation(JETSKI);
                }
                else if (scoreboardContains("\ue524")) {
                    HideawayPlus.setLocation(VOLLEYBALL);
                }
                else HideawayPlus.setLocation(GENERIC);
            }
            if (Objects.requireNonNull(HideawayPlus.player().getServer()).getBossBarManager().getAll().stream().findFirst().isPresent()) {
                if (scoreboardContains("\ue4d5")) {
                    HideawayPlus.setLocation(KING_OF_CASTLE);
                }
                else if (scoreboardContains("\ue4db")) {
                    HideawayPlus.setLocation(BOUNCE_BATTLE);
                }
                else if (scoreboardContains("\ue4dc")) {
                    HideawayPlus.setLocation(TREASURE_DIVING);
                }
                else if (scoreboardContains("\ue523")) {
                    HideawayPlus.setLocation(JETSKI);
                }
                else if (scoreboardContains("\ue524")) {
                    HideawayPlus.setLocation(VOLLEYBALL);
                }
                else HideawayPlus.setLocation(GENERIC);
            }
        }
        else if (HideawayPlus.player().isSpectator()) HideawayPlus.setLocation(WARDROBE);
        else HideawayPlus.setLocation(GENERIC);
    }

    private static boolean playerIsInRadius(Vec3d loc, int radius) {
        Vec3d actualLoc = HideawayPlus.player().getPos();
        return actualLoc.isInRange(loc, radius);
    }

    private static boolean scoreboardContains(String content) {
        ServerScoreboard board = HideawayPlus.player().getServer().getScoreboard();
        Text name = board.getObjectives().stream().toList().get(0).getDisplayName();
        Collection<String> names = board.getTeamNames();

        return name.getString().contains(content) || names.contains(content);
    }


    private static boolean bossbarContains(String content) {
        BossBar bar = HideawayPlus.player().getServer().getBossBarManager().getAll().stream().findFirst().get();
        return bar.getName().getString().contains(content);
    }
}
