package plus.hideaway.mod.feat.jukebox;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import plus.hideaway.mod.HideawayPlus;
import plus.hideaway.mod.Prompt;
import plus.hideaway.mod.feat.lifecycle.Task;

public class Jukebox {
    public long trackPointer = -1;
    public int partPointer = -1;
    public JukeboxTrack currentTrack = null;
    public JukeboxTrack.Part currentPart = null;

    public boolean looping = false;

    public Jukebox() {
        HideawayPlus.lifecycle().add(
            Task.of(() -> {
                // Nested if statements are purely because it'll crash if one of them is null
                if (!looping) {
                    if (HideawayPlus.client() != null) {
                        if (HideawayPlus.connected()) {
                            // Java needs deconstructors 😭
                            if (HideawayPlus.jukebox() != null) {
                                if (currentTrack != null && currentPart != null) {
                                    if (trackPointer >= currentPart.length) {
                                        loop();
                                    } else trackPointer++;
                                }
                            }
                        }
                    }
                }
            }, 0)
        );
    }

    public void play(JukeboxTrack track) {
        HideawayPlus.client().getSoundManager().stopAll();
        currentTrack = track;
        currentPart = track.parts.get(0);
        trackPointer = 0;
        partPointer = 0;
        HideawayPlus.client().player.playSound(
                SoundEvent.of(currentTrack.parts.get(partPointer).id), SoundCategory.MASTER, 1, 1
        );
    }

    private void loop() {
        looping = true;
        JukeboxTrack temp = currentTrack;
        stop();
        currentTrack = temp;

        partPointer++;
        trackPointer = 0;

        try {
            currentPart = currentTrack.parts.get(partPointer);
        } catch (Exception e) {
            partPointer = 0;
            currentPart = currentTrack.parts.get(partPointer);
        }
        try {
            HideawayPlus.client().player.playSound(
                    SoundEvent.of(currentTrack.parts.get(partPointer).id), SoundCategory.MASTER, 1, 1
            );
        } catch (Exception e) {
            Prompt.error("An issue occurred when looping music with the Jukebox. Please send your latest.log file to the developers of Hideaway+.");
        }
        looping = false;
    }

    public void stop() {
        HideawayPlus.client().getSoundManager().stopAll();
        currentTrack = null;
        currentPart = null;
        trackPointer = -1;
        partPointer = -1;
    }
}
