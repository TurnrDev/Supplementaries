package net.mehvahdjukaar.supplementaries.common.block;

import com.mojang.datafixers.util.Pair;
import net.mehvahdjukaar.moonlight.api.block.MimicBlockTile;
import net.mehvahdjukaar.moonlight.api.client.model.ModelDataKey;
import net.mehvahdjukaar.moonlight.api.fluids.BuiltInSoftFluids;
import net.mehvahdjukaar.moonlight.api.fluids.SoftFluid;
import net.mehvahdjukaar.moonlight.api.fluids.SoftFluidRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.mehvahdjukaar.supplementaries.client.BlackboardManager;
import net.mehvahdjukaar.supplementaries.common.block.blocks.StickBlock;
import net.mehvahdjukaar.supplementaries.common.block.tiles.BookPileBlockTile;
import net.mehvahdjukaar.supplementaries.common.block.tiles.SignPostBlockTile;
import net.mehvahdjukaar.supplementaries.integration.CompatHandler;
import net.mehvahdjukaar.supplementaries.integration.DecoBlocksCompat;
import net.mehvahdjukaar.supplementaries.reg.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class ModBlockProperties {

    //BlockState properties
    public static final BooleanProperty EXTENDING = BooleanProperty.create("extending");
    public static final BooleanProperty HAS_WATER = BooleanProperty.create("has_water");
    public static final BooleanProperty CONNECTED = BooleanProperty.create("connected");
    public static final BooleanProperty KNOT = BooleanProperty.create("knot");
    public static final BooleanProperty TIPPED = BooleanProperty.create("tipped");
    public static final BooleanProperty FLIPPED = BooleanProperty.create("flipped");
    public static final BooleanProperty AXIS_Y = BooleanProperty.create("axis_y");
    public static final BooleanProperty AXIS_X = BooleanProperty.create("axis_x");
    public static final BooleanProperty AXIS_Z = BooleanProperty.create("axis_z");
    public static final BooleanProperty FLOOR = BooleanProperty.create("floor");
    public static final BooleanProperty LAVALOGGED = BooleanProperty.create("lavalogged");
    public static final BooleanProperty ANTIQUE = BooleanProperty.create("ye_olde");
    public static final BooleanProperty TREASURE = BooleanProperty.create("treasure");
    public static final BooleanProperty PACKED = BooleanProperty.create("packed");
    public static final BooleanProperty GLOWING = BooleanProperty.create("glowing");
    public static final BooleanProperty WATCHED = BooleanProperty.create("watched");
    public static final BooleanProperty CULLED = BooleanProperty.create("culled");
    public static final BooleanProperty HAS_BLOCK = BooleanProperty.create("has_block");
    public static final BooleanProperty ROTATING = BooleanProperty.create("rotating");

    public static final IntegerProperty HOUR = IntegerProperty.create("hour", 0, 23);
    public static final IntegerProperty LIGHT_LEVEL_0_15 = IntegerProperty.create("light_level", 0, 15);
    public static final IntegerProperty LIGHT_LEVEL_5_15 = IntegerProperty.create("light_level", 5, 15);
    public static final IntegerProperty LIGHT_LEVEL_0_7 = IntegerProperty.create("light_level", 0, 7);
    public static final IntegerProperty WIND_STRENGTH = IntegerProperty.create("wind_strength", 0, 3);
    public static final IntegerProperty OPENING_PROGRESS = IntegerProperty.create("opening_progress", 0, 2);
    public static final IntegerProperty PANCAKES_1_8 = IntegerProperty.create("pancakes", 1, 8);
    public static final IntegerProperty ROTATION_4 = IntegerProperty.create("rotation", 0, 4);
    public static final IntegerProperty HONEY_LEVEL_POT = IntegerProperty.create("honey_level", 0, 4);
    public static final IntegerProperty BURNING = IntegerProperty.create("burning", 0, 8);
    public static final IntegerProperty BOOKS = IntegerProperty.create("books", 1, 4);

    public static final EnumProperty<Topping> TOPPING = EnumProperty.create("topping", Topping.class);
    public static final EnumProperty<Winding> WINDING = EnumProperty.create("winding", Winding.class);
    public static final EnumProperty<PostType> POST_TYPE = EnumProperty.create("type", PostType.class);
    public static final EnumProperty<RakeDirection> RAKE_DIRECTION = EnumProperty.create("shape", RakeDirection.class);
    public static final EnumProperty<SignAttachment> SIGN_ATTACHMENT = EnumProperty.create("sign_attachment", SignAttachment.class);
    public static final EnumProperty<BlockAttachment> BLOCK_ATTACHMENT = EnumProperty.create("attachment", BlockAttachment.class);
    public static final EnumProperty<DisplayStatus> ITEM_STATUS = EnumProperty.create("item_status", DisplayStatus.class);
    public static final EnumProperty<Rune> RUNE = EnumProperty.create("rune", Rune.class);

    //model properties
    public static final ModelDataKey<BlockState> MIMIC = MimicBlockTile.MIMIC_KEY;
    public static final ModelDataKey<Boolean> FANCY = new ModelDataKey<>(Boolean.class);
    public static final ModelDataKey<Boolean> FRAMED = new ModelDataKey<>(Boolean.class);
    public static final ModelDataKey<Boolean> SLIM = new ModelDataKey<>(Boolean.class);
    public static final ModelDataKey<SignPostBlockTile.Sign> SIGN_UP = new ModelDataKey<>(SignPostBlockTile.Sign.class);
    public static final ModelDataKey<SignPostBlockTile.Sign> SIGN_DOWN = new ModelDataKey<>(SignPostBlockTile.Sign.class);
    public static final ModelDataKey<BlockState> FLOWER_0 = new ModelDataKey<>(BlockState.class);
    public static final ModelDataKey<BlockState> FLOWER_1 = new ModelDataKey<>(BlockState.class);
    public static final ModelDataKey<BlockState> FLOWER_2 = new ModelDataKey<>(BlockState.class);
    public static final ModelDataKey<SoftFluid> FLUID = new ModelDataKey<>(SoftFluid.class);
    public static final ModelDataKey<Integer> FLUID_COLOR = new ModelDataKey<>(Integer.class);
    public static final ModelDataKey<Float> FILL_LEVEL = new ModelDataKey<>(Float.class);
    public static final ModelDataKey<BlackboardManager.Key> BLACKBOARD = new ModelDataKey<>(BlackboardManager.Key.class);
    public static final ModelDataKey<BookPileBlockTile.BooksList> BOOKS_KEY = new ModelDataKey<>(BookPileBlockTile.BooksList.class);


    public enum PostType implements StringRepresentable {
        POST("post", 4),
        PALISADE("palisade", 6),
        WALL("wall", 8),
        BEAM("beam", 10);

        private final String name;
        private final int width;
        private final float offset;

        PostType(String name, int width) {
            this.name = name;
            this.width = width;
            this.offset = (8 - width / 2) / 16f;
        }

        public int getWidth() {
            return width;
        }

        public float getOffset() {
            return offset;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        @Nullable
        public static PostType get(BlockState state) {
            return get(state, false);
        }

        @Nullable
        public static PostType get(BlockState state, boolean needsFullHeight) {

            PostType type = null;
            //if (state.getBlock().hasTileEntity(state)) return type;
            if (state.is(ModTags.POSTS)) {
                if(!state.hasProperty(BlockStateProperties.AXIS) || state.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y) {
                    type = PostType.POST;
                }
            } else if (state.is(ModTags.PALISADES) || (CompatHandler.DECO_BLOCKS && DecoBlocksCompat.isPalisade(state))) {
                type = PostType.PALISADE;
            } else if (state.is(ModTags.WALLS)) {
                if ((state.getBlock() instanceof WallBlock) && !state.getValue(WallBlock.UP)) {
                    //ignoring not full height ones. might use hitbox here instead
                    if (needsFullHeight && (state.getValue(WallBlock.NORTH_WALL) == WallSide.LOW ||
                            state.getValue(WallBlock.WEST_WALL) == WallSide.LOW)) return null;
                    type = PostType.PALISADE;
                } else {
                    type = PostType.WALL;
                }
            } else if (state.is(ModTags.BEAMS)) {
                if (state.hasProperty(BlockStateProperties.ATTACHED) && state.getValue(BlockStateProperties.ATTACHED)) {
                    //idk why this was here
                    type = null;
                } else {
                    type = PostType.BEAM;
                }
            }

            return type;
        }

    }

    //for wall lanterns
    public enum BlockAttachment implements StringRepresentable {
        BLOCK("block"),
        BEAM("beam"),
        WALL("wall"),
        PALISADE("palisade"),
        POST("post"),
        STICK("stick");

        private final String name;

        BlockAttachment(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        @Nullable
        public static BlockAttachment get(BlockState state, BlockPos pos, LevelReader level, Direction facing) {
            if (state.isFaceSturdy(level, pos, facing)) return BLOCK;
            PostType postType = PostType.get(state, true);
            if (postType == null) {
                //case for sticks
                if ((state.getBlock() instanceof StickBlock &&
                        (facing.getAxis() == Direction.Axis.X ?
                                !state.getValue(StickBlock.AXIS_X) :
                                !state.getValue(StickBlock.AXIS_Z))) ||
                        (state.getBlock() instanceof EndRodBlock &&
                                state.getValue(EndRodBlock.FACING).getAxis() == Direction.Axis.Y)) return STICK;
                return null;
            }
            return switch (postType) {
                case BEAM -> BEAM;
                case WALL -> WALL;
                case PALISADE -> PALISADE;
                case POST -> POST;
            };
        }
    }

    public enum Topping implements StringRepresentable {
        NONE("none"),
        HONEY("honey"),
        SYRUP("syrup"),
        CHOCOLATE("chocolate"),
        JAM("jam");

        private final String name;

        Topping(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public static Pair<Topping, Item> fromFluidItem(Item item) {
            var s = SoftFluidRegistry.fromItem(item);
            if (s.isEmpty()) return null;
            var containers = s.getContainerList();
            var cat = containers.getCategoryFromFilled(item);
            if (cat.isEmpty() || cat.get().getAmount() != 1) return null;
            Topping t = fromFluid(s);
            if(t != NONE){
                return Pair.of(t, cat.get().getEmptyContainer());
            }
            return null;
        }

        public static Topping fromFluid(SoftFluid s) {
            if (s.isEmpty()) return NONE;
            if (s == BuiltInSoftFluids.HONEY.get()) {
                return HONEY;
            }
            String name = Utils.getID(s).getPath();
            if (name.contains("jam")) {
                return JAM;
            }
            if (name.equals("chocolate")) {
                return CHOCOLATE;
            }
            if (name.equals("syrup")) {
                return SYRUP;
            }
            return NONE;
        }

        //topping and empty item
        public static Pair<Topping, Item> fromItem(ItemStack stack) {
            Item item = stack.getItem();
            var ff = fromFluidItem(item);
            if (ff != null) return ff;
            if (stack.is(Items.SWEET_BERRIES)) return Pair.of(JAM, null);
            if (stack.is(ModTags.SYRUP)) return Pair.of(SYRUP, null);
            if (item instanceof HoneyBottleItem) return Pair.of(HONEY, null);
            var tag = BuiltInRegistries.ITEM.getTag(ModTags.CHOCOLATE_BARS);
            if ((item == Items.COCOA_BEANS && (tag.isEmpty() || tag.get().stream().findAny().isEmpty())) || stack.is(ModTags.CHOCOLATE_BARS)) {
                return Pair.of(CHOCOLATE, null);
            }
            return Pair.of(NONE, null);
        }
    }

    public enum Winding implements StringRepresentable {
        NONE("none"),
        CHAIN("chain"),
        ROPE("rope");

        private final String name;

        Winding(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

    public enum RakeDirection implements StringRepresentable {
        NORTH_SOUTH("north_south", Direction.NORTH, Direction.SOUTH),
        EAST_WEST("east_west", Direction.EAST, Direction.WEST),
        SOUTH_EAST("south_east", Direction.SOUTH, Direction.EAST),
        SOUTH_WEST("south_west", Direction.SOUTH, Direction.WEST),
        NORTH_WEST("north_west", Direction.NORTH, Direction.WEST),
        NORTH_EAST("north_east", Direction.NORTH, Direction.EAST);

        private final List<Direction> directions;
        private final String name;

        RakeDirection(String name, Direction dir1, Direction dir2) {
            this.name = name;
            this.directions = Arrays.asList(dir1, dir2);
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public List<Direction> getDirections() {
            return directions;
        }

        public static RakeDirection fromDirections(List<Direction> directions) {
            for (RakeDirection shape : values()) {
                if (new HashSet<>(shape.getDirections()).containsAll(directions)) return shape;
            }
            return directions.get(0).getAxis() == Direction.Axis.Z ? NORTH_SOUTH : EAST_WEST;
        }
    }

    public enum Rune implements StringRepresentable {
        A("a"),
        B("b"),
        C("c"),
        D("d"),
        E("e"),
        F("f"),
        G("g"),
        H("h"),
        I("i"),
        J("j"),
        K("k"),
        L("l"),
        M("m"),
        N("n"),
        O("o"),
        P("p"),
        Q("q"),
        R("r"),
        S("s"),
        T("t"),
        U("u"),
        V("v"),
        W("w"),
        X("x"),
        Y("y"),
        Z("z");

        private final String name;

        Rune(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }


    public enum SignAttachment implements StringRepresentable {
        CEILING("ceiling"),
        BLOCK_BLOCK(BlockAttachment.BLOCK, BlockAttachment.BLOCK),
        BLOCK_BEAM(BlockAttachment.BLOCK, BlockAttachment.BEAM),
        BLOCK_WALL(BlockAttachment.BLOCK, BlockAttachment.WALL),
        BLOCK_PALISADE(BlockAttachment.BLOCK, BlockAttachment.PALISADE),
        BLOCK_POST(BlockAttachment.BLOCK, BlockAttachment.POST),


        BEAM_BLOCK(BlockAttachment.BEAM, BlockAttachment.BLOCK),
        BEAM_BEAM(BlockAttachment.BEAM, BlockAttachment.BEAM),
        BEAM_WALL(BlockAttachment.BEAM, BlockAttachment.WALL),
        BEAM_PALISADE(BlockAttachment.BEAM, BlockAttachment.PALISADE),
        BEAM_POST(BlockAttachment.BEAM, BlockAttachment.POST),


        WALL_BLOCK(BlockAttachment.WALL, BlockAttachment.BLOCK),
        WALL_BEAM(BlockAttachment.WALL, BlockAttachment.BEAM),
        WALL_WALL(BlockAttachment.WALL, BlockAttachment.WALL),
        WALL_PALISADE(BlockAttachment.WALL, BlockAttachment.PALISADE),
        WALL_POST(BlockAttachment.WALL, BlockAttachment.POST),


        PALISADE_BLOCK(BlockAttachment.PALISADE, BlockAttachment.BLOCK),
        PALISADE_BEAM(BlockAttachment.PALISADE, BlockAttachment.BEAM),
        PALISADE_WALL(BlockAttachment.PALISADE, BlockAttachment.WALL),
        PALISADE_PALISADE(BlockAttachment.PALISADE, BlockAttachment.PALISADE),
        PALISADE_POST(BlockAttachment.PALISADE, BlockAttachment.POST),


        POST_BLOCK(BlockAttachment.POST, BlockAttachment.BLOCK),
        POST_BEAM(BlockAttachment.POST, BlockAttachment.BEAM),
        POST_WALL(BlockAttachment.POST, BlockAttachment.WALL),
        POST_PALISADE(BlockAttachment.POST, BlockAttachment.PALISADE),
        POST_POST(BlockAttachment.POST, BlockAttachment.POST),

        STICK_BLOCK(BlockAttachment.STICK, BlockAttachment.BLOCK),
        STICK_BEAM(BlockAttachment.STICK, BlockAttachment.BEAM),
        STICK_WALL(BlockAttachment.STICK, BlockAttachment.WALL),
        STICK_PALISADE(BlockAttachment.STICK, BlockAttachment.PALISADE),
        STICK_POST(BlockAttachment.STICK, BlockAttachment.POST),
        STICK_STICK(BlockAttachment.STICK, BlockAttachment.STICK),

        BLOCK_STICK(BlockAttachment.BLOCK, BlockAttachment.STICK),
        BEAM_STICK(BlockAttachment.BEAM, BlockAttachment.STICK),
        WALL_STICK(BlockAttachment.WALL, BlockAttachment.STICK),
        PALISADE_STICK(BlockAttachment.PALISADE, BlockAttachment.STICK),
        POST_STICK(BlockAttachment.POST, BlockAttachment.STICK);

        public final BlockAttachment left;
        public final BlockAttachment right;
        private final String name;

        SignAttachment(BlockAttachment left, BlockAttachment right) {
            this.name = left.name + "_" + right.name;
            this.left = left;
            this.right = right;
        }

        SignAttachment(String name) {
            this.name = name;
            this.left = BlockAttachment.BLOCK;
            this.right = BlockAttachment.BLOCK;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public SignAttachment withAttachment(boolean left, @Nullable BlockAttachment attachment) {
            if (attachment == null) attachment = BlockAttachment.BLOCK;
            String s = left ? attachment.name + "_" + this.right : this.left + "_" + attachment.name;
            return SignAttachment.valueOf(s.toUpperCase(Locale.ROOT));
        }

    }


    public enum DisplayStatus implements StringRepresentable {
        NONE, EMPTY, FULL;

        @Override
        public String toString() {
            return this.name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String getSerializedName() {
            return this.toString();
        }

        public boolean hasTile() {
            return this != NONE;
        }

        public boolean hasItem() {
            return this == FULL;
        }
    }

}
