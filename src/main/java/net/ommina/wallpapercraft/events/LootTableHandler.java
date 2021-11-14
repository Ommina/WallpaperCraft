package net.ommina.wallpapercraft.events;

/*

import net.minecraft.loot.*;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.items.ModItems;

import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.ConstantIntValue;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;

@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.FORGE )
public class LootTableHandler {

    @SubscribeEvent
    public static void onLootTableLoadEvent( final LootTableLoadEvent event ) {

        if ( event.getName().equals( BuiltInLootTables.SPAWN_BONUS_CHEST ) ) {
            addLootToTable( event.getTable(), 1, 64, false );
        } else if ( event.getName().equals( BuiltInLootTables.VILLAGE_MASON ) ) {
            addLootToTable( event.getTable(), 4, 32, true );
        } else if ( event.getName().equals( BuiltInLootTables.VILLAGE_SAVANNA_HOUSE ) ) {
            addLootToTable( event.getTable(), 3, 32, true );
        } else if (
             event.getName().equals( BuiltInLootTables.VILLAGE_DESERT_HOUSE ) ||
                  event.getName().equals( BuiltInLootTables.VILLAGE_PLAINS_HOUSE ) ||
                  event.getName().equals( BuiltInLootTables.VILLAGE_SNOWY_HOUSE ) ||
                  event.getName().equals( BuiltInLootTables.VILLAGE_TAIGA_HOUSE ) ) {
            addLootToTable( event.getTable(), 1, 32, true );
        }

    }

    private static void addLootToTable( final LootTable table, final int rolls, final int stackSize, final boolean addAPattern ) {

        table.addPool( getCommonPool( rolls, stackSize ) );

        if ( addAPattern )
            table.addPool( getPatternPool() );

    }

    private static LootPool getCommonPool( final int rolls, final int stackSize ) {

        final LootPool.Builder pool = LootPool.lootPool().name( Wallpapercraft.MODID + "common" ).setRolls( new ConstantIntValue( rolls ) );
        final LootPoolEntryContainer.Builder lootEntry = LootItem.lootTableItem( ModItems.BASE_ITEM );
        final LootItemFunction.Builder function = SetItemCountFunction.setCount( new ConstantIntValue( stackSize ) );

        ((LootPoolSingletonContainer.Builder) lootEntry).apply( function );

        pool.add( lootEntry );

        return pool.build();

    }

    private static LootPool getPatternPool() {

        final LootPool.Builder pool = LootPool.lootPool().name( Wallpapercraft.MODID + "pattern" ).setRolls( new ConstantIntValue( 1 ) );
        final LootItemFunction.Builder function = SetItemCountFunction.setCount( new ConstantIntValue( 1 ) );

        pool.add( LootItem.lootTableItem( ModItems.PRESS_CLAY ).apply( function ) );
        pool.add( LootItem.lootTableItem( ModItems.PRESS_WOOD_PLANK ).apply( function ) );
        pool.add( LootItem.lootTableItem( ModItems.PRESS_COLOURED_BRICK ).apply( function ) );
        pool.add( LootItem.lootTableItem( ModItems.PRESS_SOLID ).apply( function ) );
        pool.add( LootItem.lootTableItem( ModItems.PRESS_STONE_BRICK ).apply( function ) );
        pool.add( LootItem.lootTableItem( ModItems.PRESS_STRIPED ).apply( function ) );

        return pool.build();

    }

}

*/