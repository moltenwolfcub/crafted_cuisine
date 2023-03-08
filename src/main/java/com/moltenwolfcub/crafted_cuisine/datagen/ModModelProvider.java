package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.CarameliserBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.datagen.util.ModModelTemplates;
import com.moltenwolfcub.crafted_cuisine.datagen.util.ModTextureMappings;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.Condition;
import net.minecraft.data.models.blockstates.MultiPartGenerator;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class ModModelProvider extends FabricModelProvider {
    private static ItemModelGenerators itemModelGen;
    private static BlockModelGenerators stateGen;

    public ModModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }



    public static class WoodTypeModelGen{
        Map<Variant, Block> BLOCK_MAP = new HashMap<>();
        BlockModelGenerators stateGen;

        TextureMapping planksTextures;
        ResourceLocation planksModelId;

        public WoodTypeModelGen(BlockModelGenerators stateGen) {
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
            ResourceLocation button = ModelTemplates.BUTTON.create(buttonBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation pressedButton = ModelTemplates.BUTTON_PRESSED.create(buttonBlock, this.planksTextures, stateGen.modelOutput);
            //blockstates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createButton(buttonBlock, button, pressedButton));
            //blockItem model
            ResourceLocation inventoryButton = ModelTemplates.BUTTON_INVENTORY.create(buttonBlock, this.planksTextures, stateGen.modelOutput);
            stateGen.delegateItemModel(buttonBlock, inventoryButton);
        }
        public void registerDoor(Block doorBlock) {
            stateGen.createDoor(doorBlock);
        }
        public void registerFence(Block fenceBlock) {
            //models
            ResourceLocation mainPost = ModelTemplates.FENCE_POST.create(fenceBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation sidePost = ModelTemplates.FENCE_SIDE.create(fenceBlock, this.planksTextures, stateGen.modelOutput);
            //blockstates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createFence(fenceBlock, mainPost, sidePost));
            //blockItem model
            ResourceLocation inventoryPost = ModelTemplates.FENCE_INVENTORY.create(fenceBlock, this.planksTextures, stateGen.modelOutput);
            stateGen.delegateItemModel(fenceBlock, inventoryPost);
        }
        public void registerFenceGate(Block fenceGateBlock) {
            //models
            ResourceLocation openGate = ModelTemplates.FENCE_GATE_OPEN.create(fenceGateBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation closedGate = ModelTemplates.FENCE_GATE_CLOSED.create(fenceGateBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation openWallGate = ModelTemplates.FENCE_GATE_WALL_OPEN.create(fenceGateBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation closedWallGate = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(fenceGateBlock, this.planksTextures, stateGen.modelOutput);
            //blockstates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createFenceGate(fenceGateBlock, openGate, closedGate, openWallGate, closedWallGate, true));
        }
        public void registerLeaves(Block leavesBlock) {
            //models
            ResourceLocation leaves = ModelTemplates.LEAVES.create(leavesBlock, TexturedModel.CUBE.get(leavesBlock).getMapping(), stateGen.modelOutput);
            //blockstates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(leavesBlock, leaves));
        }
        public void registerLog(Block logBlock) {
            //textures
            TextureMapping texture = TextureMapping.logColumn(logBlock);
            //models
            ResourceLocation logMain = ModelTemplates.CUBE_COLUMN.create(logBlock, texture, stateGen.modelOutput);
            ResourceLocation logHorizontal = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(logBlock, texture, stateGen.modelOutput);
            //blockstates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(logBlock, logMain, logHorizontal));
        }
        public void registerPlanks(Block planksBlock) {
            this.planksModelId = ModelTemplates.CUBE_ALL.create(planksBlock, this.planksTextures, stateGen.modelOutput);
            stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(planksBlock, this.planksModelId));
        }
        public void registerPressurePlate(Block plateBlock) {
            ResourceLocation plateUp = ModelTemplates.PRESSURE_PLATE_UP.create(plateBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation plateDown = ModelTemplates.PRESSURE_PLATE_DOWN.create(plateBlock, this.planksTextures, stateGen.modelOutput);
            stateGen.blockStateOutput.accept(BlockModelGenerators.createPressurePlate(plateBlock, plateUp, plateDown));
        }
        public void registerSign(Block signBlock) {
            //check there is and get the wallSign asosiated with this sign
            Block wallSign;
            if ((wallSign = BLOCK_MAP.get(Variant.WALL_SIGN)) == null) {
                CraftedCuisine.LOGGER.error("No wallSign registered with the sign: " + signBlock);
                return;
            }
            //textures
            ResourceLocation ResourceLocation = ModelTemplates.PARTICLE_ONLY.create(signBlock, this.planksTextures, stateGen.modelOutput);
            //blockStates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(signBlock, ResourceLocation));
            stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(wallSign, ResourceLocation));
            //blockItems
            stateGen.createSimpleFlatItemModel(signBlock.asItem());
            stateGen.skipAutoItemBlock(wallSign);
        }
        public void registerSlab(Block slabBlock) {
            if (this.planksModelId == null) {
                throw new IllegalStateException("Planks block not generated yet");
            }
            //models
            ResourceLocation bottomSlab = ModelTemplates.SLAB_BOTTOM.create(slabBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation topSlab = ModelTemplates.SLAB_TOP.create(slabBlock, this.planksTextures, stateGen.modelOutput);
            //blockStates
            this.stateGen.blockStateOutput.accept(BlockModelGenerators.createSlab(slabBlock, bottomSlab, topSlab, this.planksModelId));
            //itemModels
            this.stateGen.delegateItemModel(slabBlock, bottomSlab);
        }
        public void registerStairs(Block stairsBlock) {
            //models
            ResourceLocation innerStairs = ModelTemplates.STAIRS_INNER.create(stairsBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation stairs = ModelTemplates.STAIRS_STRAIGHT.create(stairsBlock, this.planksTextures, stateGen.modelOutput);
            ResourceLocation outerStairs = ModelTemplates.STAIRS_OUTER.create(stairsBlock, this.planksTextures, stateGen.modelOutput);
            //blockStates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createStairs(stairsBlock, innerStairs, stairs, outerStairs));
            //itemModel
            stateGen.delegateItemModel(stairsBlock, stairs);
        }
        public void registerWood(Block woodBlock, Block logBlock) {
            //textures
            TextureMapping texture = TextureMapping.column(TextureMapping.getBlockTexture(logBlock), TextureMapping.getBlockTexture(logBlock));
            //models
            ResourceLocation woodMain = ModelTemplates.CUBE_COLUMN.create(woodBlock, texture, stateGen.modelOutput);
            ResourceLocation woodHorizontal = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(woodBlock, texture, stateGen.modelOutput);
            //blockstates
            stateGen.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(woodBlock, woodMain, woodHorizontal));
        }
        public void registerTrapdoor(Block block) {
            stateGen.createOrientableTrapdoor(block);
        }
    
        public static class Builder{
            WoodTypeModelGen builder;

            public Builder(BlockModelGenerators modelGen) {
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
                builder.planksTextures = TexturedModel.CUBE.get(planks).getMapping();
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


        public ModelTemplate getCrossModel() {
            return this == TINTED ? ModelTemplates.TINTED_CROSS : ModelTemplates.CROSS;
        }

        public ModelTemplate getFlowerPotCrossModel() {
            return this == TINTED ? ModelTemplates.TINTED_FLOWER_POT_CROSS : ModelTemplates.FLOWER_POT_CROSS;
        }
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateGen) {
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

        stateGen.createTrivialCube(AllBlocks.REINFORCED_BLACKSTONE);
        stateGen.createTrivialCube(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL);
        stateGen.createOrientableTrapdoor(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
        stateGen.createDoor(AllBlocks.REINFORCED_BLACKSTONE_DOOR);
        registerBars((IronBarsBlock) AllBlocks.REINFORCED_BLACKSTONE_BARS);
        registerLadder((LadderBlock) AllBlocks.REINFORCED_BLACKSTONE_LADDER);
        registerLever((LeverBlock) AllBlocks.REINFORCED_BLACKSTONE_LEVER, TextureMapping.getBlockTexture(AllBlocks.REINFORCED_BLACKSTONE));
        registerRod((RodBlock) AllBlocks.REINFORCED_BLACKSTONE_ROD);

        registerFlowerPotPlant(AllBlocks.FLOWER_STEM, AllBlocks.POTTED_FLOWER_STEM, ModTintType.NOT_TINTED);
        registerFlowerPotPlant(AllBlocks.PINK_ROSE, AllBlocks.POTTED_PINK_ROSE, ModTintType.NOT_TINTED);

        registerLayerBlock(AllBlocks.SAW_DUST);

        registerFruitTreeBlock((FruitTreeBlock)AllBlocks.LEMON_TREE);
        registerFruitTreeBlock((FruitTreeBlock)AllBlocks.LIME_TREE);
        registerFruitTreeBlock((FruitTreeBlock)AllBlocks.ORANGE_TREE);

        stateGen.createTrivialBlock(AllFluids.CARAMEL_BLOCK, ModTextureMappings.liquidBlock(new ResourceLocation(CraftedCuisine.MODID, "block/caramel_still")), ModModelTemplates.FLUID);

        stateGen.createNonTemplateHorizontalBlock(AllBlocks.AUTO_BLOWTORCH);
        registerCarameliser((CarameliserBlock)AllBlocks.CARAMELISER);
    }

    public final void registerPetalCarpet(Block petalCarpet) {
        //textures
        TextureMapping textureMappiTextureMapping = ModTextureMappings.petalBlocks(petalCarpet);
        //model
        ResourceLocation carpet = ModModelTemplates.PETAL_CARPET.create(petalCarpet, textureMappiTextureMapping, stateGen.modelOutput);
        //state
        stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(petalCarpet, carpet));
    }
    public final void registerBars(IronBarsBlock bars) {
        TextureMapping textureMappiTextureMapping = ModTextureMappings.pane(bars);
        ResourceLocation post = ModelTemplates.STAINED_GLASS_PANE_POST.create(bars, textureMappiTextureMapping, stateGen.modelOutput);
        ResourceLocation side = ModelTemplates.STAINED_GLASS_PANE_SIDE.create(bars, textureMappiTextureMapping, stateGen.modelOutput);
        ResourceLocation sideAlt = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(bars, textureMappiTextureMapping, stateGen.modelOutput);
        ResourceLocation noSide = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(bars, textureMappiTextureMapping, stateGen.modelOutput);
        ResourceLocation noSideAlt = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(bars, textureMappiTextureMapping, stateGen.modelOutput);
        stateGen.createSimpleFlatItemModel(bars);
        stateGen.blockStateOutput.accept(MultiPartGenerator.multiPart(bars)
            .with(Variant.variant().with(VariantProperties.MODEL, post))
            .with((Condition)Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, side))
            .with((Condition)Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, side).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with((Condition)Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, sideAlt))
            .with((Condition)Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, sideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with((Condition)Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, noSide))
            .with((Condition)Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt))
            .with((Condition)Condition.condition().term(BlockStateProperties.SOUTH, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with((Condition)Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, noSide).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
    }
    public final void registerLadder(LadderBlock block) {

        ResourceLocation ladder = ModModelTemplates.LADDER.create(block, ModTextureMappings.ladder(block), stateGen.modelOutput);

        stateGen.blockStateOutput.accept(MultiVariantGenerator
            .multiVariant(block, Variant.variant().with(VariantProperties.MODEL, ladder))
            .with(BlockModelGenerators.createHorizontalFacingDispatch()));

        stateGen.createSimpleFlatItemModel(block);
    }
    public final void registerLever(LeverBlock lever, ResourceLocation baseTexture) {
        ResourceLocation off = ModModelTemplates.LEVER.create(lever, ModTextureMappings.lever(baseTexture, TextureMapping.getBlockTexture(lever)), stateGen.modelOutput);
        ResourceLocation on = ModModelTemplates.LEVER_ON.create(lever, ModTextureMappings.lever(baseTexture, TextureMapping.getBlockTexture(lever)), stateGen.modelOutput);
        stateGen.createSimpleFlatItemModel(lever);
        stateGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(lever)
            .with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.POWERED, off, on))
            .with(PropertyDispatch.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                .select(AttachFace.CEILING, Direction.NORTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(AttachFace.CEILING, Direction.EAST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(AttachFace.CEILING, Direction.SOUTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180))
                .select(AttachFace.CEILING, Direction.WEST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(AttachFace.FLOOR, Direction.NORTH, Variant.variant())
                .select(AttachFace.FLOOR, Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(AttachFace.FLOOR, Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(AttachFace.FLOOR, Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(AttachFace.WALL, Direction.NORTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
                .select(AttachFace.WALL, Direction.EAST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(AttachFace.WALL, Direction.SOUTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(AttachFace.WALL, Direction.WEST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
        ));
    }
    public final void registerRod(RodBlock block) {
        stateGen.createRotatableColumn(block);

        ResourceLocation rod = ModModelTemplates.ROD.create(block, ModTextureMappings.rod(block), stateGen.modelOutput);
        stateGen.delegateItemModel(block, rod);
    }
    public final void registerFlowerPotPlant(Block plantBlock, Block flowerPotBlock, ModTintType tintType) {
        this.registerTintableCross(plantBlock, tintType);
        TextureMapping textureMap = TextureMapping.plant(plantBlock);
        ResourceLocation identifier = tintType.getFlowerPotCrossModel().create(flowerPotBlock, textureMap, stateGen.modelOutput);
        stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPotBlock, identifier));
    }
    public final void registerTintableCross(Block block, ModTintType tintType) {
        stateGen.createSimpleFlatItemModel(block);
        TextureMapping crossTexture = TextureMapping.cross(block);
        ResourceLocation ResourceLocation = tintType.getCrossModel().create(block, crossTexture, stateGen.modelOutput);
        stateGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, ResourceLocation));
    }
    public final void registerLayerBlock(Block layerBlock) {
        //textures
        TextureMapping textureMappiTextureMapping = TextureMapping.cube(layerBlock);
        //models
        ResourceLocation fullCube = ModelTemplates.CUBE_ALL.create(layerBlock, textureMappiTextureMapping, stateGen.modelOutput);

        for (int i = 1; i < 8; i++) {
            ModModelTemplates.getLayerModel(i*2).create(layerBlock, ModTextureMappings.layerBlock(layerBlock), stateGen.modelOutput);
        }
        //blockStates
        stateGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(layerBlock)
            .with(PropertyDispatch.property(BlockStateProperties.LAYERS)
                .generate(integer -> Variant.variant().with(VariantProperties.MODEL, integer < 8 ? ModelLocationUtils.getModelLocation(layerBlock, "_height" + integer * 2) : fullCube))));
        //ItemModels
        stateGen.createSimpleFlatItemModel(layerBlock.asItem());
    }
    
    public ResourceLocation fruitTreeBlockModel(Block block, String parent, int ageTextureId, String half, Map<String, ResourceLocation> existingModels) {
        TextureMapping textureMappiTextureMapping = ModTextureMappings.fruitTreeBlock(new ResourceLocation(CraftedCuisine.MODID, "block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_fruit_" + ageTextureId));
        String suffix = "_" + half + "_" + ageTextureId;
        ResourceLocation id = existingModels.computeIfAbsent(BuiltInRegistries.BLOCK.getKey(block).getPath() + suffix, (str) -> ModModelTemplates.getFruitTreeModel(parent).createWithSuffix(block, suffix, textureMappiTextureMapping, stateGen.modelOutput));
        return id;
    }
    public final void registerFruitTreeBlock(FruitTreeBlock block) {
        Map<String, ResourceLocation> existingIds = new HashMap<>();

        PropertyDispatch blockStateVariantMap = PropertyDispatch.properties(BlockStateProperties.AGE_5, BlockStateProperties.DOUBLE_BLOCK_HALF).generate(
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


                ResourceLocation model = fruitTreeBlockModel(block, parent, ageTextureId, blockHalf == DoubleBlockHalf.LOWER ? "lower" : "upper", existingIds);
                return Variant.variant().with(VariantProperties.MODEL, model);
            }
        );

        stateGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(blockStateVariantMap));
    }

    public final void registerCarameliser(CarameliserBlock block) {
        ResourceLocation full = new ResourceLocation(CraftedCuisine.MODID, "block/full_carameliser");
        ResourceLocation empty = new ResourceLocation(CraftedCuisine.MODID, "block/carameliser");

        PropertyDispatch blockStateVariantMap = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, CarameliserBlock.FULL).generate(
                (direction, isFull) -> {
                    Variant stateVariant = Variant.variant();

                    VariantProperties.Rotation rot;
                    switch (direction){
                        default:
                            rot = VariantProperties.Rotation.R0; break;
                        case EAST:
                            rot = VariantProperties.Rotation.R90; break;
                        case SOUTH:
                            rot = VariantProperties.Rotation.R180; break;
                        case WEST:
                            rot = VariantProperties.Rotation.R270; break;

                    }

                    stateVariant.with(VariantProperties.MODEL, isFull? full: empty);
                    stateVariant.with(VariantProperties.Y_ROT, rot);

                    return stateVariant;
                }
            );
    
        stateGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(blockStateVariantMap));
    }


    @Override
    public void generateItemModels(ItemModelGenerators modelGen) {
        itemModelGen = modelGen;

        registerSimpleItems();
        registerHandheldItems();
        registerBlockItems();

        itemModelGen.generateFlatItem(AllItems.CLOAK_SPAWN_EGG, ModModelTemplates.SPAWN_EGG_ITEM);
    }

    private void registerSimpleItems() {
        itemModelGen.generateFlatItem(AllItems.OAK_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.BIRCH_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.SPRUCE_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.JUNGLE_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.ACACIA_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.DARK_OAK_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.CRIMSON_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.WARPED_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.CINNAMON_BARK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.UNKNOWN_BARK, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.LEMON, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.LIME, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.ORANGE, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.BLOOD_ORANGE, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.MERINGUE, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.CARAMEL, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.RED_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.ORANGE_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.YELLOW_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.LIME_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.GREEN_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.BLUE_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.CYAN_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.LIGHT_BLUE_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.PURPLE_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.MAGENTA_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.PINK_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.BLACK_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.GRAY_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.LIGHT_GRAY_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.WHITE_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.BROWN_ROSE_PETAL, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.SUGAR_ROSE_PETAL, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.CINNAMON, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.RAW_MERINGUE, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.EGG_WHITE, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.EGG_YOLK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.CRUSHED_CINNAMON, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.BUTTER, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.CREAM, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.PAPER_PULP, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.CARAMEL_BUCKET, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_STICK, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_SHARD, ModelTemplates.FLAT_ITEM);

        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_BOOTS, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_HELMET, ModelTemplates.FLAT_ITEM);
    }

    private void registerHandheldItems() {
        itemModelGen.generateFlatItem(AllItems.BARK_REMOVER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGen.generateFlatItem(AllItems.WHISK, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGen.generateFlatItem(AllItems.FLOWER_SEPARATOR, ModelTemplates.FLAT_HANDHELD_ITEM);
        
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGen.generateFlatItem(AllItems.REINFORCED_BLACKSTONE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    private void registerBlockItems() {
        registerFruitTreeItem(AllBlockItems.LEMON_TREE);
        registerFruitTreeItem(AllBlockItems.ORANGE_TREE);
        registerFruitTreeItem(AllBlockItems.LIME_TREE);

        registerBlockItem(AllBlocks.AUTO_BLOWTORCH);
        registerBlockItem(AllBlocks.CARAMELISER);
    }


    public static void registerFruitTreeItem(Item treeItem) {
        TextureMapping textureMappiTextureMapping = ModTextureMappings.fruitTreeBlock(new ResourceLocation(
            CraftedCuisine.MODID, "block/" + BuiltInRegistries.ITEM.getKey(treeItem).getPath() + "_fruit_" + 3
        ));
        
        ModModelTemplates.FRUIT_TREE_ITEM.create(
            ModelLocationUtils.getModelLocation(treeItem),
            textureMappiTextureMapping,
            stateGen.modelOutput
        );
    }

    public static void registerBlockItem(Block block) {
        ModModelTemplates.getBlockItem(block)
            .create(ModelLocationUtils.getModelLocation(block.asItem()), new TextureMapping(), stateGen.modelOutput);

    }
    
}
