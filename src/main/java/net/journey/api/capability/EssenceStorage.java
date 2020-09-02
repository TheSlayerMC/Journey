package net.journey.api.capability;

public interface EssenceStorage {

    boolean useEssence(int points);

    void addEssence(int points);

    int getEssenceValue();

    int getMaxValue();

    boolean isFull();

    void onTick();

    void regen();
}