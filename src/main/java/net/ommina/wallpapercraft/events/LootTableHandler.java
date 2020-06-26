package net.ommina.wallpapercraft.events;


import net.minecraft.loot.*;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.items.ModItems;

//import net.minecraft.world.storage.loot.functions.SetCount;

//import net.minecraft.world.storage.loot.functions.ILootFunction;

@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.FORGE )
public class LootTableHandler {

    @SubscribeEvent
    public static void onLootTableLoadEvent( final LootTableLoadEvent event ) {

        if ( event.getName().equals( LootTables.CHESTS_SPAWN_BONUS_CHEST ) ) {
            addLootToTable( event.getTable(), 1, 64, false );
        } else if ( event.getName().equals( LootTables.CHESTS_VILLAGE_VILLAGE_MASON ) ) {
            addLootToTable( event.getTable(), 4, 32, true );
        } else if ( event.getName().equals( LootTables.CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE ) ) {
            addLootToTable( event.getTable(), 3, 32, true );
        } else if (
             event.getName().equals( LootTables.CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE ) ||
                  event.getName().equals( LootTables.CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE ) ||
                  event.getName().equals( LootTables.CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE ) ||
                  event.getName().equals( LootTables.CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE ) ) {
            addLootToTable( event.getTable(), 1, 32, true );
        }

    }

    private static void addLootToTable( final LootTable table, final int rolls, final int stackSize, final boolean addAPattern ) {

        table.addPool( getCommonPool( rolls, stackSize ) );

        if ( addAPattern )
            table.addPool( getPatternPool() );

    }

    private static LootPool getCommonPool( final int rolls, final int stackSize ) {

        final LootPool.Builder pool = LootPool.builder().name( Wallpapercraft.MODID + "common" ).rolls( new ConstantRange( rolls ) );
        final LootEntry.Builder lootEntry = ItemLootEntry.builder( ModItems.BASE_ITEM );
        final ILootFunction.IBuilder function = SetCount.builder( new ConstantRange( stackSize ) );

        ((StandaloneLootEntry.Builder) lootEntry).acceptFunction( function );

        pool.addEntry( lootEntry );

        return pool.build();

    }

    private static LootPool getPatternPool() {

        final LootPool.Builder pool = LootPool.builder().name( Wallpapercraft.MODID + "pattern" ).rolls( new ConstantRange( 1 ) );
        final ILootFunction.IBuilder function = SetCount.builder( new ConstantRange( 1 ) );

        pool.addEntry( ItemLootEntry.builder( ModItems.PRESS_CLAY ).acceptFunction( function ) );
        pool.addEntry( ItemLootEntry.builder( ModItems.PRESS_WOOD_PLANK ).acceptFunction( function ) );
        pool.addEntry( ItemLootEntry.builder( ModItems.PRESS_COLOURED_BRICK ).acceptFunction( function ) );
        pool.addEntry( ItemLootEntry.builder( ModItems.PRESS_SOLID ).acceptFunction( function ) );
        pool.addEntry( ItemLootEntry.builder( ModItems.PRESS_STONE_BRICK ).acceptFunction( function ) );
        pool.addEntry( ItemLootEntry.builder( ModItems.PRESS_STRIPED ).acceptFunction( function ) );

        return pool.build();

    }

}
