package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.datagen.util.ModModels;
import com.moltenwolfcub.crafted_cuisine.datagen.util.ModTextureMaps;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.RodBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
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
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class ModModelProvider extends FabricModelProvider {
    private static ItemModelGenerator itemModelGen;
    private static BlockStateModelGenerator stateGen;

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
            Identifier leaves = Models.LEAVES.upload(leavesBlock, TexturedModel.CUBE_ALL.get(leavesBlock).getTextures(), stateGen.modelCollector);
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
    public void generateBlockStateModels(BlockStateModelGenerator blockStateGen) {
        stateGen = blockStateGen;

        WoodTypeModelGen CINNAMON = new WoodTypeModelGen.Builder(blockStateGen)
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
        registerFlowerPotPlant(AllBlocks.CINNAMON_SAPLING, AllBlocks.POTTED_CINNAMON_SAPLING, ModTintType.TINTED);

        registerPetalCarpet(AllBlocks.RED_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.ORANGE_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.YELLOW_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.LIME_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.GREEN_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.BLUE_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.LIGHT_BLUE_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.CYAN_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.PURPLE_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.MAGENTA_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.PINK_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.BLACK_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.GRAY_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.LIGHT_GRAY_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.WHITE_ROSE_CARPET);
        registerPetalCarpet(AllBlocks.BROWN_ROSE_CARPET);

        stateGen.registerSimpleCubeAll(AllBlocks.REINFORCED_BLACKSTONE);
        stateGen.registerSimpleCubeAll(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL);
        stateGen.registerOrientableTrapdoor(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
        stateGen.registerDoor(AllBlocks.REINFORCED_BLACKSTONE_DOOR);
        registerBars((PaneBlock) AllBlocks.REINFORCED_BLACKSTONE_BARS);
        registerLadder((LadderBlock) AllBlocks.REINFORCED_BLACKSTONE_LADDER);
        registerLever((LeverBlock) AllBlocks.REINFORCED_BLACKSTONE_LEVER, TextureMap.getId(AllBlocks.REINFORCED_BLACKSTONE));
        registerRod((RodBlock) AllBlocks.REINFORCED_BLACKSTONE_ROD);

        registerFlowerPotPlant(AllBlocks.FLOWER_STEM, AllBlocks.POTTED_FLOWER_STEM, ModTintType.NOT_TINTED);
        registerFlowerPotPlant(AllBlocks.PINK_ROSE, AllBlocks.POTTED_PINK_ROSE, ModTintType.NOT_TINTED);

        registerLayerBlock(AllBlocks.SAW_DUST);

        registerFruitTreeBlock((FruitTreeBlock)AllBlocks.LEMON_TREE);
        registerFruitTreeBlock((FruitTreeBlock)AllBlocks.LIME_TREE);
        registerFruitTreeBlock((FruitTreeBlock)AllBlocks.ORANGE_TREE);

        stateGen.registerSingleton(AllFluids.CARAMEL_BLOCK, ModTextureMaps.liquidBlock(new Identifier(CraftedCuisine.MODID, "block/caramel_still")), ModModels.FLUID);

        stateGen.registerNorthDefaultHorizontalRotation(AllBlocks.AUTO_BLOWTORCH);
    }

    public final void registerPetalCarpet(Block petalCarpet) {
        //textures
        TextureMap textureMap = ModTextureMaps.petalBlocks(petalCarpet);
        //model
        Identifier carpet = ModModels.PETAL_CARPET.upload(petalCarpet, textureMap, stateGen.modelCollector);
        //state
        stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(petalCarpet, carpet));
    }
    public final void registerBars(PaneBlock bars) {
        TextureMap textureMap = ModTextureMaps.pane(bars);
        Identifier post = Models.TEMPLATE_GLASS_PANE_POST.upload(bars, textureMap, stateGen.modelCollector);
        Identifier side = Models.TEMPLATE_GLASS_PANE_SIDE.upload(bars, textureMap, stateGen.modelCollector);
        Identifier sideAlt = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(bars, textureMap, stateGen.modelCollector);
        Identifier noSide = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(bars, textureMap, stateGen.modelCollector);
        Identifier noSideAlt = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(bars, textureMap, stateGen.modelCollector);
        stateGen.registerItemModel(bars);
        stateGen.blockStateCollector.accept(MultipartBlockStateSupplier.create(bars).with(BlockStateVariant.create().put(VariantSettings.MODEL, post)).with((When)When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, side)).with((When)When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, side).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt)).with((When)When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSide)).with((When)When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSideAlt)).with((When)When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, noSide).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
    public final void registerLadder(LadderBlock block) {

        Identifier ladder = ModModels.LADDER.upload(block, ModTextureMaps.ladder(block), stateGen.modelCollector);

        stateGen.blockStateCollector.accept(VariantsBlockStateSupplier
            .create(block,BlockStateVariant.create().put(VariantSettings.MODEL, ladder))
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));

        stateGen.registerItemModel(block);
    }
    public final void registerLever(LeverBlock lever, Identifier baseTexture) {
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
    public final void registerRod(RodBlock block) {
        stateGen.registerRod(block);

        Identifier rod = ModModels.ROD.upload(block, ModTextureMaps.rod(block), stateGen.modelCollector);
        stateGen.registerParentedItemModel(block, rod);
    }
    public final void registerFlowerPotPlant(Block plantBlock, Block flowerPotBlock, ModTintType tintType) {
        this.registerTintableCross(plantBlock, tintType);
        TextureMap textureMap = TextureMap.plant(plantBlock);
        Identifier identifier = tintType.getFlowerPotCrossModel().upload(flowerPotBlock, textureMap, stateGen.modelCollector);
        stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(flowerPotBlock, identifier));
    }
    public final void registerTintableCross(Block block, ModTintType tintType) {
        stateGen.registerItemModel(block);
        TextureMap crossTexture = TextureMap.cross(block);
        Identifier identifier = tintType.getCrossModel().upload(block, crossTexture, stateGen.modelCollector);
        stateGen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, identifier));
    }
    public final void registerLayerBlock(Block layerBlock) {
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
    
    public Identifier fruitTreeBlockModel(Block block, String parent, int ageTextureId, String half, Map<String, Identifier> existingModels) {
        TextureMap textureMap = ModTextureMaps.fruitTreeBlock(new Identifier(CraftedCuisine.MODID, "block/" + Registry.BLOCK.getId(block).getPath() + "_fruit_" + ageTextureId));
        String suffix = "_" + half + "_" + ageTextureId;
        Identifier id = existingModels.computeIfAbsent(Registry.BLOCK.getId(block).getPath() + suffix, (str) -> ModModels.getFruitTreeModel(parent).upload(block, suffix, textureMap, stateGen.modelCollector));
        return id;
    }
    public final void registerFruitTreeBlock(FruitTreeBlock block) {
        Map<String, Identifier> existingIds = new HashMap<>();

        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(Properties.AGE_5, Properties.DOUBLE_BLOCK_HALF).register(
            (age, blockHalf) -> {
                int ageTextureId;
                switch (age){
                    case 0: ageTextureId = 0; break;
                    case 1: ageTextureId = 1; break;
                    case 2: ageTextureId = 1; break;
                    case 3: ageTextureId = 2; break;
                    case 4: ageTextureId = 2; break;
                    case 5: ageTextureId = 3; break;
                    default: ageTextureId = 3; break;
                }
    
                String parent;
                switch (ageTextureId){
                    case 0: parent = "fruit_tree_" + blockHalf + "_no_fruit"; break;
                    case 1: parent = "fruit_tree_" + blockHalf + "_small_fruit"; break;
                    case 2: parent = "fruit_tree_" + blockHalf; break;
                    case 3: parent = "fruit_tree_" + blockHalf; break;
                    default: parent = "fruit_tree_" + blockHalf.toString(); break;
                }


                Identifier model = fruitTreeBlockModel(block, parent, ageTextureId, blockHalf == DoubleBlockHalf.LOWER ? "lower" : "upper", existingIds);
                return BlockStateVariant.create().put(VariantSettings.MODEL, model);
            }
        );

        stateGen.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(blockStateVariantMap));
    }



    @Override
    public void generateItemModels(ItemModelGenerator modelGen) {
        itemModelGen = modelGen;

        registerSimpleItems();
        registerHandheldItems();
        registerBlockItems();

        itemModelGen.register(AllItems.CLOAK_SPAWN_EGG, ModModels.SPAWN_EGG_ITEM);
    }

    private void registerSimpleItems() {
        itemModelGen.register(AllItems.OAK_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.BIRCH_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.SPRUCE_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.JUNGLE_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.ACACIA_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.DARK_OAK_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.CRIMSON_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.WARPED_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.CINNAMON_BARK, Models.GENERATED);
        itemModelGen.register(AllItems.UNKNOWN_BARK, Models.GENERATED);

        itemModelGen.register(AllItems.LEMON, Models.GENERATED);
        itemModelGen.register(AllItems.LIME, Models.GENERATED);
        itemModelGen.register(AllItems.ORANGE, Models.GENERATED);
        itemModelGen.register(AllItems.BLOOD_ORANGE, Models.GENERATED);
        itemModelGen.register(AllItems.MERINGUE, Models.GENERATED);
        itemModelGen.register(AllItems.CARAMEL, Models.GENERATED);

        itemModelGen.register(AllItems.RED_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.ORANGE_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.YELLOW_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.LIME_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.GREEN_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.BLUE_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.CYAN_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.LIGHT_BLUE_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.PURPLE_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.MAGENTA_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.PINK_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.BLACK_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.GRAY_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.LIGHT_GRAY_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.WHITE_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.BROWN_ROSE_PETAL, Models.GENERATED);
        itemModelGen.register(AllItems.SUGAR_ROSE_PETAL, Models.GENERATED);

        itemModelGen.register(AllItems.CINNAMON, Models.GENERATED);

        itemModelGen.register(AllItems.RAW_MERINGUE, Models.GENERATED);
        itemModelGen.register(AllItems.EGG_WHITE, Models.GENERATED);
        itemModelGen.register(AllItems.EGG_YOLK, Models.GENERATED);
        itemModelGen.register(AllItems.CRUSHED_CINNAMON, Models.GENERATED);
        itemModelGen.register(AllItems.BUTTER, Models.GENERATED);
        itemModelGen.register(AllItems.CREAM, Models.GENERATED);

        itemModelGen.register(AllItems.PAPER_PULP, Models.GENERATED);

        itemModelGen.register(AllItems.CARAMEL_BUCKET, Models.GENERATED);

        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_INGOT, Models.GENERATED);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_NUGGET, Models.GENERATED);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_STICK, Models.GENERATED);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_SHARD, Models.GENERATED);

        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_BOOTS, Models.GENERATED);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, Models.GENERATED);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, Models.GENERATED);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_HELMET, Models.GENERATED);
    }

    private void registerHandheldItems() {
        itemModelGen.register(AllItems.BLOW_TORCH, Models.HANDHELD);
        // handheldItem(AllItems.BARK_REMOVER);
        itemModelGen.register(AllItems.WHISK, Models.HANDHELD);
        // handheldItem(AllItems.FLOWER_SEPERATOR);
        
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_SWORD, Models.HANDHELD);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_PICKAXE, Models.HANDHELD);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_AXE, Models.HANDHELD);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_SHOVEL, Models.HANDHELD);
        itemModelGen.register(AllItems.REINFORCED_BLACKSTONE_HOE, Models.HANDHELD);
    }

    private void registerBlockItems() {
        registerFruitTreeItem(AllBlockItems.LEMON_TREE);
        registerFruitTreeItem(AllBlockItems.ORANGE_TREE);
        registerFruitTreeItem(AllBlockItems.LIME_TREE);

        registerBlockItem(AllBlocks.AUTO_BLOWTORCH);
    }


    public static void registerFruitTreeItem(Item treeItem) {
        TextureMap textureMap = ModTextureMaps.fruitTreeBlock(new Identifier(
            CraftedCuisine.MODID, "block/" + Registry.ITEM.getId(treeItem).getPath() + "_fruit_" + 3
        ));
        
        ModModels.FRUIT_TREE_ITEM.upload(
            ModelIds.getItemModelId(treeItem),
            textureMap,
            stateGen.modelCollector
        );
    }

    public static void registerBlockItem(Block block) {
        ModModels.getBlockItem(block)
            .upload(ModelIds.getItemModelId(block.asItem()), new TextureMap(), stateGen.modelCollector);

    }
    
}
