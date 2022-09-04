package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.datagen.util.ModModels;
import com.moltenwolfcub.crafted_cuisine.datagen.util.ModTextureMaps;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.RodBlock;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.client.When;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }



    public static class WoodTypeModelGen{
        Map<Variant, Block> BLOCK_MAP = new HashMap<>();
        BlockStateModelGenerator stateGen;

        TextureMap planksTextures;
        Identifier planksModelId;

        public WoodTypeModelGen(BlockStateModelGenerator stateGen) {
            this.stateGen = stateGen;
        }

        public void register() {
            registerHelper(Variant.PLANKS, this::registerPlanks);

            registerHelper(Variant.BUTTON, this::registerButton);
            registerHelper(Variant.DOOR, this::registerDoor);
            registerHelper(Variant.FENCE, this::registerFence);
            registerHelper(Variant.FENCE_GATE, this::registerFenceGate);
            registerHelper(Variant.LEAVES, this::registerLeaves);
            registerHelper(Variant.LOG, this::registerLog);
            registerHelper(Variant.PRESSURE_PLATE, this::registerPressurePlate);
            registerHelper(Variant.SIGN, this::registerSign);
            registerHelper(Variant.SLAB, this::registerSlab);
            registerHelper(Variant.STAIRS, this::registerStairs);
            registerHelper(Variant.STRIPPED_LOG, this::registerLog);
            registerHelper(Variant.TRAPDOOR, this::registerTrapdoor);

            registerHelperWood(Variant.WOOD);
            registerHelperWood(Variant.STRIPPED_WOOD);
        }
        public void registerHelper(Variant type, Consumer<Block> registerFunction) {
            Block testingBlock;
            if ((testingBlock = BLOCK_MAP.get(type)) != null) {
                registerFunction.accept(testingBlock);
            }
        }
        public void registerHelperWood(Variant type) {
            if(type != Variant.WOOD && type != Variant.STRIPPED_WOOD) {
                CraftedCuisine.LOGGER.error("The registerHelperWood method was used for "+ type.name +
                ". It should only be used for wood. (Use registerHelper for other types)");
                return;
            }

            Block woodBlock;
            Block logBlock;
            if ((woodBlock = BLOCK_MAP.get(type)) != null) {
                if((logBlock = BLOCK_MAP.get(type == Variant.WOOD ? Variant.LOG : Variant.STRIPPED_LOG)) != null) {
                    registerWood(woodBlock, logBlock);
                } else {
                    CraftedCuisine.LOGGER.error("The Wood: "+ woodBlock +" has no log assosiated with it.");
                }
            }
        }

        public void registerButton(Block buttonBlock) {
            //models
            Identifier button = Models.BUTTON.upload(buttonBlock, this.planksTextures, stateGen.modelCollector);
            Identifier pressedButton = Models.BUTTON_PRESSED.upload(buttonBlock, this.planksTextures, stateGen.modelCollector);
            //blockstates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(buttonBlock, button, pressedButton));
            //blockItem model
            Identifier inventoryButton = Models.BUTTON_INVENTORY.upload(buttonBlock, this.planksTextures, stateGen.modelCollector);
            stateGen.registerParentedItemModel(buttonBlock, inventoryButton);
        }
        public void registerDoor(Block doorBlock) {
            stateGen.registerDoor(doorBlock);
        }
        public void registerFence(Block fenceBlock) {
            //models
            Identifier mainPost = Models.FENCE_POST.upload(fenceBlock, this.planksTextures, stateGen.modelCollector);
            Identifier sidePost = Models.FENCE_SIDE.upload(fenceBlock, this.planksTextures, stateGen.modelCollector);
            //blockstates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, mainPost, sidePost));
            //blockItem model
            Identifier inventoryPost = Models.FENCE_INVENTORY.upload(fenceBlock, this.planksTextures, stateGen.modelCollector);
            stateGen.registerParentedItemModel(fenceBlock, inventoryPost);
        }
        public void registerFenceGate(Block fenceGateBlock) {
            //models
            Identifier openGate = Models.TEMPLATE_FENCE_GATE_OPEN.upload(fenceGateBlock, this.planksTextures, stateGen.modelCollector);
            Identifier closedGate = Models.TEMPLATE_FENCE_GATE.upload(fenceGateBlock, this.planksTextures, stateGen.modelCollector);
            Identifier openWallGate = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(fenceGateBlock, this.planksTextures, stateGen.modelCollector);
            Identifier closedWallGate = Models.TEMPLATE_FENCE_GATE_WALL.upload(fenceGateBlock, this.planksTextures, stateGen.modelCollector);
            //blockstates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fenceGateBlock, openGate, closedGate, openWallGate, closedWallGate));
        }
        public void registerLeaves(Block leavesBlock) {
            //models
            Identifier leaves = Models.CUBE_ALL.upload(leavesBlock, TexturedModel.CUBE_ALL.get(leavesBlock).getTextures(), stateGen.modelCollector);
            //blockstates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(leavesBlock, leaves));
        }
        public void registerLog(Block logBlock) {
            //textures
            TextureMap texture = TextureMap.sideAndEndForTop(logBlock);
            //models
            Identifier logMain = Models.CUBE_COLUMN.upload(logBlock, texture, stateGen.modelCollector);
            Identifier logHorizontal = Models.CUBE_COLUMN_HORIZONTAL.upload(logBlock, texture, stateGen.modelCollector);
            //blockstates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createAxisRotatedBlockState(logBlock, logMain, logHorizontal));
        }
        public void registerPlanks(Block planksBlock) {
            this.planksModelId = Models.CUBE_ALL.upload(planksBlock, this.planksTextures, stateGen.modelCollector);
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(planksBlock, this.planksModelId));
        }
        public void registerPressurePlate(Block plateBlock) {
            Identifier plateUp = Models.PRESSURE_PLATE_UP.upload(plateBlock, this.planksTextures, stateGen.modelCollector);
            Identifier plateDown = Models.PRESSURE_PLATE_DOWN.upload(plateBlock, this.planksTextures, stateGen.modelCollector);
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(plateBlock, plateUp, plateDown));
        }
        public void registerSign(Block signBlock) {
            //check there is and get the wallSign asosiated with this sign
            Block wallSign;
            if ((wallSign = BLOCK_MAP.get(Variant.WALL_SIGN)) == null) {
                CraftedCuisine.LOGGER.error("No wallSign registered with the sign: " + signBlock);
                return;
            }
            //textures
            Identifier identifier = Models.PARTICLE.upload(signBlock, this.planksTextures, stateGen.modelCollector);
            //blockStates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(signBlock, identifier));
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(wallSign, identifier));
            //blockItems
            stateGen.registerItemModel(signBlock.asItem());
            stateGen.excludeFromSimpleItemModelGeneration(wallSign);
        }
        public void registerSlab(Block slabBlock) {
            if (this.planksModelId == null) {
                throw new IllegalStateException("Planks block not generated yet");
            }
            //models
            Identifier bottomSlab = Models.SLAB.upload(slabBlock, this.planksTextures, stateGen.modelCollector);
            Identifier topSlab = Models.SLAB_TOP.upload(slabBlock, this.planksTextures, stateGen.modelCollector);
            //blockStates
            this.stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, bottomSlab, topSlab, this.planksModelId));
            //itemModels
            this.stateGen.registerParentedItemModel(slabBlock, bottomSlab);
        }
        public void registerStairs(Block stairsBlock) {
            //models
            Identifier innerStairs = Models.INNER_STAIRS.upload(stairsBlock, this.planksTextures, stateGen.modelCollector);
            Identifier stairs = Models.STAIRS.upload(stairsBlock, this.planksTextures, stateGen.modelCollector);
            Identifier outerStairs = Models.OUTER_STAIRS.upload(stairsBlock, this.planksTextures, stateGen.modelCollector);
            //blockStates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairsBlock, innerStairs, stairs, outerStairs));
            //itemModel
            stateGen.registerParentedItemModel(stairsBlock, stairs);
        }
        public void registerWood(Block woodBlock, Block logBlock) {
            //textures
            TextureMap texture = TextureMap.sideEnd(TextureMap.getId(logBlock), TextureMap.getId(logBlock));
            //models
            Identifier woodMain = Models.CUBE_COLUMN.upload(woodBlock, texture, stateGen.modelCollector);
            Identifier woodHorizontal = Models.CUBE_COLUMN_HORIZONTAL.upload(woodBlock, texture, stateGen.modelCollector);
            //blockstates
            stateGen.blockStateCollector.accept(BlockStateModelGenerator.createAxisRotatedBlockState(woodBlock, woodMain, woodHorizontal));
        }
        public void registerTrapdoor(Block block) {
            stateGen.registerOrientableTrapdoor(block);
        }
    
        public static class Builder{
            WoodTypeModelGen builder;

            public Builder(BlockStateModelGenerator modelGen) {
                builder = new WoodTypeModelGen(modelGen);
            }

            public WoodTypeModelGen build() {
                return builder;
            }

            public Builder button(Block button) {
                builder.BLOCK_MAP.put(Variant.BUTTON, button);
                return this;
            }

            public Builder door(Block door) {
                builder.BLOCK_MAP.put(Variant.DOOR, door);
                return this;
            }

            public Builder fence(Block fence) {
                builder.BLOCK_MAP.put(Variant.FENCE, fence);
                return this;
            }

            public Builder fenceGate(Block fenceGate) {
                builder.BLOCK_MAP.put(Variant.FENCE_GATE, fenceGate);
                return this;
            }

            public Builder leaves(Block leaves) {
                builder.BLOCK_MAP.put(Variant.LEAVES, leaves);
                return this;
            }

            public Builder log(Block log) {
                builder.BLOCK_MAP.put(Variant.LOG, log);
                return this;
            }

            public Builder planks(Block planks) {
                builder.BLOCK_MAP.put(Variant.PLANKS, planks);
                builder.planksTextures = TexturedModel.CUBE_ALL.get(planks).getTextures();
                return this;
            }

            public Builder pressurePlate(Block pressurePlate) {
                builder.BLOCK_MAP.put(Variant.PRESSURE_PLATE, pressurePlate);
                return this;
            }

            public Builder sign(Block sign) {
                builder.BLOCK_MAP.put(Variant.SIGN, sign);
                return this;
            }

            public Builder slab(Block slab) {
                builder.BLOCK_MAP.put(Variant.SLAB, slab);
                return this;
            }

            public Builder stairs(Block stairs) {
                builder.BLOCK_MAP.put(Variant.STAIRS, stairs);
                return this;
            }

            public Builder strippedLog(Block strippedLog) {
                builder.BLOCK_MAP.put(Variant.STRIPPED_LOG, strippedLog);
                return this;
            }

            public Builder strippedWood(Block strippedWood) {
                builder.BLOCK_MAP.put(Variant.STRIPPED_WOOD, strippedWood);
                return this;
            }

            public Builder trapdoor(Block trapdoor) {
                builder.BLOCK_MAP.put(Variant.TRAPDOOR, trapdoor);
                return this;
            }

            public Builder wallSign(Block wallSign) {
                builder.BLOCK_MAP.put(Variant.WALL_SIGN, wallSign);
                return this;
            }

            public Builder wood(Block wood) {
                builder.BLOCK_MAP.put(Variant.WOOD, wood);
                return this;
            }
            
        }
        public static enum Variant {
            BUTTON("button"),
            DOOR("door"),
            FENCE("fence"),
            FENCE_GATE("fence_gate"),
            LEAVES("leaves"),
            LOG("log"),
            PLANKS("planks"),
            PRESSURE_PLATE("pressure_plate"),
            SIGN("sign"),
            SLAB("slab"),
            STAIRS("stairs"),
            STRIPPED_LOG("stripped_log"),
            STRIPPED_WOOD("stripped_wood"),
            TRAPDOOR("trapdoor"),
            WALL_SIGN("wall_sign"),
            WOOD("wood");
    
            private final String name;
    
            private Variant(String name) {
                this.name = name;
            }
    
            public String getName() {
                return this.name;
            }

        } 
    }

    static enum ModTintType {
        TINTED,
        NOT_TINTED;


        public Model getCrossModel() {
            return this == TINTED ? Models.TINTED_CROSS : Models.CROSS;
        }

        public Model getFlowerPotCrossModel() {
            return this == TINTED ? Models.TINTED_FLOWER_POT_CROSS : Models.FLOWER_POT_CROSS;
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator stateGen) {

        WoodTypeModelGen CINNAMON = new WoodTypeModelGen.Builder(stateGen)
            .button(AllBlocks.CINNAMON_BUTTON)
            .door(AllBlocks.CINNAMON_DOOR)
            .fence(AllBlocks.CINNAMON_FENCE)
            .fenceGate(AllBlocks.CINNAMON_FENCE_GATE)
            .leaves(AllBlocks.CINNAMON_LEAVES)
            .log(AllBlocks.CINNAMON_LOG)
            .planks(AllBlocks.CINNAMON_PLANKS)
            .pressurePlate(AllBlocks.CINNAMON_PRESSURE_PLATE)
            .sign(AllBlocks.CINNAMON_SIGN)
            .wallSign(AllBlocks.CINNAMON_WALL_SIGN)
            .slab(AllBlocks.CINNAMON_SLAB)
            .stairs(AllBlocks.CINNAMON_STAIRS)
            .strippedLog(AllBlocks.STRIPPED_CINNAMON_LOG)
            .strippedWood(AllBlocks.STRIPPED_CINNAMON_WOOD)
            .trapdoor(AllBlocks.CINNAMON_TRAPDOOR)
            .wood(AllBlocks.CINNAMON_WOOD)
            .build();
        CINNAMON.register();

        registerPetalCarpet(stateGen, AllBlocks.RED_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.ORANGE_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.YELLOW_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.LIME_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.GREEN_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.BLUE_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.LIGHT_BLUE_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.CYAN_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.PURPLE_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.MAGENTA_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.PINK_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.BLACK_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.GRAY_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.LIGHT_GRAY_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.WHITE_ROSE_CARPET);
        registerPetalCarpet(stateGen, AllBlocks.BROWN_ROSE_CARPET);

        stateGen.registerSimpleCubeAll(AllBlocks.REINFORCED_BLACKSTONE);
        stateGen.registerSimpleCubeAll(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL);
        stateGen.registerOrientableTrapdoor(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
        stateGen.registerDoor(AllBlocks.REINFORCED_BLACKSTONE_DOOR);
        registerBars(stateGen, (PaneBlock) AllBlocks.REINFORCED_BLACKSTONE_BARS);
        registerLadder(stateGen, (LadderBlock) AllBlocks.REINFORCED_BLACKSTONE_LADDER);
        registerLever(stateGen, (LeverBlock) AllBlocks.REINFORCED_BLACKSTONE_LEVER, TextureMap.getId(AllBlocks.REINFORCED_BLACKSTONE));
        registerRod(stateGen, (RodBlock) AllBlocks.REINFORCED_BLACKSTONE_ROD);

        registerTintableCross(stateGen, AllBlocks.FLOWER_STEM, ModTintType.NOT_TINTED);
        registerTintableCross(stateGen, AllBlocks.PINK_ROSE, ModTintType.NOT_TINTED);
        // registerFlowerPotPlant(stateGen, Blocks.DANDELION, Blocks.POTTED_DANDELION, TintType.NOT_TINTED); for when flower pot is added

        registerLayerBlock(stateGen, AllBlocks.SAW_DUST);
    }

    public final void registerPetalCarpet(BlockStateModelGenerator stateGen, Block petalCarpet) {
        //textures
        TextureMap textureMap = ModTextureMaps.petalBlocks(petalCarpet);
        //model
        Identifier carpet = ModModels.PETAL_CARPET.upload(petalCarpet, textureMap, stateGen.modelCollector);
        //state
        stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(petalCarpet, carpet));
    }
    public final void registerBars(BlockStateModelGenerator stateGen, PaneBlock bars) {
        TextureMap textureMap = ModTextureMaps.pane(bars);
        Identifier post = Models.TEMPLATE_GLASS_PANE_POST.upload(bars, textureMap, stateGen.modelCollector);
        Identifier side = Models.TEMPLATE_GLASS_PANE_SIDE.upload(bars, textureMap, stateGen.modelCollector);
        Identifier sideAlt = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(bars, textureMap, stateGen.modelCollector);
        Identifier noSide = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(bars, textureMap, stateGen.modelCollector);
        Identifier noSideAlt = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(bars, textureMap, stateGen.modelCollector);
        stateGen.registerItemModel(bars);
        stateGen.blockStateCollector.accept(MultipartBlockStateSupplier.create(bars).with(BlockStateVariant.create().put(VariantSettings.MODEL, post)).with((When)When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, side)).with((When)When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, side).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt)).with((When)When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSide)).with((When)When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSideAlt)).with((When)When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSide).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
    public final void registerLadder(BlockStateModelGenerator stateGen, LadderBlock block) {

        Identifier ladder = ModModels.LADDER.upload(block, ModTextureMaps.ladder(block), stateGen.modelCollector);

        stateGen.blockStateCollector.accept(VariantsBlockStateSupplier
            .create(block,BlockStateVariant.create().put(VariantSettings.MODEL, ladder))
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));

        stateGen.registerItemModel(block);
    }
    public final void registerLever(BlockStateModelGenerator stateGen, LeverBlock lever, Identifier baseTexture) {
        Identifier off = ModModels.LEVER.upload(lever, ModTextureMaps.lever(baseTexture, TextureMap.getId(lever)), stateGen.modelCollector);
        Identifier on = ModModels.LEVER_ON.upload(lever, ModTextureMaps.lever(baseTexture, TextureMap.getId(lever)), stateGen.modelCollector);
        stateGen.registerItemModel(lever);
        stateGen.blockStateCollector.accept(VariantsBlockStateSupplier.create(lever)
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.POWERED, off, on))
            .coordinate(BlockStateVariantMap.create(Properties.WALL_MOUNT_LOCATION, Properties.HORIZONTAL_FACING)
                .register(WallMountLocation.CEILING, Direction.NORTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(WallMountLocation.CEILING, Direction.EAST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(WallMountLocation.CEILING, Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180))
                .register(WallMountLocation.CEILING, Direction.WEST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(WallMountLocation.FLOOR, Direction.NORTH, BlockStateVariant.create())
                .register(WallMountLocation.FLOOR, Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(WallMountLocation.FLOOR, Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(WallMountLocation.FLOOR, Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(WallMountLocation.WALL, Direction.NORTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90))
                .register(WallMountLocation.WALL, Direction.EAST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(WallMountLocation.WALL, Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(WallMountLocation.WALL, Direction.WEST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270))
        ));
    }
    public final void registerRod(BlockStateModelGenerator stateGen, RodBlock block) {
        stateGen.registerRod(block);

        Identifier rod = ModModels.ROD.upload(block, ModTextureMaps.rod(block), stateGen.modelCollector);
        stateGen.registerParentedItemModel(block, rod);
    }
    public final void registerFlowerPotPlant(BlockStateModelGenerator stateGen, Block plantBlock, Block flowerPotBlock, ModTintType tintType) {
        this.registerTintableCross(stateGen, plantBlock, tintType);
        TextureMap textureMap = TextureMap.plant(plantBlock);
        Identifier identifier = tintType.getFlowerPotCrossModel().upload(flowerPotBlock, textureMap, stateGen.modelCollector);
        stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(flowerPotBlock, identifier));
    }
    public final void registerTintableCross(BlockStateModelGenerator stateGen, Block block, ModTintType tintType) {
        stateGen.registerItemModel(block);
        TextureMap crossTexture = TextureMap.cross(block);
        Identifier identifier = tintType.getCrossModel().upload(block, crossTexture, stateGen.modelCollector);
        stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, identifier));
    }
    public final void registerLayerBlock(BlockStateModelGenerator stateGen, Block layerBlock) {
        //textures
        TextureMap textureMap = TextureMap.all(layerBlock);
        //models
        Identifier fullCube = Models.CUBE_ALL.upload(layerBlock, textureMap, stateGen.modelCollector);

        for (int i = 1; i < 8; i++) {
            ModModels.getLayerModel(i*2).upload(layerBlock, ModTextureMaps.layerBlock(layerBlock), stateGen.modelCollector);
        }
        //blockStates
        stateGen.blockStateCollector.accept(VariantsBlockStateSupplier.create(layerBlock)
            .coordinate(BlockStateVariantMap.create(Properties.LAYERS)
                .register(integer -> BlockStateVariant.create().put(VariantSettings.MODEL, integer < 8 ? ModelIds.getBlockSubModelId(layerBlock, "_height" + integer * 2) : fullCube))));
        //ItemModels
        stateGen.registerItemModel(layerBlock.asItem());
    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGen) {
        registerSimpleItems(modelGen);
        registerHandheldItems(modelGen);
        registerBlockItems(modelGen);

        // withExistingParent(
        //     getItemPath(AllItems.CLOAK_SPAWN_EGG), new ResourceLocation("item/template_spawn_egg"));

        // withExistingParent(
        //     getItemPath(AllBlockItems.LEMON_TREE),
        //     new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        // .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        // .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        // .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lemon_tree_fruit_3"));

        // withExistingParent(
        //     getItemPath(AllBlockItems.LIME_TREE),
        //     new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        // .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        // .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        // .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lime_tree_fruit_3"));

        // withExistingParent(
        //     getItemPath(AllBlockItems.ORANGE_TREE),
        //     new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        // .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        // .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        // .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/orange_tree_fruit_3"));
    }

    private void registerSimpleItems(ItemModelGenerator modelGen) {
        modelGen.register(AllItems.OAK_BARK, Models.GENERATED);
        modelGen.register(AllItems.BIRCH_BARK, Models.GENERATED);
        modelGen.register(AllItems.SPRUCE_BARK, Models.GENERATED);
        modelGen.register(AllItems.JUNGLE_BARK, Models.GENERATED);
        modelGen.register(AllItems.ACACIA_BARK, Models.GENERATED);
        modelGen.register(AllItems.DARK_OAK_BARK, Models.GENERATED);
        modelGen.register(AllItems.CRIMSON_BARK, Models.GENERATED);
        modelGen.register(AllItems.WARPED_BARK, Models.GENERATED);
        modelGen.register(AllItems.CINNAMON_BARK, Models.GENERATED);
        modelGen.register(AllItems.UNKNOWN_BARK, Models.GENERATED);

        modelGen.register(AllItems.LEMON, Models.GENERATED);
        modelGen.register(AllItems.LIME, Models.GENERATED);
        modelGen.register(AllItems.ORANGE, Models.GENERATED);
        modelGen.register(AllItems.BLOOD_ORANGE, Models.GENERATED);
        modelGen.register(AllItems.MERINGUE, Models.GENERATED);
        modelGen.register(AllItems.CARAMEL, Models.GENERATED);

        modelGen.register(AllItems.RED_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.ORANGE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.YELLOW_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.LIME_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.GREEN_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.BLUE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.CYAN_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.LIGHT_BLUE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.PURPLE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.MAGENTA_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.PINK_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.BLACK_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.GRAY_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.LIGHT_GRAY_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.WHITE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.BROWN_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.SUGAR_ROSE_PETAL, Models.GENERATED);

        // modelGen.register(AllBlockItems.CINNAMON_SAPLING, Models.GENERATED);
        // modelGen.register(AllItems.CINNAMON_SIGN, Models.GENERATED);
        modelGen.register(AllItems.CINNAMON, Models.GENERATED);

        modelGen.register(AllItems.RAW_MERINGUE, Models.GENERATED);
        modelGen.register(AllItems.EGG_WHITE, Models.GENERATED);
        modelGen.register(AllItems.EGG_YOLK, Models.GENERATED);
        modelGen.register(AllItems.CRUSHED_CINNAMON, Models.GENERATED);
        modelGen.register(AllItems.BUTTER, Models.GENERATED);
        modelGen.register(AllItems.CREAM, Models.GENERATED);

        modelGen.register(AllItems.PAPER_PULP, Models.GENERATED);

        // modelGen.register(AllItems.CARAMEL_BUCKET, Models.GENERATED);

        modelGen.register(AllItems.REINFORCED_BLACKSTONE_INGOT, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_NUGGET, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_STICK, Models.GENERATED);
        // modelGen.register(AllItems.REINFORCED_BLACKSTONE_SHARD, Models.GENERATED);

        modelGen.register(AllItems.REINFORCED_BLACKSTONE_BOOTS, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_HELMET, Models.GENERATED);
    }

    private void registerHandheldItems(ItemModelGenerator modelGen) {
        // handheldItem(AllItems.BLOW_TORCH);
        // handheldItem(AllItems.BARK_REMOVER);
        // handheldItem(AllItems.WHISK);
        // handheldItem(AllItems.FLOWER_SEPERATOR);
        
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_SWORD, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_PICKAXE, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_AXE, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_SHOVEL, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_HOE, Models.HANDHELD);
    }

    private void registerBlockItems(ItemModelGenerator modelGen) {

    }
    
}
